package com.contactdirectory.beans;

import java.util.List;

public class Persons {

    List<Person> contact_list;
    Boolean more_records_exist;

    public List<Person> getContact_list() {
        return contact_list;
    }

    public void setContact_list(List<Person> contact_list) {
        this.contact_list = contact_list;
    }

    public Boolean getMore_records_exist() {
        return more_records_exist;
    }

    public void setMore_records_exist(Boolean more_records_exist) {
        this.more_records_exist = more_records_exist;
    }
}
