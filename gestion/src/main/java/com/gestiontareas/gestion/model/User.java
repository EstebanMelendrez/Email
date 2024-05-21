package com.gestiontareas.gestion.model;





import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//Se crea la entidad que contiene los datos de la tabla 'User' en la base de datos.

@Entity
public class User 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*Genera el id mediante la propia base de datos utilizando la opción de incremento automático*/
    @Column(name="IdUser", length = 10)
    private int idUser;

    @Column(name="Name", length = 50)
    private String name;

    @Column(name="Email", length = 255)
    private String email;

    @Column(name="Password", length = 15)
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Task> tasks;

    public int getIdUser()
    {
        return idUser;
    }

    public void setIdUser(int idUser)
    {
        this.idUser=idUser;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email=email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password=password;
    }


}
