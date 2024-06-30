package pl.example.colors.controller;

import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.example.colors.model.Customer;
import pl.example.colors.service.CustomerRepository;


import javax.validation.Valid;

@Getter
@Controller
public class LoginController {

    @Autowired
    private final CustomerRepository customerRepository;

    public LoginController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new Customer());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginForm") Customer loginForm,
                        BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        Customer customer = customerRepository.findByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());
        if (customer != null) {
            session.setAttribute("loggedInUser", customer);
            model.addAttribute("customer", customer);
            return "home";
        } else {
            model.addAttribute("error", "Niepoprawny email lub hasło");
            return "login";
        }
    }

    @GetMapping("/home")
    public ModelAndView home(HttpSession session) { // Metoda obsługująca wyświetlanie home
        ModelAndView modelAndView = new ModelAndView("home"); // Tworzenie obiektu ModelAndView z widokiem "home"
        Customer loggedInUser = (Customer) session.getAttribute("loggedInUser"); // Pobieranie użytkownika z sesji
        if (loggedInUser == null) { // Sprawdzenie, czy użytkownik jest zalogowany
            modelAndView.setViewName("redirect:/login"); // Przekierowanie na stronę logowania, jeśli nie jest zalogowany
            modelAndView.addObject("errorMessage", "Musisz się najpierw zalogować."); // Dodanie wiadomości o błędzie
        } else {
            modelAndView.addObject("loggedInUser", loggedInUser); // Dodanie zalogowanego użytkownika do modelu
        }
        return modelAndView; // Zwrócenie obiektu ModelAndView
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
