package com.devmountain.noteApp.entities;

import com.devmountain.noteApp.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// Entities: An object that represents the thing you are trying to persist

// @Entity:this is annotation is what tells Spring that this class is being mapped to a data source

// @Table: This is where you can set what table you want these objects to be mapped to
@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //need to give class an Id
    @Id
    // define what kind of strategy we want to use to generate those id's
    //@GeneratedValue annotation with the strategy option defined as the
    // GenerationType.IDENTITY to a private member variable called “id” and is of type “Long”
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //Create a new private member variable called “username” of type “String”
    // and annotate it with the @Column annotation with the unique option set to “true”
    @Column(unique = true)
    private String username;

    // create a private member password of type string and annotate it with the @column
    @Column
    private String password;

    //generate getters and setters to be able to get these values or set these values.

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Note> noteSet = new HashSet<>();

    public User(UserDto userDto){
        if(userDto.getUsername()!=null){
            this.username=userDto.getUsername();
        }
        if(userDto.getPassword()!=null){
            this.password=userDto.getPassword();
        }
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public User(Long id) {
        this.id = id;
    }

    public User(String username) {
        this.username = username;
    }




}
