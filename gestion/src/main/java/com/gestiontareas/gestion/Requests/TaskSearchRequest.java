package com.gestiontareas.gestion.Requests;

import java.sql.Timestamp;
import java.util.Set;

/*Clase que contiene los campos a partir de los que se puede realizar una busqueda (por fecha) y sus datos en una tarea por medio de un servicio y controlador POST*/

import com.fasterxml.jackson.annotation.JsonFormat;



public class TaskSearchRequest 
{
    private String title;
    private String description;
    private String state;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Timestamp creationDateFrom;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Timestamp creationDateUntil;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") 
    private Timestamp limitDateFrom;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")    
    private Timestamp limitDateUntil;

 
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

    public Timestamp getCreationDateFrom()
    {
        return creationDateFrom;
    }

    public void setCreationDateFrom(Timestamp creationDateFrom)
    {
        this.creationDateFrom=creationDateFrom;
    }

    public Timestamp getCreationDateUntil()
    {
        return creationDateUntil;
    }

    public void setCreationDateUntil(Timestamp creationDateUntil)
    {
        this.creationDateUntil=creationDateUntil;
    }

    public Timestamp getLimitDateFrom()
    {
        return limitDateFrom;
    }

    public void setLimitDateFrom(Timestamp limitDateFrom)
    {
        this.limitDateFrom=limitDateFrom;
    }

    public Timestamp getLimitDateUntil()
    {
        return limitDateUntil;
    }

    public void setLimitDateUntil(Timestamp limitDateUntil)
    {
        this.limitDateUntil=limitDateUntil;
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
