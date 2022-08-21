package com.BloodDonationApp.bloodDonationApp.services;

import com.BloodDonationApp.bloodDonationApp.models.User;
import com.BloodDonationApp.bloodDonationApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserId(){
       long count = userRepository.count();
       return String.valueOf(count + 1);
    }

    public User registerNewUser(User user){
        //TODO : save the password in a hashed format, while checking for login hash it back to original format. Need
        // to think about this implementation
        String newUserEmailAddress = user.getEmailAddress();
        Boolean isUserWithEmailAddressExists = userRepository.findByEmailAddress(newUserEmailAddress).isEmpty();
        if(isUserWithEmailAddressExists){
            LocalDateTime createdDateTime = LocalDateTime.now();
            user.setId(getUserId());
            user.setCreatedDateTime(createdDateTime);
            return userRepository.save(user);
        }else{
            return null;
        }
    }
}
