package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.repository.MenuDb;
import apap.tutorial.gopud.repository.RestoranDb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MenuServiceImplTest {
    @InjectMocks
    MenuService menuService = new MenuServiceImpl();

    @Mock
    MenuDb menuDb;

    @Test
    public void whenAddValidMenuItShouldCallMenuRepositorySave(){
        MenuModel newMenu = new MenuModel();
        RestoranModel newRestoran = new RestoranModel();
        newMenu.setNama("Ayam Bakar Kecap");
        newMenu.setDeskripsi("Ayam lagi ngebakar kecap");
        newMenu.setHarga(BigInteger.valueOf(10000));
        newMenu.setRestoran(newRestoran);

        menuService.addMenu(newMenu);
        verify(menuDb, times(1)).save(newMenu);
    }

    @Test
    public void whenGetAllMenuItShouldCallFindByRestoran(){
        RestoranModel restoran = new RestoranModel();
        restoran.setIdRestoran(1L);
        List<MenuModel> menuList = new ArrayList<>();
        restoran.setListMenu(menuList);
        for(int i = 0; i < 3; i++){
            MenuModel menuModel = new MenuModel();
            menuModel.setNama(String.valueOf(i));
            menuList.add(new MenuModel());
        }

        when(menuService.findAllMenuByIdRestoran(1L)).thenReturn(menuList);
        List<MenuModel> menuFromServiceCall = menuService.findAllMenuByIdRestoran(1L);
        verify(menuDb, times(1)).findByRestoranIdRestoran(1L);

        assertEquals(3, menuFromServiceCall.size());
    }

    @Test
    public void whenGetMenuByIdMenuItShouldCallFindById(){
        MenuModel returnedData = new MenuModel();
        returnedData.setNama("Bakso Goreng");
        returnedData.setHarga(BigInteger.valueOf(1000));
        returnedData.setDeskripsi("Tanpa boraks");
        returnedData.setDurasiMasak(10000);
        returnedData.setId((long)1);

        when(menuService.getMenuByIdMenu(1L)).thenReturn(Optional.of(returnedData));

        Optional<MenuModel> dataFromServiceCall = menuService.getMenuByIdMenu(1L);

        verify(menuDb, times(1)).findById(1L);

        assertTrue(dataFromServiceCall.isPresent());

        MenuModel dataFromOptional = dataFromServiceCall.get();
        assertEquals("Bakso Goreng", dataFromOptional.getNama());
        assertEquals(BigInteger.valueOf(1000), dataFromOptional.getHarga());
        assertEquals("Tanpa boraks", dataFromOptional.getDeskripsi());
    }

    @Test(expected=NullPointerException.class)
    public void whenChangeMenuItShouldChangeMenuData(){
        MenuModel updatedData = new MenuModel();
        updatedData.setNama("Bakso Goreng");
        updatedData.setHarga(BigInteger.valueOf(1000));
        updatedData.setDeskripsi("Tanpa boraks");
        updatedData.setDurasiMasak(10000);
        updatedData.setId((long)1);

        when(menuDb.findById(1L)).thenReturn(Optional.of(updatedData));
        when(menuService.changeMenu(updatedData)).thenReturn(updatedData);
        when(menuService.changeMenu(updatedData)).thenThrow(new NullPointerException());

        MenuModel dataFromServiceCall = menuService.changeMenu(updatedData);

        assertEquals("Bakso Goreng", dataFromServiceCall.getNama());
        assertEquals(BigInteger.valueOf(1000), dataFromServiceCall.getHarga());
        assertEquals("Tanpa boraks", dataFromServiceCall.getDeskripsi());
        assertEquals((long) 10000, (long)dataFromServiceCall.getDurasiMasak());
    }

    @Test
    public void whenDeleteMenuItShouldDeleteMenuData(){
        MenuModel deletedData = new MenuModel();
        deletedData.setNama("Bakso Goreng");
        deletedData.setId((long)1);

        menuService.addMenu(deletedData);
        Optional<MenuModel> dataFromServiceCall = menuService.getMenuByIdMenu(1L);

        assertNotNull(dataFromServiceCall);

        menuService.delete(deletedData);
        verify(menuDb, times(1)).delete(deletedData);

        assertEquals(Optional.empty(), menuService.getMenuByIdMenu(1L));
    }

    @Test
    public void whenGetListMenuItShouldFindMenuOrderByHargaAsc(){
        RestoranModel restoran = new RestoranModel();
        restoran.setIdRestoran(1L);
        List<MenuModel> allMenu = new ArrayList<>();
        restoran.setListMenu(allMenu);

        for (int loopTimes = 3; loopTimes > 0; loopTimes--) {
            allMenu.add(new MenuModel());
        }
        when (menuService.getListMenuOrderByHargaAsc(1L)).thenReturn(allMenu);

        List<MenuModel> dataFromServiceCall = menuService.getListMenuOrderByHargaAsc(1L);
        assertEquals(3, dataFromServiceCall.size());

        verify(menuDb, times(1)).findByRestoranIdRestoranOrderByHargaAsc(1L);
    }
}
