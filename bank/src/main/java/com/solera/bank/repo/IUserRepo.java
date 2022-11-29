package com.solera.bank.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.solera.bank.models.User;

public interface IUserRepo extends MongoRepository<User, String> {

}
