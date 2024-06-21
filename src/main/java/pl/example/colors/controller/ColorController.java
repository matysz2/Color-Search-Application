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
@RestController
public class ColorController {

    @Autowired
    private ColorRepository colorRepository;

    @GetMapping("/getColorName")
    public List<Color> searchColorsByFragment(@RequestParam String fragment) {
        return colorRepository.findColorsByColorNameContains(fragment);
    }


}