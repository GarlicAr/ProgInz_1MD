package lv.venta.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lv.venta.models.Ticket;
import lv.venta.services.ITicketCRUDservice;


@Service
public class TicketCRUDservice implements ITicketCRUDservice{
	
	
	private List<Ticket> tickets = new ArrayList<>();


	@Override
	public List<Ticket> selectAllChildTickets() {
		
		 List<Ticket> childTickets = new ArrayList<>();
	        
	        for (Ticket ticket : tickets) {
	            if (ticket.isChild()) {
	                childTickets.add(ticket);
	            }
	        }
	        
	        return childTickets;
	}

	@Override
	public List<Ticket> selectAllTicketsWherePriceIsLow(float threshold) {
		List<Ticket> lowPriceTickets = new ArrayList<>();
        
        for (Ticket ticket : tickets) {
            if (ticket.getPrice() < threshold) {
                lowPriceTickets.add(ticket);
            }
        }
        
        return lowPriceTickets;
	}

	@Override
	public List<Ticket> selectAllTicketsByTripId(int tripId) {
		List<Ticket> ticketsWithTripID = new ArrayList<>();
		
		for(Ticket ticket: tickets) {
			if(ticket.getTrip().getTrip_id() == tripId) {
				ticketsWithTripID.add(ticket);
			}
		}
		
		return ticketsWithTripID;
		
		
	}

	@Override
	public float calculateIncomeOfTripByTripId(int tripId) {
		float income = 0;
		
		for(Ticket ticket: tickets) {
			if(ticket.getTrip().getTrip_id() == tripId) {
				income += ticket.getPrice();
			}
			
		}
		
		return income;
	}

	@Override
	public float calculateIncomeOfCashierByCashierId(int cashierId) {
		float income = 0;
		
		for (Ticket ticket: tickets ) {
			if(ticket.getCashier().getCashier_id() == cashierId) {
				income += ticket.getPrice();
			}
		}
		
		return income;
	}

	@Override
	public void insertNewTicketByTripId(int tripId, Ticket newTicket) {
		

		//TODO
		
	}

}
