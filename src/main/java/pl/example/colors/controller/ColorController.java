package pl.example.colors.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.example.colors.model.Color;
import pl.example.colors.repository.ColorRepository;

@RestController
public class ColorController {

    private final ColorRepository colorRepository;

    public ColorController(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }


    @GetMapping("/getColorName")
    public Color getColorName(@RequestParam String colorName) {
        return colorRepository.findByColorName(colorName);
    }

    @PostMapping("/submitColor")
    public String submitColor(@RequestParam String colorName) {
        colorRepository.saveColor(colorName);
        return "Color submitted successfully";
    }
}