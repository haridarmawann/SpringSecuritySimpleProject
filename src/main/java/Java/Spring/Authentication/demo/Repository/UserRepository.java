package Java.Spring.Authentication.demo.Repository;

import Java.Spring.Authentication.demo.Model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel,String> {

    UserModel findByUsername(String username);
}
