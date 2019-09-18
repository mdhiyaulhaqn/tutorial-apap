package apap.tutorial.gopud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.RestoranService;

@Controller
public class RestoranController {

    @Autowired
    private RestoranService restoranService;

    //URL mapping add
    @RequestMapping("/restoran/add")
    public String add(
            @RequestParam(value= "idRestoran", required = true) String idRestoran,
            @RequestParam(value= "nama", required = true) String nama,
            @RequestParam(value= "alamat", required = true) String alamat,
            @RequestParam(value= "nomorTelepon", required = true) Integer nomorTelepon,
            Model model
    ){
        RestoranModel restoran = new RestoranModel(idRestoran, nama, alamat, nomorTelepon);

        restoranService.addRestoran(restoran);

        model.addAttribute("namaResto", nama);

        return "add-restoran";
    }

    //URL mapping view
    @RequestMapping("/restoran/view")
    public String view(
            @RequestParam(value= "idRestoran", required = true) String idRestoran,
            Model model
    ){
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);

        model.addAttribute("resto", restoran);

        return "view-restoran";
    }

    //URL mapping viewAll
    @RequestMapping("/restoran/viewall")
    public String viewAll(Model model){
        List<RestoranModel> listRestoran = restoranService.getRestoranList();

        model.addAttribute("restoList", listRestoran);

        return "viewall-restoran";
    }

    //LATIHAN
    //Get Mapping view
    @GetMapping(value = "/restoran/view/id-restoran/{idRestoran}")
    public String viewWithPathVariable(
            @PathVariable(value = "idRestoran") String idRestoran,
            Model model
    ){
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);

        model.addAttribute("resto", restoran);

        return "view-restoran";
    }

    @GetMapping(value = "/restoran/update/id-restoran/{idRestoran}/nomor-telepon/{nomorTelepon}")
    public String updateNomorTelepon(
            @PathVariable(value = "idRestoran") String idRestoran,
            @PathVariable(value = "nomorTelepon") Integer nomorTelepon,
            Model model
    ){
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
        model.addAttribute("nomorLama", restoran.getNomorTelepon());

        restoran.setNomorTelepon(nomorTelepon);

        model.addAttribute("nomorBaru", nomorTelepon);
        model.addAttribute("namaResto", restoran.getNama());

        return "update-notelp-restoran";
    }

    @GetMapping(value = "/restoran/delete/id/{idRestoran}")
    public String deleteRestoran(
            @PathVariable(value = "idRestoran") String idRestoran,
            Model model
    ){
//        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
//        model.addAttribute("restoran", restoran);

        RestoranModel restoran = restoranService.deleteRestoranByIdRestoran(idRestoran);

        model.addAttribute("idRestoran", idRestoran);
        model.addAttribute("restoran", restoran);
        return "delete-restoran";
    }

}
