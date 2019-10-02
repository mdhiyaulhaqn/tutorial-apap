package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.MenuService;
import apap.tutorial.gopud.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class MenuController {
    @Autowired
    MenuService menuService;

    @Qualifier("restoranServiceImpl")
    @Autowired
    RestoranService restoranService;

    @RequestMapping(value = "/menu/add/{idRestoran}")
    private String add(@PathVariable(value = "idRestoran") Long idRestoran, Model model) {
        model.addAttribute("titleTab", "Add Menu");
        RestoranModel restoran = new RestoranModel();
        restoran.setListMenu(new ArrayList<MenuModel>());
        restoran.getListMenu().add(new MenuModel());
        model.addAttribute("restoran", restoran);
        model.addAttribute("idRestoran", idRestoran);
        return "form-add-menu";
    }

    @RequestMapping(value = "/menu/add/{idRestoran}", method = RequestMethod.POST, params= {"save"})
    private String addMenuSubmit(@PathVariable(value = "idRestoran") Long idRestoran, @ModelAttribute RestoranModel restoran, ModelMap model) {
        model.addAttribute("titleTab", "Add Menu");
        RestoranModel oldRestoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        model.addAttribute("idRestoran", idRestoran);
        for (MenuModel menu : restoran.getListMenu()) {
            menu.setRestoran(oldRestoran);
            menuService.addMenu(menu);
        }
        model.clear();
        return "add-menu";
    }

    @RequestMapping(value = "/menu/add/{idRestoran}", method = RequestMethod.POST, params={"addRow"})
    private String addRow(@PathVariable(value = "idRestoran") Long idRestoran,@ModelAttribute RestoranModel restoran, Model model) {
        model.addAttribute("titleTab", "Add Menu");
        MenuModel menu = new MenuModel();
        restoran.getListMenu().add(menu);
        model.addAttribute("restoran", restoran);
        model.addAttribute("idRestoran", idRestoran);
        return "form-add-menu";
    }

    @RequestMapping(value = "/menu/add/{idRestoran}", method = RequestMethod.POST, params={"removeRow"})
    private String removeRow(@PathVariable(value = "idRestoran") Long idRestoran,@ModelAttribute RestoranModel restoran, Model model, HttpServletRequest req) {
        Integer rowId =  Integer.valueOf(req.getParameter("removeRow"));
        restoran.getListMenu().remove(rowId.intValue());
        model.addAttribute("restoran", restoran);
        model.addAttribute("idRestoran", idRestoran);
        return "form-add-menu";
    }

    @RequestMapping(value = "menu/change/{idMenu}", method = RequestMethod.GET)
    public String changeMenuFormPage(@PathVariable Long idMenu, Model model){
        MenuModel existingMenu = menuService.getMenuByIdMenu(idMenu).get();
        model.addAttribute("menu", existingMenu);
        model.addAttribute("titleTab", "Change Menu");
        return "form-change-menu";
    }

    @RequestMapping(value = "menu/change/{idMenu}", method = RequestMethod.POST)
    public String changeMenuFormSubmit(@PathVariable Long idMenu, @ModelAttribute MenuModel menu, Model model){
        MenuModel newMenuData = menuService.changeMenu(menu);
        model.addAttribute("menu", newMenuData);
        return "change-menu";
    }

    @RequestMapping(value = "/menu/delete/{idMenu}")
    public String deleteMenu(
            @PathVariable(value = "idMenu") Long idMenu,
            Model model
    ){
        MenuModel menu = menuService.getMenuByIdMenu(idMenu).get();
        model.addAttribute("menu", menu);
        model.addAttribute("titleTab", "Delete Menu");

        menuService.delete(menu);
        return "delete-menu";
    }

    @RequestMapping(value = "/menu/delete", method = RequestMethod.POST)
    private String delete(@ModelAttribute RestoranModel restoran, Model model){
        for(MenuModel menu: restoran.getListMenu()){
            menuService.delete(menu);
        }
        return "delete";
    }
}