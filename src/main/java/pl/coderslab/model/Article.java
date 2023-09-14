package pl.coderslab.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    @Size(max = 200, message = "Długość tytułu nie może być większa niż 200 znaków")
    @NotBlank(message = "Pole nie może być puste")
    private String title; // (max. 200 znaków)
    @ManyToOne(fetch = FetchType.EAGER)
    private Author author; // (powiązanie relacją do klasy Author) - artykuł może mieć tylko jednego autora
    @ManyToMany(fetch = FetchType.EAGER)
    @Size(min = 1, message = "Musi zawierac przynajmniej jedną kategorię")
    private List<Category> categories; // (powiązanie relacją do klasy Category) - artykuł może należeć do wielu kategorii
    @Size(min = 500, max = 5000, message = "Zawartość artykułu nie może być krótsza niż 500 i dłuższa niż 5000 znaków")
    @Column(length = 5000)
    @NotBlank(message = "Pole nie może być puste")
    private String content;
    private String created; // (wartość ma być automatycznie dodawana podczas zapisu)
    private String updated = "none"; // (wartość ma być automatycznie zmieniana podczas edycji).

    public Article() {

    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return updated;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
//                ", categories=" + categories +
                ", content='" + content + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                '}';
    }
}
