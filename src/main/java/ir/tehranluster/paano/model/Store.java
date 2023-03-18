package ir.tehranluster.paano.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Entity
@Table(name="store" , schema = "public")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Store {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name = "store_seq", sequenceName = "store_seq")
    @Column(name="ID")
    private long id;

    @Column(name = "name_per" , length = 100)
    private String namePer;

    @Column(name = "name_eng" , length = 100)
    private String nameEng;

    @Column(name = "about" , length = 5000)
    private String about;

    @ManyToOne(cascade= CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinTable(name = "store_slider" , joinColumns = {@JoinColumn(name = "store_id")},
            inverseJoinColumns = {@JoinColumn(name = "slider_id")})
    private Set<Slider> sliders = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passage_id")
    private Passage passage;
}
