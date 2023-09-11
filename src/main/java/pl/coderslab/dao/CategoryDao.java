package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveCategory(Category category){
        entityManager.persist(category);
    }

    public void deleteCategory(Category category){
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }

    public void updateCategory(Category category){
        entityManager.merge(category);
    }
}
