package club.thinkfood.controllers;


import club.thinkfood.models.Image;
import club.thinkfood.models.User;
import club.thinkfood.repositories.ImageRepository;
import club.thinkfood.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditController {

    private UserRepository userDao;
    private ImageRepository imageDao;

    public EditController(UserRepository userDao, ImageRepository imageDao) {
        this.userDao = userDao;
        this.imageDao = imageDao;
    }


    @Value(("${filestack.api}"))
    private String filestack;

    @GetMapping("/edit")
    public String editProfile(Model model){
        model.addAttribute("filestack", filestack);
        return "/users/edit";
    }

    @PostMapping("/edit")
    public String saveProfilePicture(@ModelAttribute User user, @ModelAttribute Image image, @RequestParam(name = "imgPath") String imgPath){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userDao.findByUsername(loggedInUser.getUsername());
        Image profileImage = new Image();
        profileImage.setImg_path(imgPath);

        userDao.save(currentUser);
        return "redirect:/users/profile";
    }

}
