package org.example.springmongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Blogs {
    @Id
    private String id;
    @Indexed(unique = true)
    private String title;
//    private List<String> comment;
    private List<String> tags;
    private String detail;
    private String writer;
    private LocalDateTime publishdate;

    public Blogs(String title,
//                 List<String> comment,
                 List<String> tags,
                 String detail,
                 String writer,
                 LocalDateTime publishdate) {
        this.title = title;
//        this.comment = comment;
        this.tags = tags;
        this.detail = detail;
        this.writer = writer;
        this.publishdate = publishdate;
    }
}
