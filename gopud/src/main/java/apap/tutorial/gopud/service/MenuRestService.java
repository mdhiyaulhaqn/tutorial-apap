package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.rest.MenuDetail;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MenuRestService {
    MenuModel createMenu(MenuModel menu);

    MenuModel getMenuByIdMenu(Long idMenu);

    MenuModel changeMenu(Long idMenu, MenuModel menuUpdate);

    List<MenuModel> retriveListMenu();

    void deleteMenu(Long idMenu);

    Mono<String> getMenuByChefName(String chefName);
}
