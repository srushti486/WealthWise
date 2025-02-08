package com.wealthfitness.model;

import java.time.OffsetDateTime;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "families")
@Data
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //for automatic generation
    @SuppressWarnings("unused")
    private Long familyId;


    @Column(unique = true,nullable = false)
    private String familyName;

    //one family has many user it connect with Foreign_key
    @OneToMany(mappedBy = "family", cascade = CascadeType.ALL)
    private List<User> members;

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}

