package lv.venta.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lv.venta.models.Ticket;
import lv.venta.services.impl.TicketCRUDservice;


@Controller
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	private TicketCRUDservice ticketService;
	
	
	@GetMapping("/showAll/onlyChild")
    public String showAllChildTickets(Model model) {
		List<Ticket> temp = ticketService.selectAllChildTickets();
		
		model.addAttribute("MyTickets", temp);
		
        return "show-all-tickets";
    }
	
	@GetMapping("/showAll/less/{price}")
    public String showAllTicketsWherePriceIsLow(@PathVariable float price, Model model) {
		
		List<Ticket> ticketList = new ArrayList<>();
		
		for(Ticket ticket : ticketService.getAllTickets()) {
			if(ticket.getPrice() < price) {
				ticketList.add(ticket);
			}
		}
		
		model.addAttribute("MyTickets", ticketList);
		
        return "show-all-tickets";
    }
	
	@GetMapping("/showAll/trip/{tripId}")
    public String showAllTicketsByTripId(@PathVariable int tripId, Model model) {
		
		List<Ticket> temp = new ArrayList<>();
		
		List<Ticket> tickets = ticketService.getAllTickets();
		
		for(Ticket ticket : tickets) {
			if(ticket.getTrip().getTrip_id() == tripId) {
				temp.add(ticket);
			}
		}
		
		model.addAttribute("MyTickets", temp);
		
        return "show-all-tickets";
    }
	
	@GetMapping("/calculate/trip/{tripId}")
    public double calculateIncomeOfTripByTripId(@PathVariable int tripId) {
		
        return ticketService.calculateIncomeOfTripByTripId(tripId);
    }
	
	@GetMapping("/calculate/cashier/{cashierId}")
    public double calculateIncomeOfCashierByCashierId(@PathVariable int cashierId) {
		
        return ticketService.calculateIncomeOfCashierByCashierId(cashierId);
        
    }
	//TODO
	@GetMapping("/add/{tripId}")
    public String addNewTicketByTripId(@PathVariable int tripId,Ticket newTicket) {
		
		
       return "";
    }
	//TODO
	@PostMapping("/add/{tripId}")
    public void addNewTicketByTripId2(@PathVariable int tripId, @RequestBody Ticket newTicket) {
        ticketService.insertNewTicketByTripId(tripId, newTicket);
    }

}
