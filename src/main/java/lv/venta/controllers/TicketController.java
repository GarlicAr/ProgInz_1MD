package lv.venta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lv.venta.models.Ticket;
import lv.venta.services.impl.TicketCRUDservice;


@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	private TicketCRUDservice ticketService;
	
	
	@GetMapping("/showAll/onlyChild")
    public List<Ticket> showAllChildTickets() {
        return ticketService.selectAllChildTickets();
    }
	
	@GetMapping("/showAll/less/{price}")
    public List<Ticket> showAllTicketsWherePriceIsLow(@PathVariable float price) {
        return ticketService.selectAllTicketsWherePriceIsLow(price);
    }
	
	@GetMapping("/showAll/trip/{tripId}")
    public List<Ticket> showAllTicketsByTripId(@PathVariable int tripId) {
        return ticketService.selectAllTicketsByTripId(tripId);
    }
	
	@GetMapping("/calculate/trip/{tripId}")
    public double calculateIncomeOfTripByTripId(@PathVariable int tripId) {
        return ticketService.calculateIncomeOfTripByTripId(tripId);
    }
	
	@GetMapping("/calculate/cashier/{cashierId}")
    public double calculateIncomeOfCashierByCashierId(@PathVariable int cashierId) {
        return ticketService.calculateIncomeOfCashierByCashierId(cashierId);
    }
	
	@GetMapping("/add/{tripId}")
    public void addNewTicketByTripId(@PathVariable int tripId, @RequestBody Ticket newTicket) {
        ticketService.insertNewTicketByTripId(tripId, newTicket);
    }
	
	@PostMapping("/add/{tripId}")
    public void addNewTicketByTripId2(@PathVariable int tripId, @RequestBody Ticket newTicket) {
        ticketService.insertNewTicketByTripId(tripId, newTicket);
    }

}
