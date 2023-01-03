package com.camel.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name= "Books")
@Table(name = "Books")
@NamedQuery(name = "findAll", query = "SELECT b FROM Books b")

public class Book {

	@JsonProperty
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@JsonProperty
    private String item;
	@JsonProperty
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

