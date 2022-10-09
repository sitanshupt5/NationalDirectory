package com.contactdirectory.repositories.services;
import com.contactdirectory.beans.Person;
import com.contactdirectory.beans.Persons;
import com.contactdirectory.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServices {
    @Autowired
    ContactRepository rep;

    public Persons getContactByPage(int i){
        List<Person> people = rep.findAll();
        Persons persons = new Persons();
        if(!(people.size()==0||people.isEmpty()))
        {
            persons.setContact_list(people.subList(50*(i-1), (50*i)-1));
            if(people.size()>(50*i))
                persons.setMore_records_exist(true);
            else
                persons.setMore_records_exist(false);
            return persons;
        }
        else
        {
            return null;
        }
    }

    public Person getContactByEmail(String email){
        Person person = rep.getContactByEmail(email);
        return person;
    }
}
