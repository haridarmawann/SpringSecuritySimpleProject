package Java.Spring.Authentication.demo.Service;

import Java.Spring.Authentication.demo.Model.UserModel;
import Java.Spring.Authentication.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel existUser = userRepository.findByUsername(username);

        if (existUser == null) return null ;
        String name = existUser.getUsername();
        String pwd = existUser.getPassword();

        return new User(name,pwd,new ArrayList<>());
    }
}
