package lv.venta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lv.venta.models.Driver;
import lv.venta.models.Trip;
import lv.venta.services.impl.TripCRUDservice;


@Controller
@RequestMapping("/trip")
public class TripController {

	
	@Autowired
	private TripCRUDservice tripService;
	
	
	@GetMapping("/showAll")
    public String showAllDrivers(org.springframework.ui.Model model) {
		
		model.addAttribute("MyTrips", tripService.allTrips());
		
        return "show-all-trips";
    }
	
	@GetMapping("/showAll/city/{cityTitle}")
    public String showAllTripsByCityTitle(@PathVariable String cityTitle, Model model) {
		
		List<Trip> temp = tripService.selectAllTripsByCityTitle(cityTitle);
		
		model.addAttribute("MyTrips", temp);
		
		
        return "show-all-trips";
    }
	
	@GetMapping("/showAll/driver/{driverId}")
    public String showAllTripsByDriverId(@PathVariable int driverId, Model model) {
		
		List<Trip> driverList = tripService.selectAllTripsByDriverId(driverId);
		
		model.addAttribute("MyTrips", driverList);
		
        return "show-all-trips";
    }
	
	@GetMapping("/showAll/today")
    public String showAllTripsToday(Model model) {
		List<Trip> trips = tripService.selectAllTripsToday();
		
		model.addAttribute("MyTrips", trips);
		
        return "show-all-trips";
    }
	
	@GetMapping("/changeDriver/{tripId}/{driverId}")
    public String changeTripDriverByDriverId(@PathVariable(name = "tripId") int tripId, @PathVariable(name = "driverId") int driverId) {
		
        tripService.changeTripDriverByDriverId(tripId, driverId);
        
        return "redirect:/trip/showAll";
        
    }
	
	
}
