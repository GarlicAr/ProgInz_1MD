package lv.venta.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lv.venta.models.Driver;
import lv.venta.models.Trip;
import lv.venta.services.IDriverCRUDservice;
import lv.venta.services.ITripCRUDservice;
import lv.venta.services.impl.DriverCRUDservice;


public class TripCRUDservice implements ITripCRUDservice{

	private List<Trip> trips = new ArrayList<>();
	private List<Driver> drivers = new ArrayList<>();
 	
	
	@Override
	public List<Trip> selectAllTripsByCityTitle(String cityTitle) {
		List<Trip> tripsByCity = new ArrayList<>();
		
        
        for (Trip trip : trips) {
            if (trip.getCities().contains(cityTitle)) {
                tripsByCity.add(trip);
            }
        }
        
        return tripsByCity;
	}

	@Override
	public List<Trip> selectAllTripsByDriverId(int driverId) {
		
		List<Trip> tripsByDriver = new ArrayList<>();
        
        for (Trip trip : trips) {
            if (trip.getDriver().getDriver_id() == driverId) {
                tripsByDriver.add(trip);
            }
        }
        
        return tripsByDriver;

		
	}

	@Override
	public List<Trip> selectAllTripsToday() {
		 List<Trip> tripsToday = new ArrayList<>();
	        Date today = new Date();
	        
	        for (Trip trip : trips) {
	            if (trip.getStartDate().equals(today)) {
	                tripsToday.add(trip);
	            }
	        }
	        
	        return tripsToday;
	}

	@Override
	public void changeTripDriverByDriverId(int tripId, int driverId) {
		
		Driver temp = new Driver();
		
		for(Driver driver: drivers) {
			if(driver.getDriver_id() == driverId) {
				temp = driver;
			}
			
			new Exception("Nav atrasts vadītājs!");
			break;
		}
		
		for(Trip trip: trips) {
			if(trip.getTrip_id() == tripId) {
				trip.setDriver(temp);
			}
			new Exception("Nav atrasts ceļojums!");
			break;
		}
		
	}

}
