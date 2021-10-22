package com.yoho.gimnasios.repositories;

import com.yoho.gimnasios.models.Assist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssistRepository extends JpaRepository<Assist, Long> {
    @Query("SELECT a FROM asistencias a WHERE DAY(a.assist_date) = ?1")
    List<Assist> getAssistsByDay(int day);

    @Query("SELECT a FROM asistencias a WHERE DATE(a.assist_date) = DATE(NOW())")
    List<Assist> getCurrentDayAssists();
}
