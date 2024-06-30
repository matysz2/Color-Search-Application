package pl.example.colors.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.example.colors.model.ColorHistory;
import pl.example.colors.model.Customer;
import pl.example.colors.service.ColorHistoryRepository;

import javax.validation.Valid;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class SaveColorController {

    @Autowired
    private ColorHistoryRepository colorHistoryRepository;

    @PostMapping("/addColor")
    public ResponseEntity<String> addColor(@Valid  @RequestBody ColorHistory colorData, HttpSession session) {
        Customer loggedInUser = (Customer) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        }

        try {
            // Tworzenie obiektu ColorHistory i ustawianie jego pól
            ColorHistory colorHistory = new ColorHistory();
            colorHistory.setCustomer(loggedInUser);
            colorHistory.setColorName(colorData.getColorName());
            colorHistory.setPrice(colorData.getPrice());
            colorHistory.setQuantity(colorData.getQuantity());
            colorHistory.setSearchTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));            // Zapis do bazy danych
            colorHistoryRepository.save(colorHistory);

            return ResponseEntity.status(HttpStatus.OK).body("Color data saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving color data: " + e.getMessage());
        }
    }
}

