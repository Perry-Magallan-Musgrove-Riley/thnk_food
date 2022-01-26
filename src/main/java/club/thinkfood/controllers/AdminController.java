package club.thinkfood.controllers;

import club.thinkfood.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

//    Should we change this to LoginController vs. adminController for naming purposes??
    @GetMapping("/login")
    public String showLoginForm(Model model, String username) {
        model.addAttribute("username", username);
        return "users/login";
    }

//    @PostMapping("/login")
//    public String goProfile(@PathVariable String username){
//        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return "redirect:/users/profile";
//    }

}
