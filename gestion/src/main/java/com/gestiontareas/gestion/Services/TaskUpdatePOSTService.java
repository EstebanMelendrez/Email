package com.gestiontareas.gestion.Services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestiontareas.gestion.Repository.ITagRepository;
import com.gestiontareas.gestion.Repository.ITaskRepository;
import com.gestiontareas.gestion.Requests.TaskUpdateRequest;
import com.gestiontareas.gestion.model.Tag;
import com.gestiontareas.gestion.model.Task;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskUpdatePOSTService 
{
    @Autowired
    private ITaskRepository taskrepository;

    @Autowired
    private ITagRepository tagrepository;


    public Task updateTask(int taskId, TaskUpdateRequest updaterequest)
    {
        Task existingtask = taskrepository.findById(taskId).orElseThrow(() -> new EntityNotFoundException("No se encontró la tarea con el Id  " + taskId));

        existingtask.setTitle(updaterequest.getTitle());
        existingtask.setState(updaterequest.getState());
        existingtask.setDescription(updaterequest.getDescription());
        existingtask.setCreationDate(updaterequest.getCreationDate());
        existingtask.setLimitDate(updaterequest.getLimitDate());

        Set<Tag> tags = new HashSet<>();

        if(updaterequest.getTagIds() != null)
        {
            for(int tagId : updaterequest.getTagIds())
            {
                Tag tag = tagrepository.findById(tagId).orElseThrow(() -> new EntityNotFoundException("No se encontró la etiqueta con el Id: " + tagId));
                tags.add(tag);
            }
        }

        existingtask.setTags(tags);

        return taskrepository.save(existingtask);
    }

    
}
