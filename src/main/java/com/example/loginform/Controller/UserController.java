package com.example.loginform.Controller;

import com.example.loginform.Entity.User;
import com.example.loginform.Service.UserService;
import com.example.loginform.Service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private UserServiceImp userService;

    User user = new User();

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("name") String name, RedirectAttributes redirectAttributes) {

        user.setName(name);
        userService.saveUser(user); // Save the user to the database
        httpSession.setAttribute("name", name);
        System.out.println(user.getName());
        // No need to add redirect attributes
        return "redirect:/index"; // Redirect to the external page URL
    }

    @GetMapping("/indexs") // Define mapping for the external page
    public String redirectToExternalPage() {
        // Return JavaScript to redirect to the external page
        return "index";
    }

    @GetMapping("/index")
    public String anime(Model model) {
        System.out.println("NAME"+user.getName());
        model.addAttribute("users",user.getName());
        return "index";
    }
    @GetMapping("/anime")
    public String showAnimePage() {
        return "anime";
    }

    @GetMapping("/brand")
    public String showBrandPage() {
        return "brand";
    }
    @GetMapping("/places")
    public String showPlacesPage() {
        return "places";
    }
    @GetMapping("/about")
    public String showAboutPage() {
        return "about";
    }
    @GetMapping("/team")
    public String showTeamPage() {
        return "team";
    }
    @GetMapping("/program")
    public String showProgramPage() {
        return "programs";
    }
    @GetMapping("/aptitude")
    public String showAptitudePage() {
        return "aptitude";
    }
    @GetMapping("/gk")
    public String showGkPage() {
        return "gk";
    }

    @GetMapping("/display")
    public String viewData(ModelAndView modelAndView){
        modelAndView.addObject("users",userService.getUserList());
        return "index";
    }
    






}
