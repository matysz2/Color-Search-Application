package pl.example.colors.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.example.colors.model.Color;
import pl.example.colors.service.ColorRepository;

import java.util.List;

@Getter
@Controller
public class ColorController {

    @Autowired
    private ColorRepository colorRepository;

    @GetMapping("/getColorName")
    public ResponseEntity<Color> getColorName(@RequestParam String colorName) {
        Color color = colorRepository.findByColorName(colorName);
        if (color != null) {
            return ResponseEntity.ok(color);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/submitColor")
    @ResponseBody
    public String submitColor(@RequestParam String colorName) {
        return "Color submitted successfully";
    }

}