package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.MenuDb;
import apap.tutorial.gopud.rest.MenuDetail;
import apap.tutorial.gopud.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.awt.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class MenuRestServiceImpl implements MenuRestService {
    private final WebClient webClient;

    @Autowired
    MenuDb menuDb;

    public MenuRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl(Setting.restoranurl).build();
    }

    @Override
    public MenuModel createMenu(MenuModel menu) {
        return menuDb.save(menu);
    }

    @Override
    public MenuModel getMenuByIdMenu(Long idMenu) {
        Optional<MenuModel> menu = menuDb.findById(idMenu);
        if(menu.isPresent()){
            return menu.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public MenuModel changeMenu(Long idMenu, MenuModel menuUpdate) {
        MenuModel menu = getMenuByIdMenu(idMenu);
        menu.setNama(menuUpdate.getNama());
        menu.setDurasiMasak(menuUpdate.getDurasiMasak());
        menu.setDeskripsi(menuUpdate.getDeskripsi());
        menu.setHarga(menuUpdate.getHarga());
        return menuDb.save(menu);
    }

    @Override
    public List<MenuModel> retriveListMenu() {
        return menuDb.findAll();
    }

    @Override
    public void deleteMenu(Long idMenu) {
        MenuModel menu = getMenuByIdMenu(idMenu);
        menuDb.delete(menu);
    }

    @Override
    public Mono<String> getMenuByChefName(String chefName) {
        return this.webClient.get().uri("/api/v1/restoran/chef?nama"+chefName)
                .retrieve().bodyToMono(String.class);
    }
}