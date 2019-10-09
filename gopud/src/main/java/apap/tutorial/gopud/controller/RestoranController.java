package apap.tutorial.gopud.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.RestoranService;

@Controller
public class RestoranController {
    @Qualifier("restoranServiceImpl")
    @Autowired
    private RestoranService restoranService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("titleTab", "Apap Tutorial");
        return "home";
    }

    //URL mapping add
    @RequestMapping(value = "/restoran/add", method = RequestMethod.GET)
    public String addRestoranFormPage(Model model){
        RestoranModel newRestoran = new RestoranModel();
        model.addAttribute("restoran", newRestoran);
        model.addAttribute("titleTab", "Add Restoran");
        return "form-add-restoran";
    }

    @RequestMapping(value = "/restoran/add", method = RequestMethod.POST)
    public String addRestoranFormSubmit(@ModelAttribute RestoranModel restoran, Model model){
        restoranService.addRestoran(restoran);
        model.addAttribute("namaResto", restoran.getNama());
        return "add-restoran";
    }

    //URL mapping view
    @RequestMapping(value = "/restoran/view", method = RequestMethod.GET)
    public String view(
            @RequestParam(value= "idRestoran") Long idRestoran,
            Model model
    ){
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();

        List<MenuModel> menuList = menuService.getListMenuOrderByHargaAsc(restoran.getIdRestoran());

        restoran.setListMenu(menuList);

        model.addAttribute("resto", restoran);
        model.addAttribute("titleTab", "View Restoran");

        return "view-restoran";
    }

    @RequestMapping(value="restoran/change/{idRestoran}", method = RequestMethod.GET)
    public String changeRestoranFormPage(@PathVariable Long idRestoran, Model model){
        //Mengambil existing data restoran
        RestoranModel existingRestoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        model.addAttribute("restoran", existingRestoran);
        model.addAttribute("titleTab", "Change Restoran");
        return "form-change-restoran";
    }

    @RequestMapping(value="restoran/change/{idRestoran}", method = RequestMethod.POST)
    public String changeRestoranFormSubmit(@PathVariable Long idRestoran, @ModelAttribute RestoranModel restoran, Model model){
        RestoranModel newRestoranData = restoranService.changeRestoran(restoran);
        model.addAttribute("restoran", newRestoranData);
        return "change-restoran";
    }

    //URL mapping viewAll
    @RequestMapping("/restoran/view-all")
    public String viewAll(Model model){
        List<RestoranModel> listRestoran = restoranService.getRestoranList();

        Collections.sort(listRestoran);

        model.addAttribute("restoList", listRestoran);
        model.addAttribute("titleTab", "View Restoran");

        return "viewall-restoran";
    }

    @RequestMapping(value = "/restoran/delete/id/{idRestoran}")
    public String deleteRestoran(
            @PathVariable(value = "idRestoran") Long idRestoran,
            Model model
    ){
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        model.addAttribute("restoran", restoran);
        boolean deleted = false;

        if(menuService.findAllMenuByIdRestoran(idRestoran).size() == 0){
            restoranService.delete(restoran);
            deleted = true;
        }

        model.addAttribute("isDeleted", deleted);
        return "delete-restoran";
    }
}
