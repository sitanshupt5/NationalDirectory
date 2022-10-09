package com.contactdirectory.controllers;

import com.contactdirectory.beans.Person;
import com.contactdirectory.beans.Persons;
import com.contactdirectory.beans.response.PostResponse;
import com.contactdirectory.beans.response.PutErrorResponse;
import com.contactdirectory.repositories.ContactRepository;
import com.contactdirectory.repositories.services.ContactServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DirectoryController {
    @Autowired
    ContactRepository repository;

    @Autowired
    ContactServices service;

    @GetMapping("/directory/getContacts")
    public ResponseEntity<?> getAllContacts(@RequestParam(name = "page")int page)
    {
        if(!(service.getContactByPage(page)==null))
        return new ResponseEntity<Persons>(service.getContactByPage(page), HttpStatus.OK);
        else
            return new ResponseEntity<>("No Contacts Available", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/directory/getContact")
    public ResponseEntity<?> getContactByEmail(@RequestParam(name="email")String email)
    {
        if(service.getContactByEmail(email)==null)
        {
            return new ResponseEntity<String>("Error!! Contact Not Found", HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<Person>(service.getContactByEmail(email), HttpStatus.OK);
        }
    }

    @PostMapping("/directory/addContact")
    public ResponseEntity<?> addContact(@RequestBody Person person)
    {
        PostResponse response = new PostResponse();
        if(service.getContactByEmail(person.getEmail())==null)
        {
            repository.save(person);
            response.setMessage("Contact added successfully");
            response.setId(person.get_id());
            return new ResponseEntity<PostResponse>(response, HttpStatus.CREATED);
        }
        else
        {
            response.setMessage("Contact already exists");
            response.setId(service.getContactByEmail(person.getEmail()).get_id());
            return new ResponseEntity<PostResponse>(response, HttpStatus.ACCEPTED);
        }

    }

    @DeleteMapping("/directory/removeContact/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable(value = "id")String id)
    {
        if(repository.existsById(id))
        {
            repository.deleteById(id);
            return new ResponseEntity<String>("Contact has been deleted.", HttpStatus.OK);
        }
        else
            return new ResponseEntity<String>("Contact does not exist in the records.", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/directory/updateContact")
    public ResponseEntity<?> updateContact(@RequestBody Person person)
    {
        if(person.get_id().isEmpty())
        {
            PutErrorResponse response =new PutErrorResponse();
            response.setError_code("IDENTIFIER_MISSING");
            response.setError_message("Id missing in input.");
            return new ResponseEntity<PutErrorResponse>(response,HttpStatus.BAD_REQUEST);
        }
        else if(repository.existsById(person.get_id()))
        {
            PostResponse response = new PostResponse();
            repository.save(person);
            response.setId(person.get_id());
            response.setMessage("Contact has been updated");
            return new ResponseEntity<PostResponse>(response,HttpStatus.OK);
        }
        else
        {
            PutErrorResponse response =new PutErrorResponse();
            response.setError_code("INCORRECT_ID");
            response.setError_message("Contact not Found");
            return new ResponseEntity<PutErrorResponse>(response, HttpStatus.NOT_FOUND);
        }
    }
}
