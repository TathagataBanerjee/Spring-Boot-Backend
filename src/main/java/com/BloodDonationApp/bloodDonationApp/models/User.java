package com.BloodDonationApp.bloodDonationApp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String age;
    private String bloodGrp;
    private String contactNumber;
    private String address;
    private String landmark;
    private LocalDateTime createdDateTime;
    private byte[] imageData;

    // will be used when updating other details while posting a validateDonorStatus request
    public User(String firstName, String lastName, String emailAddress, String password, String age, String bloodGrp, String contactNumber, String address, String landmark, byte[] imageData) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.age = age;
        this.bloodGrp = bloodGrp;
        this.contactNumber = contactNumber;
        this.address = address;
        this.landmark = landmark;
        this.imageData = imageData;
    }

    /// used for user registration
    public User(String firstName, String lastName, String emailAddress, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    // used for user login
    public User(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }
}
