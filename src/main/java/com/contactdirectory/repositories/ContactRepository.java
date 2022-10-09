package com.contactdirectory.repositories;

import com.contactdirectory.beans.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

public interface ContactRepository extends MongoRepository<Person, String> {

    @Query("{email:?0}")
    Person getContactByEmail(String email);

    @Query("{_id:?0")
    @Update(pipeline="{{'$set':?0}}")
    void updateContactById(String id, Person person);

}
