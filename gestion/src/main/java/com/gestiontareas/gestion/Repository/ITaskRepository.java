package com.gestiontareas.gestion.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestiontareas.gestion.model.Task;

@Repository
public interface ITaskRepository extends JpaRepository <Task,Integer>
{
    @Query("SELECT t FROM Task t LEFT JOIN t.tags tag " +
            "WHERE (:title IS NULL OR t.title LIKE %:title%) " +
            "AND (:description IS NULL OR t.description LIKE %:description%) " +
            "AND (:state IS NULL OR t.state LIKE %:state%) " +
            "AND (:creationDateFrom IS NULL OR t.creationDate >= :creationDateFrom) " +
            "AND (:creationDateUntil IS NULL OR t.creationDate <= :creationDateUntil) " +
            "AND (:limitDateFrom IS NULL OR t.limitDate >= :limitDateFrom) " +
            "AND (:limitDateUntil IS NULL OR t.limitDate <= :limitDateUntil) " +
            "AND (COALESCE(:tagIds, NULL) IS NULL OR tag.id IN :tagIds)")
    
    List<Task> findTasksByCriteria(
        @Param("title") String title,
        @Param("description") String description,
        @Param("state") String state,
        @Param("creationDateFrom") Timestamp creationDateFrom,
        @Param("creationDateUntil") Timestamp creationDateUntil,
        @Param("limitDateFrom") Timestamp limitDateFrom,
        @Param("limitDateUntil") Timestamp limitDateUntil,
        @Param("tagIds") Set<Integer> tagIds
    );
}
