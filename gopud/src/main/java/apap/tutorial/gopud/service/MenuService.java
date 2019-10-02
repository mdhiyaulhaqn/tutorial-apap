package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    void addMenu(MenuModel menu);

    List<MenuModel> findAllMenuByIdRestoran(Long idRestoran);

    MenuModel changeMenu(MenuModel menuModel);

    Optional<MenuModel> getMenuByIdMenu(Long idMenu);

    void delete(MenuModel menu);

    List<MenuModel> getListMenuOrderByHargaAsc(Long idRestoran);
}
