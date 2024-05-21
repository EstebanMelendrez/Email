package com.gestiontareas.gestion.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestiontareas.gestion.Repository.ITaskRepository;


/*Servicio que elimina el registro de una tarea ya existente */
@Service
public class TaskDeleteService 
{
    @Autowired
    private ITaskRepository taskrepository;


     /*Método que busca una tarea por su Id para realizar una eliminación de registro a traves del objeto taskDetails de tipo Task que contiene los nuevos datos */

    public void deleteTask(int Id)
    {
        taskrepository.deleteById(Id);
    }
}
