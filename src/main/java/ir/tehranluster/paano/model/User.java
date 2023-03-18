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
@Table(name="user" , schema = "public")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq")
    @Column(name="ID")
    private long id;
    @Column(name = "mobile" , length = 11 , unique = true , nullable = false)
    private String mobile;
    @Column(name = "PASSWORD" , length = 200 , nullable = false)
    private String password;
    @Transient
    private String confirmPassword;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updateDate;

    @OneToOne(cascade = CascadeType.ALL , mappedBy = "user" , fetch = FetchType.LAZY)
    private UserDetail userDetail;

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="user",
            cascade= CascadeType.ALL)
    private Set<Store> courses = new HashSet<>();

    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="user",
            cascade= CascadeType.ALL)
    private Set<Order> orders = new HashSet<>();

    @PrePersist
    protected void onCreateDate(){
        this.createDate = new Date();
        log.info( "created :" + this.toString());
    }
    @PreUpdate
    protected void onUpdateDate(){
        this.createDate = new Date();
        log.info( "updated :" + this.toString());
    }
    @PreRemove
    protected void onRemove(){
        log.info("removed :" + this.toString());
    }
}
