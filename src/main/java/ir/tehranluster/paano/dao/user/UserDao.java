package ir.tehranluster.paano.dao.user;

import ir.tehranluster.paano.dto.user.UserDto;
import ir.tehranluster.paano.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User,Long> ,CustomUserDao{

    Optional<User> findUserByMobile(String mobile);
}
