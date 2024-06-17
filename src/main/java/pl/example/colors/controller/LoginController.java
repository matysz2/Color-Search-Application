package pl.example.colors.controller;


import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.example.colors.model.Customer;
import pl.example.colors.service.CustomerRepository;


@Getter
@Controller
public class LoginController {

    private final CustomerRepository customerRepository;

    public LoginController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Model model) {
        Customer customer=new Customer();
         customer = customerRepository.findByEmailAndPassword(email, password);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "home";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
}
