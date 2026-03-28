package com.shubham.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shubham.entities.Project;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String>{

}
