package ru.homework.lesson20.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.homework.lesson20.boot.repository.interfaces.TicketRepository;
import ru.homework.lesson20.boot.service.interfaces.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED
    )
    @Override
    public void bayTicket(Long id){
        ticketRepository.bayOneTicket(id);
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED
    )
    @Override
    public void saleTicket(Long id) {
        ticketRepository.saleOneTicket(id);
    }
}
