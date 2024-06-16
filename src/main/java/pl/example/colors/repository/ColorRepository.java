package pl.example.colors.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.example.colors.model.Color;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ColorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveColor(String color) {
        entityManager.persist(color);
    }

    public Color findById(int id) {
        return entityManager.find(Color.class, id);
    }

    public Color findByColorName(String colorName) {
        Query query = entityManager.createQuery("SELECT c FROM Color c WHERE c.colorName = :colorName", Color.class);
        query.setParameter("colorName", colorName);
        return (Color) query.getSingleResult();
    }

    public void update(Color color) {
        entityManager.merge(color);
    }

    public void delete(Color color) {
        entityManager.remove(entityManager.contains(color) ? color : entityManager.merge(color));
    }

    public List<Color> findAll() {
        return entityManager.createQuery("SELECT c FROM Color c", Color.class)
                .getResultList();
    }



}
