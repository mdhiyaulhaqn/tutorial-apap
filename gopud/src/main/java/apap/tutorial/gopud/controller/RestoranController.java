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
    public String home() {return "home";}

    //URL mapping add
    @RequestMapping(value = "/restoran/add", method = RequestMethod.GET)
    public String addRestoranFormPage(Model model){
        RestoranModel newRestoran = new RestoranModel();
        model.addAttribute("restoran", newRestoran);
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

        model.addAttribute("resto", restoran);

        List<MenuModel> menuList = menuService.findAllMenuByIdRestoran(restoran.getIdRestoran());
        model.addAttribute("menuList", menuList);

        return "view-restoran";
    }

    @RequestMapping(value="restoran/change/{idRestoran}", method = RequestMethod.GET)
    public String changeRestoranFormPage(@PathVariable Long idRestoran, Model model){
        //Mengambil existing data restoran
        RestoranModel existingRestoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        model.addAttribute("restoran", existingRestoran);
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
//
//    //LATIHAN
//    //Get Mapping view
//    @GetMapping(value = "/restoran/view/id-restoran/{idRestoran}")
//    public String viewWithPathVariable(
//            @PathVariable(value = "idRestoran") String idRestoran,
//            Model model
//    ){
//        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
//
//        model.addAttribute("resto", restoran);
//
//        return "view-restoran";
//    }
//
//    @GetMapping(value = "/restoran/update/id-restoran/{idRestoran}/nomor-telepon/{nomorTelepon}")
//    public String updateNomorTelepon(
//            @PathVariable(value = "idRestoran") String idRestoran,
//            @PathVariable(value = "nomorTelepon") Integer nomorTelepon,
//            Model model
//    ){
//        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
//        model.addAttribute("nomorLama", restoran.getNomorTelepon());
//
//        restoran.setNomorTelepon(nomorTelepon);
//
//        model.addAttribute("nomorBaru", nomorTelepon);
//        model.addAttribute("namaResto", restoran.getNama());
//
//        return "update-notelp-restoran";
//    }
//
//    @GetMapping(value = "/restoran/delete/id/{idRestoran}")
//    public String deleteRestoran(
//            @PathVariable(value = "idRestoran") String idRestoran,
//            Model model
//    ){
////        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
////        model.addAttribute("restoran", restoran);
//
//        RestoranModel restoran = restoranService.deleteRestoranByIdRestoran(idRestoran);
//
//        model.addAttribute("idRestoran", idRestoran);
//        model.addAttribute("restoran", restoran);
//        return "delete-restoran";
//    }

}
