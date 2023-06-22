package Java.Spring.Authentication.demo.Controller;

import Java.Spring.Authentication.demo.AuthenticationReponse;
import Java.Spring.Authentication.demo.AuthenticationRequest;
import Java.Spring.Authentication.demo.Model.UserModel;
import Java.Spring.Authentication.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/subs")
    private ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest) {

        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        UserModel user = new UserModel();
        user.setUsername(username);
        user.setPassword(password);
        try{
            userRepository.save(user);
        }catch (Exception e){
            return ResponseEntity.ok(new AuthenticationReponse("error saat melakukan subcription" + username));
        }

        return ResponseEntity.ok(new AuthenticationReponse("sudah subscribe yaa!!" + username));
    }

    @PostMapping("/auth")
    private ResponseEntity<?> Client(@RequestBody AuthenticationRequest authenticationRequest){

        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (Exception e){
            return ResponseEntity.ok(new AuthenticationReponse("error Auth " + username));
        }
        return ResponseEntity.ok(new AuthenticationReponse("Successful Authentication for " + username));
    }

}
