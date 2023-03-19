package ir.tehranluster.paano.dto.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
public class AddresDto {

    private Long id;
    private String phone;
    private String addr;
    private double lat;
    private double lng;
}
