package lv.venta.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.City;
import lv.venta.models.Driver;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import lv.venta.models.Trip;
import lv.venta.repos.ICityRepo;
import lv.venta.repos.IDriverRepo;
import lv.venta.repos.ITripRepo;
import lv.venta.services.ITripCRUDservice;

@Service
public class TripCRUDservice implements ITripCRUDservice{

	
	@Autowired
 	private IDriverRepo driverRepo;
	
	@Autowired
	private ICityRepo cityRepo;
	
	@Autowired
	private ITripRepo tripRepo;
 
	
	public List<Trip> allTrips(){

		return (List<Trip>) tripRepo.findAll();
	}
	

	
	@Override
	public List<Trip> selectAllTripsByCityTitle(String cityTitle) {
	    List<Trip> tripsByCity = new ArrayList<>();

	    for (Trip trip : allTrips()) {
	        for (City city : trip.getCities()) {
	            if (city.getTitle().equals(cityTitle)) {
	                tripsByCity.add(trip);
	                break; 
	            }
	        }
	    }

	    return tripsByCity;
	}

	@Override
	public List<Trip> selectAllTripsByDriverId(int driverId) {
		
		List<Trip> tripsByDriver = new ArrayList<>();
        
        for (Trip trip : allTrips()) {
            if (trip.getDriver().getDriver_id() == driverId) {
                tripsByDriver.add(trip);
            }
        }
        
        return tripsByDriver;

		
	}



	public List<Trip> selectAllTripsToday() {
	    List<Trip> tripsToday = new ArrayList<>();
	    LocalDate today = LocalDate.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	    for (Trip trip : allTrips()) {
	        LocalDate startDate = LocalDate.parse(trip.getStartDate(), formatter);
	        if (startDate.equals(today)) {
	            tripsToday.add(trip);
	        }
	    }

	    return tripsToday;
	}



	@Override
	public void changeTripDriverByDriverId(int tripId, int driverId) {
		
		Driver temp = new Driver();
		
		Trip tempTrip = new Trip();
		
		List<Driver> drivers = (List<Driver>) driverRepo.findAll();
		
		for(Driver driver: drivers) {
			if(driver.getDriver_id() == driverId) {
				temp = driver;
				break;
			}
		}
		
		for(Trip trip: allTrips()) {
			if(trip.getTrip_id() == tripId) {
				tempTrip = trip;
				break;
			}
			
		}
		
		tempTrip.setDriver(temp);
		
		tripRepo.save(tempTrip);
		
	}

}
