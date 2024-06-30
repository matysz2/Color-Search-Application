package pl.example.colors.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.example.colors.model.Comment;
import pl.example.colors.model.Customer;
import pl.example.colors.service.CommentRepository;

import java.util.List;

@Controller
public class CommentViewController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/comments")
    public String getAllComments(Model model, HttpSession session) {
        Customer loggedInUser = (Customer) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        List<Comment> comments = commentRepository.findAll();
        model.addAttribute("comments", comments);
        return "comments";
    }
}
