package ir.tehranluster.paano.dto.user;

import ir.tehranluster.paano.model.Addres;
import ir.tehranluster.paano.model.User;
import ir.tehranluster.paano.model.UserDetail;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring"
)
public interface UserDtoManager {

    UserDtoManager Instance = Mappers.getMapper(UserDtoManager.class);
    @Mapping(source = "name" , target = "name")
    UserDetailDto transferUserDetailToDto(UserDetail userDetail);

    @InheritInverseConfiguration
    UserDetail transferUserDetailDtoToEntity(UserDetailDto userDetailDto);

    UserDto transferUserToDto(User user);

    @InheritInverseConfiguration
    User transferUserDtoToEntity(UserDto userDto);

    AddresDto transferAddresToDto(Addres addres);
    @InheritInverseConfiguration
    Addres transferAddresDtoToEntity(AddresDto addresDto);

}
