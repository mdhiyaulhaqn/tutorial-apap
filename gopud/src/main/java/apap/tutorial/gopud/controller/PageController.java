package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.UserModel;
import apap.tutorial.gopud.service.RoleService;
import apap.tutorial.gopud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("titleTab", "Apap Tutorial");
        model.addAttribute("listRole", roleService.findAll());
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping(value = "/update-password")
    public String formUpdate(){
        return "update-password";
    }

    @RequestMapping(value = "/update-password", method = RequestMethod.POST)
    public String updatePassword(
            @RequestParam("passwordLama") String passwordLama,
            @RequestParam("passwordBaru") String passwordBaru,
            @RequestParam("passwordBaruKonfirmasi") String passwordBaruKonfirmasi,
                                             Authentication auth,
                                             Model model){
        UserModel userModel = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        UserModel user = userService.findByUsername(auth.getName());

        String status = userService.isValid(user, passwordLama, passwordBaru, passwordBaruKonfirmasi);

        model.addAttribute("status", status);
        model.addAttribute("titleTab", "Apap Tutorial");

        return "update-password";
    }
}
