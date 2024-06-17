package pl.example.colors.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.example.colors.model.Color;
import pl.example.colors.service.ColorRepository;

@Getter
@RestController
public class ColorController {

    public ColorController(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    private final ColorRepository colorRepository;


    @GetMapping("/getColorName")
    public Color getColorName(@RequestParam String colorName) {
        return colorRepository.findByColorName(colorName);
    }

    @PostMapping("/submitColor")
    public String submitColor(@RequestParam String colorName) {

        return "Color submitted successfully";
    }
}