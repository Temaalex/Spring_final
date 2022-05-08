package ru.homework.lesson20.boot.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.homework.lesson20.boot.entities.AviaEntities;

public interface TicketRepository extends JpaRepository<AviaEntities, Long> {

    @Modifying
    @Query("UPDATE AviaEntities avia SET avia.place = (avia.place-1) where avia.id = :id")
    Integer bayOneTicket(Long id);

    @Modifying
    @Query("UPDATE AviaEntities avia SET avia.place = (avia.place+1) where avia.id = :id")
    Integer saleOneTicket(Long id);
}
