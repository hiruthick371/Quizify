package com.example.loginform.Entity;// User.java
import jakarta.persistence.*;


@Entity
@Table(name = "storenames2")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  //  @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
