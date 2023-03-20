package team99.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team99.user.domain.User;
@Repository
public interface UserServiceRepository extends JpaRepository<User, Integer>  {


}
