package web.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private Long filmId;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @OneToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(name = "original_language_id")
    private Long originalLanguageId;

    @Column(name = "rental_duration")
    private Integer rentalDuration;

    @Column(name = "rental_rate")
    private Double rentalRate;

    @Column
    private Long length;

    @Column(name = "replacement_cost")
    private Double replacementCost;

    @Column
    @Convert(converter = RatingConverter.class)
    private Rating rating;

    @Column(name = "special_features")
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

