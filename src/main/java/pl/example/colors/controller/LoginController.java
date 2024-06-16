package pl.example.colors.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.example.colors.dao.CustomerDao;
import pl.example.colors.model.Customer;


@Controller
public class LoginController {

    @Autowired
    private CustomerDao customerService;

    @GetMapping("/")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Model model) {
        Customer customer = customerService.findByEmailAndPassword(email, password);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "index";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
}
