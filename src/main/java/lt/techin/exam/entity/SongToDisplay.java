package lt.techin.exam.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SongToDisplay {
    private String title;
    private String author;
}
