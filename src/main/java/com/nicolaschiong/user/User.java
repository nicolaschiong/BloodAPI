package com.nicolaschiong.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nicolaschiong.core.BaseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;

/**
 * Created by Nick on 3/20/2017.
 */
@Entity
public class User extends BaseEntity {

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    private String firstName;
    private String lastName;
    private String username;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String[] roles;

    private String emailAddress;
    private String address;
    private String gender;
    private String birthDate;
    private String profilePicture;

    private String bloodType;


    protected User(){
        super();
    }

    public User(String username, String firstName, String lastName, String password, String[] roles, String emailAddress, String address, String gender, String birthDate, String profilePicture, String bloodType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        setPassword(password);
        this.roles = roles;
        this.emailAddress = emailAddress;
        this.address = address;
        this.gender = gender;
        this.birthDate = birthDate;
        this.profilePicture = profilePicture;
        this.bloodType = bloodType;
    }

    public void setPassword(String password){
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
