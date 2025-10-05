
package com.turkcell.libraryapp.infrastructure.persistence.jpa;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class StudentEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    public StudentEntity(){}
    public StudentEntity(String name){ this.name = name; }
    public Long getId(){ return id; }
    public String getName(){ return name; }
    public void setName(String n){ this.name = n; }
}
