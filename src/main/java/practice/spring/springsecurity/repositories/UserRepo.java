package practice.spring.springsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.spring.springsecurity.model.User;

@Repository
public interface UserRepo extends JpaRepository  <User, Long> {

    User findByEmail(String email);
}
