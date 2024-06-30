package pl.example.colors.service;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.example.colors.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
