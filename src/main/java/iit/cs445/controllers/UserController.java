package iit.cs445.controllers;

import iit.cs445.exceptions.DuplicateEmailException;
import iit.cs445.models.users.User;
import iit.cs445.models.users.UserService;
import iit.cs445.validators.UserFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserFormValidator userFormValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userFormValidator);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/listAll", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<User> list = new User().listAll();
        model.addAttribute("users", list);
        return "users/list";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated User user,
                                   BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            Logger.getLogger(UserController.class.getName()).log(Level.INFO, "Result has errors");
            return "users/userform";
        } else {
            Long id = user.getId();
            if(id == null || id < 1){
                try {
                    userService.registerNewUser(user);
                    Logger.getLogger(UserController.class.getName()).log(Level.INFO, "Registering " + user.toString());
                    redirectAttributes.addFlashAttribute("msg", "User added successfully!");
                } catch (DuplicateEmailException e) {
                    e.printStackTrace();
                }
            }else{
                Logger.getLogger(UserController.class.getName()).log(Level.INFO, "Updating " + user.toString());
                userService.updateUser(user);
            }
            return "redirect:/users/listAll";
        }
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String showAddUserForm(Model model) {
        User user = new User();
        model.addAttribute("userForm", user);
        return "users/userform";

    }

    @RequestMapping(value = "/users/{id}/update", method = RequestMethod.GET)
    public String showUpdateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("userForm", user);
        return "users/userform";

    }

    @RequestMapping(value = "/users/{id}/delete", method = RequestMethod.POST)
    public String deleteUser(@PathVariable("id") Long id,
                             final RedirectAttributes redirectAttributes) {
        User user = userService.findUserById(id);
        userService.deleteUser(user);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "User is deleted!");
        return "redirect:/users/listAll";

    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Long id, Model model) {
        User user = userService.findUserById(id);
        Logger.getLogger(UserController.class.getName()).log(Level.INFO, "Requested user is " + user);
        if (user == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        }
        model.addAttribute("user", user);
        return "users/show";

    }
}
