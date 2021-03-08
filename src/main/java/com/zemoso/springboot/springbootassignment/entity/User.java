package com.zemoso.springboot.springbootassignment.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="user_details")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotNull(message="is required")
    @NotEmpty(message = "is required")
    @Column(name="user_name")
    private String userName;

    @Column(name="email")
    @NotEmpty(message = "is required")
    @Email(message = "must be a valid email address")
    private String email;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name="created_at")
    private Date createdAt;


    public List<Claim> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }

    @OneToMany(mappedBy="userId",
            cascade= {CascadeType.ALL})
    private List<Claim> claims;

    public User(){

    }

    public User( String userName, String email) {

        this.userName = userName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
