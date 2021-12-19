package SartenMango_4.interfaces;

import SartenMango_4.modelo.Cookware;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterfaceCookware extends MongoRepository <Cookware, String>{
}
