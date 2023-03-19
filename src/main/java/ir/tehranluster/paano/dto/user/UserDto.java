package ir.tehranluster.paano.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class UserDto {
    private Long id;
    private String mobile;
    private String password;
    private String confirmPassword;
    private Date createDate;
    private Date updateDate;
}
