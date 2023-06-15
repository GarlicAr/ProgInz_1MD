package lv.venta.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Ticket;
import lv.venta.repos.ITicketRepo;
import lv.venta.services.ITicketCRUDservice;


@Service
public class TicketCRUDservice implements ITicketCRUDservice{
	
	@Autowired
	private ITicketRepo ticketRepo;


	@Override
	public List<Ticket> selectAllChildTickets() {
		
		 List<Ticket> childTickets = new ArrayList<>();
	        
	        for (Ticket ticket : getAllTickets()) {
	            if (ticket.isChild()) {
	                childTickets.add(ticket);
	            }
	        }
	        
	        return childTickets;
	}

	@Override
	public List<Ticket> selectAllTicketsWherePriceIsLow(float threshold) {
		List<Ticket> lowPriceTickets = new ArrayList<>();
        
        for (Ticket ticket : getAllTickets()) {
            if (ticket.getPrice() < threshold) {
                lowPriceTickets.add(ticket);
            }
        }
        
        return lowPriceTickets;
	}

	@Override
	public List<Ticket> selectAllTicketsByTripId(int tripId) {
		List<Ticket> ticketsWithTripID = new ArrayList<>();
		
		for(Ticket ticket: getAllTickets()) {
			if(ticket.getTrip().getTrip_id() == tripId) {
				ticketsWithTripID.add(ticket);
			}
		}
		
		return ticketsWithTripID;
		
		
	}

	@Override
	public float calculateIncomeOfTripByTripId(int tripId) {
		float income = 0;
		
		for(Ticket ticket: getAllTickets()) {
			if(ticket.getTrip().getTrip_id() == tripId) {
				income += ticket.getPrice();
			}
			
		}
		
		return income;
	}

	@Override
	public float calculateIncomeOfCashierByCashierId(int cashierId) {
		float income = 0;
		
		for (Ticket ticket: getAllTickets() ) {
			if(ticket.getCashier().getCashier_id() == cashierId) {
				income += ticket.getPrice();
			}
		}
		
		return income;
	}

	@Override
	public void insertNewTicketByTripId(int tripId, Ticket newTicket) {
		
		Ticket temp = new Ticket(newTicket.getPurchaseDateTime(), newTicket.getTrip(), newTicket.getPrice(), newTicket.isChild(), newTicket.getCashier());
		
		getAllTickets().add(temp);
		ticketRepo.save(temp);
		
		
	}


	@Override
	public List<Ticket> getAllTickets() {
		return (List<Ticket>) ticketRepo.findAll();
	}

}
