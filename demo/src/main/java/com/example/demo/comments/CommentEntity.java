package com.example.demo.comments;
import com.example.demo.user.Users;
import com.example.demo.books.BooksEntity;
import jakarta.persistence.*;
import lombok.*;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "commententity")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "comment")
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "books_comments")
    private BooksEntity booksEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "comment_person")
    private Users users;


}
