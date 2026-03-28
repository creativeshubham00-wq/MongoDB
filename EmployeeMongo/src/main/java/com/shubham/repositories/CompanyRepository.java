package com.shubham.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shubham.entities.Company;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String>{

}
