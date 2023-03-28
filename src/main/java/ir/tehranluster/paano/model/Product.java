package ir.tehranluster.paano.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Entity
@Table(name="product" , schema = "public")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE , generator = "product_seq")
    @SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
    @Column(name="ID")
    private Long id;

    @Column(name = "brand" , length = 100)
    private String brand;

    @Column(name = "name" , length = 200)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updateDate;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="product",
            cascade= CascadeType.ALL)
    private Set<Order> orders = new HashSet<>();




}
