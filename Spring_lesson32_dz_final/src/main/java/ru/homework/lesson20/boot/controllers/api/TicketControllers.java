package ru.homework.lesson20.boot.controllers.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.homework.lesson20.boot.service.interfaces.TicketService;

@RequestMapping("/api/v1/avia")
@RestController
public class TicketControllers {
    private TicketService ticketService;

    public TicketControllers(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/sale/{id}")
    public void saleTicket(@PathVariable("id") Long id) {
        ticketService.saleTicket(id);
    }
    @PostMapping("/bay/{id}")
    public void bayTicket(@PathVariable("id") Long id) {
        ticketService.bayTicket(id);
    }
}
