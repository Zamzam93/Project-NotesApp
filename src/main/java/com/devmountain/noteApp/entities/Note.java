package com.devmountain.noteApp.entities;

import com.devmountain.noteApp.dtos.NoteDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Notes")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String body;

    // @ManyToOne creates the association within Hibernate
    @ManyToOne
    // @JsonBackReference prevents infinite recursion when you deliver the resource up as JSON through the RESTful
    // API endpoint you will create
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "user" ,fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,
            CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Note> noteSet = new HashSet<>();
    //created successful schema for our data

    public Note(NoteDto noteDto){
        if(noteDto.getBody() !=null){
            this.body=noteDto.getBody();
        }
    }


}
