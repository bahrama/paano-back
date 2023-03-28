package ir.tehranluster.paano.dao.user;

import javax.persistence.Tuple;

public interface CustomUserDao {
    Object[] findUserDtoById(Long id);

}
