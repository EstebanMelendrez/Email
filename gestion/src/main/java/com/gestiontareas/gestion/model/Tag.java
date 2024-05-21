package com.gestiontareas.gestion.model;





import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

/*Se crea la entidad Tag que contiene los datos de la tabla de base de datos con el mismo nombre */
@Entity
public class Tag 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "Name", length = 20)
    private String name;
    
    @ManyToMany(mappedBy = "tags")
    private Set<Task> tasks;

    public int getId()
    {
        return Id;
    }

    public void setId(int Id)
    {
        this.Id=Id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name=name;
    }

}
