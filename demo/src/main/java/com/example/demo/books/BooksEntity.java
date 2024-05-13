package com.example.demo.books;
import com.example.demo.comments.CommentEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Entity
@Table(name = "bookentity")
@AllArgsConstructor
@NoArgsConstructor
public class BooksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",updatable = false,nullable = false)
    private Long id;
    @Column(name = "title",length = 10,nullable = false)
    private String title;
    @Column(name = "writer",length = 20,nullable = false)
    private String writer;
    @Column(name = "price",columnDefinition = "Free")
    private String price;
    @OneToMany(mappedBy = "booksEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CommentEntity> commentEntities;
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
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public List<CommentEntity> getCommentEntities() {
        return commentEntities;
    }
    public void setCommentEntities(List<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }
}
