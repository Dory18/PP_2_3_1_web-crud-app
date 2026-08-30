package org.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.web.model.User;
import org.web.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUser(@RequestParam(value = "count", required = false) Integer count,
                             @RequestParam(value = "page", required = false) Integer page,
                             ModelMap model) {
        List<User> userList = userService.findAll(count);
        model.addAttribute("userList", userList);
        return "user_page/users";
    }

    @GetMapping("/user")
    public String getUserById(@RequestParam(value = "id") Long id,
                              ModelMap model) {

        model.addAttribute("user", userService.findById(id));
        return "user_page/user";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam(value = "id") Long id,
                           ModelMap model) {
        model.addAttribute("user", userService.findById(id));
        return "user_page/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_page/edit";
        }
        userService.updateById(user);
        return "redirect:/users";
    }

    @GetMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        return "user_page/create";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_page/create";
        }
        userService.save(user);
        return "redirect:/users";
    }
}
