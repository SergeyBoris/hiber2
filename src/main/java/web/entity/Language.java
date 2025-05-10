package web.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
@Entity
@Table(name = "language",schema = "movie")
public class Language {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Long id;
    @Column(unique = true)
    private String name;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
