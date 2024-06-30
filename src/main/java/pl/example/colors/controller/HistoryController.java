package pl.example.colors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pl.example.colors.model.ColorHistory;
import pl.example.colors.model.Customer;
import pl.example.colors.model.Price;
import pl.example.colors.service.ColorHistoryRepository;
import pl.example.colors.service.PriceRepository;


import java.time.Instant;
import java.util.List;

@Controller
public class HistoryController {

    @Autowired
    private final ColorHistoryRepository colorHistoryRepository;



    public HistoryController(ColorHistoryRepository colorHistoryRepository) {
        this.colorHistoryRepository = colorHistoryRepository;
       ;
    }

    @GetMapping("/history")
    public String getColorHistoryByCustomerId(Model model, HttpSession session) {
        Customer loggedInUser = (Customer) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }

        List<ColorHistory> colorHistoryList = colorHistoryRepository.findColorHistoriesByCustomer(loggedInUser);
        model.addAttribute("colorHistoryList", colorHistoryList);
        return "history";
    }

}
