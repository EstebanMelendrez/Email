package com.gestiontareas.gestion.model;

import java.sql.Timestamp;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

//Se crea la entidad que contiene los datos de la tabla 'Task' en la base de datos.

@Entity
public class Task 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*Genera el id mediante la propia base de datos utilizando la opción de incremento automático*/
    private int Id;

    @Column(name = "Title", length = 50)
    private String title; 

    @Column(name = "Description", length = 100)
    private String description;

    @Column(name = "State", length = 20)
    private String state;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @Column(name = "Creation_Date")
    private Timestamp creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @Column(name = "Limit_Date")
    private Timestamp limitDate;

    @ManyToOne
    @JoinColumn(name = "User_Id")
    private User user;
    
    @ManyToMany
    @JoinTable(
        name = "Task_tag",
       joinColumns = @JoinColumn(name = "Id_Task"),
       inverseJoinColumns = @JoinColumn(name = "Id_Tag")
    )
    private Set<Tag> tags;

    public Set<Tag> getTags() 
    {
        return tags;
    }

    public void setTags(Set<Tag> tags) 
    {
        this.tags = tags;
    }
    
    public int getId()
    {
        return Id;
    }

    public void setId(int Id)
    {
        this.Id=Id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title=title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description=description;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state=state;
    }

    public Timestamp getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate)
    {
        this.creationDate=creationDate;
    }

    public Timestamp getLimitDate()
    {
        return limitDate;
    }

    public void setLimitDate(Timestamp limitDate)
    {
        this.limitDate=limitDate;
    }
    

}
