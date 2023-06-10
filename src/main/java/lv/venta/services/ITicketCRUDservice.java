package lv.venta.services;

import java.util.List;

import lv.venta.models.Ticket;

public interface ITicketCRUDservice {

	
	List<Ticket> selectAllChildTickets();
    
    List<Ticket> selectAllTicketsWherePriceIsLow(float price);
    
    List<Ticket> selectAllTicketsByTripId(int tripId);
    
    float calculateIncomeOfTripByTripId(int tripId);
    
    float calculateIncomeOfCashierByCashierId(int cashierId);
    
    void insertNewTicketByTripId(int tripId, Ticket newTicket);
}
