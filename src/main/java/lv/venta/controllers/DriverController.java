package lv.venta.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lv.venta.models.Driver;
import lv.venta.services.impl.DriverCRUDservice;


@Controller
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	private DriverCRUDservice driverService;
	
	
	@GetMapping("/showAll")
    public String showAllDrivers(org.springframework.ui.Model model) {
		
		model.addAttribute("MyDrivers", driverService.showAllDrivers());
		
        return "show-all-drivers";
    }
	
	@GetMapping("/showAll/{id}")
    public String showDriverById(@PathVariable int id, org.springframework.ui.Model model) {
		
		
		model.addAttribute("MyDrivers", driverService.selectDriverById(id));
		
        return "show-all-drivers";
    }
	
	@GetMapping("/remove/{id}")
    public String removeDriverById(@PathVariable("id") int id, org.springframework.ui.Model model) {
		
			driverService.deleteDriverById(id);
			model.addAttribute("MyDrivers", driverService.showAllDrivers());
			return "redirect:/driver/showAll";
		
        
    }
	
	@GetMapping("/addNew")
    public String addNewDriver(Driver driver) {
		
        return "insert-new-driver";
        
    }
	
	@PostMapping("/addNew")
    public String addNewDriver2(Driver driver) {
		
		Driver temp = new Driver(driver.getName(), driver.getSurname(), driver.getCategory());
		
		driverService.drivers.add(temp);
		
        return "redirect:/driver/showAll";
    }
	
	@GetMapping("/update/{id}")
    public String updateDriverById(@PathVariable("id") int id, org.springframework.ui.Model model) {
        

		try {
			Driver temp = driverService.selectDriverById(id);
			model.addAttribute("driver", temp);
			return "update-driver";
		}catch (Exception e) {
			
			return "error-page";
			
		}
        
    }
	
	
	@PostMapping("/update/{id}")
	public String updateDriverById2(@PathVariable int id, Driver updatedDriver) {
		 
		for(Driver temp : driverService.drivers) {
			if(temp.getDriver_id()==id) {
				temp.setName(updatedDriver.getName());
				temp.setSurname(updatedDriver.getSurname());
				temp.setCategory(updatedDriver.getCategory());
				return "redirect:/driver/showAll";
			}
		}
		return "error-page";
		
	}
	
	
}
