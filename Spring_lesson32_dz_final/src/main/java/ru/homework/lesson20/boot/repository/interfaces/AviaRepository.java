package ru.homework.lesson20.boot.repository.interfaces;

import org.springframework.data.jpa.repository.*;
import ru.homework.lesson20.boot.entities.AviaEntities;




public interface AviaRepository extends JpaRepository<AviaEntities, Long> {

     @Modifying
     @Query("UPDATE AviaEntities avia SET avia.title = :pattern where avia.id = :patternId")
     Integer changeTitleName(String pattern, long patternId);
}