package com.gestiontareas.gestion.Rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestiontareas.gestion.Services.EmailService;
import com.gestiontareas.gestion.Services.UserService;
import com.gestiontareas.gestion.model.User;


/*controlador de servicios REST para la obtención, creación y eliminación de datos de la tabla de datos User */

@RestController
@RequestMapping("/users")
public class RestUserController 
{
    @Autowired
    private UserService userservice;

    @Autowired
    private EmailService emailservice;

    @GetMapping
    public List<User> getAllUsers()
    {
        return userservice.getAllUsers();
    }

    @GetMapping("/{idUser}")
    public Optional<User> getUserById(@PathVariable int idUser)
    {
        return userservice.getUserById(idUser);
    }

    @PostMapping
    public User createUser(@RequestBody User user)
    {
        emailservice.sendSimpleEmail(user.getEmail(), "Registro exitoso", "Bienvenido a nuestra aplicación!");
        return userservice.createUser(user);

    }

    @DeleteMapping("/{idUser}")
    public void deleteUser(@PathVariable int idUser)
    {
        userservice.deleteUser(idUser);
    }
}
