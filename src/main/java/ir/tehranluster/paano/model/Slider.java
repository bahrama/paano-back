package ir.tehranluster.paano.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Entity
@Table(name="slider" , schema = "public")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Slider {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name = "slider_seq", sequenceName = "slider_seq")
    @Column(name="ID")
    private long id;

    @Column(name = "name" , length = 100)
    private String name;

    @Column(name = "title" , length = 200)
    private String title;

    @Column(name = "img" , length = 200)
    private String img;

    @ManyToMany(fetch = FetchType.LAZY , mappedBy = "sliders")
    private Set<Store> stores = new HashSet<>();
}
