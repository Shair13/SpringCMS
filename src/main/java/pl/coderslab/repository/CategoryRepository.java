//package pl.coderslab.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import pl.coderslab.model.Category;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface CategoryRepository extends JpaRepository<Category, Long> {
//
//    @Override
//    <S extends Category> S save(S s);
//    @Override
//    void delete(Category category);
//    Optional<Category> findCategoryById(Long id);
//    List<Category> findAll();
//
//}
