package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.models.Driver;
import lv.venta.services.IDriverCRUDservice;

@Repository
public interface IDriverRepo extends CrudRepository<Driver, Integer>{
		
	
	
}
