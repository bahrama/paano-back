package ir.tehranluster.paano.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserJoinDetailAddresDto {
    private long id;
    private String mobile;
    private String password;
    private Date createDate;
    private Date updateDate;
    private String name;
    private String ssn;
    private String phone;
    private String addr;
    private double lat;
    private double lng;
}
