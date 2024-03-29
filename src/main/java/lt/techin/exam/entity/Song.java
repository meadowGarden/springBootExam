package lt.techin.exam.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Song {
    private String id;
    private String title;
    private String author;
}
