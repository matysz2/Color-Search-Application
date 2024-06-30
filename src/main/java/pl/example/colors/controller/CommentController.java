package pl.example.colors.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.example.colors.model.Comment;
import pl.example.colors.model.Customer;
import pl.example.colors.service.CommentRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class CommentController {


    @Autowired
    private CommentRepository commentRepository;

    @PostMapping("/comment")
    public ResponseEntity<?> addComment(@RequestBody Comment comment, HttpSession session) {
        Customer loggedInUser = (Customer) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        }
        comment.setCommentText(comment.getCommentText());
        comment.setColorName(comment.getColorName());
        comment.setCustomer(loggedInUser);
        comment.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));            // Zapis do bazy danych
        commentRepository.save(comment);
        return ResponseEntity.ok("Komentarz poprawnie dodany");
    }

}

