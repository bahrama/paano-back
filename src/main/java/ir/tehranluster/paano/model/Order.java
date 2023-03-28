package ir.tehranluster.paano.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Entity
@Table(name="order" , schema = "public")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE , generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1)
    @Column(name="ID")
    private Long id;

    @Column(name="product_number")
    private int productNumber;

    @ManyToOne(cascade= CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(cascade= CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;
}
