package pl.example.colors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.example.colors.model.Price;
import pl.example.colors.service.PriceRepository;

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
    public String searchColor(@RequestParam("colorName") String colorName, Model model) {
        List<Object[]> results = priceRepository.findComponentsAndQuantityAndPriceByColorName(colorName);
        List<Price> prices = new ArrayList<>();
        List<String> componentColors = new ArrayList<>();
        List<String> componentQuantities = new ArrayList<>();
        String name= colorName;
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
