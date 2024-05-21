package com.gestiontareas.gestion.Requests;

/*Clase que contiene los campos que se pueden actualizar en una tarea por medio de un servicio y controlador POST*/

import java.sql.Timestamp;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TaskUpdateRequest 
{
    private String title;
    private String state;
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Timestamp creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Timestamp limitDate;

    private Set<Integer> tagIds;


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

    public Set<Integer> getTagIds()
    {
        return tagIds;
    }

    public void setTagIds(Set<Integer> tagIds)
    {
        this.tagIds=tagIds;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state=state;
    }
}
