package org.example.securtiy_role_and_jwt_1.services.user;



import org.example.securtiy_role_and_jwt_1.model.User;
import org.example.securtiy_role_and_jwt_1.model.UserDetails;
import org.example.securtiy_role_and_jwt_1.model.UserLogin;
import org.example.securtiy_role_and_jwt_1.myjpas.UserDetailJpa;
import org.example.securtiy_role_and_jwt_1.myjpas.UserLoginJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserLoginJpa loginJpa;
    @Autowired
    private UserDetailJpa detailJpa;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
    @Autowired
    private UserDetailJpa userDetailJpa;


// ------------------  Sign-up  --------------------------
    public UserLogin signUp(User user){

        UserDetails userDetails = new UserDetails();
        UserLogin userLogin = new UserLogin();

        {// user Detail saving
            userDetails.setFirstName(user.getFirstName());
            userDetails.setLastName(user.getLastName());
            userDetails.setEmail(user.getEmail());
            userDetails.setGender(user.getGender());
            userDetails.setPhoneNumber(user.getPhoneNumber());
            userDetails.setCountry(user.getCountry());
            userDetails.setCity(user.getCity());
            userDetails.setState(user.getState());
            userDetails.setZip(user.getZip());
            userDetails.setLocalAddress(user.getLocalAddress());
            detailJpa.save(userDetails);
        }
        {// user login data saving
            userLogin.setPassword(encoder.encode(user.getPassword()));
            userLogin.setUsername(user.getUsername());
            userLogin.setUserDetails(userDetails);
            loginJpa.save(userLogin);
        }
        return new UserLogin();
    }


// -----------------------------Show all ----------------------------------
    public List<UserDetails> showAllUsers(){
        return userDetailJpa.findAll();
    }
}
