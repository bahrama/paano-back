package ir.tehranluster.paano.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Entity
@Table(name="user_detail" , schema = "public")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_detail_seq", sequenceName = "user_detail_seq")
    @Column(name="ID")
    private Long id;
    @Column(name = "name" , length = 100  , nullable = false)
    private String name;
    @Column(name = "ssn" , length = 10 , unique = true , nullable = false)
    private String ssn;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addres_id")
    private Addres addres;

}
