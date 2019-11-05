package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;

import java.util.List;

public interface MenuRestService {
    MenuModel createMenu(MenuModel menu);

    MenuModel getMenuByIdMenu(Long idMenu);

    MenuModel changeMenu(Long idMenu, MenuModel menuUpdate);

    List<MenuModel> retriveListMenu();

    void deleteMenu(Long idMenu);
}
