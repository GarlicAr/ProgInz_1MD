package lv.venta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lv.venta.models.Trip;
import lv.venta.services.impl.TripCRUDservice;


@RestController
@RequestMapping("/trip")
public class TripController {

	
	@Autowired
	private TripCRUDservice tripService;
	
	@GetMapping("/showAll/city/{cityTitle}")
    public List<Trip> showAllTripsByCityTitle(@PathVariable String cityTitle) {
        return tripService.selectAllTripsByCityTitle(cityTitle);
    }
	
	@GetMapping("/showAll/driver/{driverId}")
    public List<Trip> showAllTripsByDriverId(@PathVariable int driverId) {
        return tripService.selectAllTripsByDriverId(driverId);
    }
	
	@GetMapping("/showAll/today")
    public List<Trip> showAllTripsToday() {
        return tripService.selectAllTripsToday();
    }
	
	@GetMapping("/changeDriver/{tripId}/{driverId}")
    public void changeTripDriverByDriverId(@PathVariable int tripId, @PathVariable int driverId) {
        tripService.changeTripDriverByDriverId(tripId, driverId);
    }
	
	
}
