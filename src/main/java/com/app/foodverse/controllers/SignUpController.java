package com.app.foodverse.controllers;

import com.app.foodverse.dao.UserRepository;
import com.app.foodverse.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class SignUpController {

    @GetMapping("/signup")
    public String getSignUp(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User model, HttpSession session) throws SQLException {
        User user = new User(new UserRepository());
        User existingMobile = user.getUserByMobile(model.getMobile());
        User existingEmail = user.getUserByEmail(model.getEmail());
        if (existingEmail != null) {
            session.setAttribute("error", "Email already registered!");
        }
        else if (existingMobile != null) {
            session.setAttribute("error", "Mobile already registered!");
        }
        else {
            System.out.println(user.addUser(model));
            session.setAttribute("success", "Registered Successfully!!");
        }
        return "redirect:/signup";
    }
}
