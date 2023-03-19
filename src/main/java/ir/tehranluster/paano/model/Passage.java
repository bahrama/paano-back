package ir.tehranluster.paano.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Entity
@Table(name="passage" , schema = "public")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Passage {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name = "passage_seq", sequenceName = "passage_seq")
    @Column(name="ID")
    private Long id;

    @Column(name = "name" , length = 100  , nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addres_id")
    private Addres addres;

    @OneToOne(cascade = CascadeType.ALL , mappedBy = "passage" , fetch = FetchType.LAZY)
    private Store store;
}
