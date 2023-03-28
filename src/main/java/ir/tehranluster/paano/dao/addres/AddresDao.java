package ir.tehranluster.paano.dao.addres;

import ir.tehranluster.paano.model.Addres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddresDao extends JpaRepository<Addres , Long> {

}
