package lv.venta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lv.venta.models.Driver;
import lv.venta.services.impl.DriverCRUDservice;


@RestController
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	private DriverCRUDservice driverService;
	
	
	@GetMapping("/showAll")
    public List<Driver> showAllDrivers() {
        return driverService.showAllDrivers();
    }
	
	@GetMapping("/showAll/{id}")
    public Driver showDriverById(@PathVariable int id) {
        return driverService.selectDriverById(id);
    }
	
	@GetMapping("/remove/{id}")
    public void removeDriverById(@PathVariable int id) {
        driverService.deleteDriverById(id);
    }
	
	@GetMapping("/addNew")
    public void addNewDriver(@RequestBody Driver driver) {
        driverService.insertNewDriver(driver);
    }
	
	@PostMapping("/addNew")
    public void addNewDriver2(@RequestBody Driver driver) {
        driverService.insertNewDriver(driver);
    }
	
	@GetMapping("/update/{id}")
    public void updateDriverById(@PathVariable int id, @RequestBody Driver updatedDriver) {
        Driver temp = new Driver();
        
        temp = updatedDriver;
        
        
    }
	
	/*TODO
	@PostMapping("/update/{id}")
	public void updateDriverById(@PathVariable int id, @RequestBody Driver updatedDriver) {
		 
	        }
	*/
	
}
