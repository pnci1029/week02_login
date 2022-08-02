package com.sparta.springcore.controller;

import com.sparta.springcore.model.UserRoleEnum;
import com.sparta.springcore.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());

            if (userDetails.getUser().getRole() == UserRoleEnum.ADMIN) {
                model.addAttribute("admin_role", true);
            }
        }

        return "index";
    }
}