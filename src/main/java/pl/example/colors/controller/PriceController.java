package pl.example.colors.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.example.colors.model.Color;
import pl.example.colors.model.Customer;
import pl.example.colors.model.Price;
import pl.example.colors.service.PriceRepository;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class PriceController {

    @Autowired
    private PriceRepository priceRepository;


    @PostMapping("/searchColor")
    public String searchColor(@Valid  @RequestParam("colorName") String colorName, Model model, HttpSession session) {
            // Sprawdzenie logowania
            Customer loggedInUser = (Customer) session.getAttribute("loggedInUser");
            if (loggedInUser == null) {
                return "redirect:/login";
            }
        boolean colorExists = priceRepository.existsByColorName(colorName);

        if (!colorExists) {
            // Obsłuż sytuację gdy kolor nie istnieje, np. przekierowanie na inną stronę lub wyświetlenie komunikatu błędu
            model.addAttribute("error", "Kolor '" + colorName + "' nie istnieje.");
            return "home"; // Przykładowa nazwa widoku dla strony błędu
        }
            // Dodanie użytkownika do modelu
            model.addAttribute("customer", loggedInUser);

            List<Object[]> results = priceRepository.findComponentsAndQuantityAndPriceByColorName(colorName);
            List<Price> prices = new ArrayList<>();
            List<String> componentColors = new ArrayList<>();
            List<String> componentQuantities = new ArrayList<>();
            String name = colorName;
            for (Object[] result : results) {
                // Tworzenie obiektu Price na podstawie zwróconych danych
                String colorComponent = (String) result[0];
                String componentQuantity = (String) result[1];
                BigDecimal price = (BigDecimal) result[2];
                price = price.setScale(2, RoundingMode.HALF_UP);
                List<String> colorComponentsList = Arrays.asList(colorComponent.split(","));
                List<String> componentQuantitiesList = Arrays.asList(componentQuantity.split(","));

                componentColors.addAll(colorComponentsList);
                componentQuantities.addAll(componentQuantitiesList);

                Price priceObject = new Price(colorComponent, componentQuantity, price, name);
                prices.add(priceObject);
            }

            model.addAttribute("prices", prices);
            model.addAttribute("componentColors", componentColors);
            model.addAttribute("componentQuantities", componentQuantities);
            model.addAttribute("name", name);
            return "home";
        }
    }

