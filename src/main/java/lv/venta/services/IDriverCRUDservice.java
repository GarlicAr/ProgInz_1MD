package lv.venta.services;

import java.util.List;

import lv.venta.models.Driver;

public interface IDriverCRUDservice{
	
	
	Driver selectDriverById(int driverId);
	
	List<Driver> showAllDrivers();
    
    void deleteDriverById(int driverId);
    
    void insertNewDriver(Driver driver);
    
    void updateDriverById(int driverId);


}
