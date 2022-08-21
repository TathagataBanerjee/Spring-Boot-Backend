package com.BloodDonationApp.bloodDonationApp.repository;

import com.BloodDonationApp.bloodDonationApp.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmailAddress(String newUserEmailAddress);
}
