package web.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.swing.text.IconView;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Set;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Entity
@Table(name = "film",schema = "movie")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Short filmId;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    @Type(type = "text")
    private String description;

    @Column(name = "release_year", columnDefinition = "year")
    @Convert(converter = YearConverter.class)
    private Year releaseYear;

    @OneToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(name = "original_language_id")
    private Byte originalLanguageId;

    @Column(name = "rental_duration")
    private Byte rentalDuration;

    @Column(name = "rental_rate")
    private BigDecimal rentalRate;

    @Column
    private Short length;

    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;


    @Column(columnDefinition = "enum('G', 'PG', 'PG-13', 'R', 'NC-17')")
    @Convert(converter = RatingConverter.class)
    private Rating rating;


    @Column(name = "special_features", columnDefinition = "set('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
    private String specialFeatures;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "film_category",
    joinColumns = @JoinColumn(name = "film_id",referencedColumnName = "film_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id",referencedColumnName = "category_id"))
    private Set<Category> categories;


    }

