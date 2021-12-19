package SartenMango_4.interfaces;

import SartenMango_4.modelo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface InterfaceUser extends MongoRepository <User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    Optional<User> findTopByOrderByIdDesc();

}
