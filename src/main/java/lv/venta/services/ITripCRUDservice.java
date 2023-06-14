package lv.venta.services;

import java.util.List;

import lv.venta.models.Trip;

public interface ITripCRUDservice {

	
	List<Trip> selectAllTripsByCityTitle(String cityTitle);
    
    List<Trip> selectAllTripsByDriverId(int driverId);
    
    List<Trip> selectAllTripsToday();
    
    void changeTripDriverByDriverId(int tripId, int driverId);
    

}
