package com.contactdirectory.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "persons")
public class Person {

    @Id
    private String _id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String gender;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Name name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Location location;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Login login;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Dob dob;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Registered registered;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cell;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private SerialId serialId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Picture picture;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nat;


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Dob getDob() {
        return dob;
    }

    public void setDob(Dob dob) {
        this.dob = dob;
    }

    public Registered getRegistered() {
        return registered;
    }

    public void setRegistered(Registered registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public SerialId getSerialId() {
        return serialId;
    }

    public void setSerialId(SerialId serialId) {
        this.serialId = serialId;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }


}
