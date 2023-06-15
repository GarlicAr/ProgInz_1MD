package lv.venta.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.models.Trip;

@Repository
public interface ITripRepo extends CrudRepository<Trip, Integer>{

	//public ArrayList<Trip> findByDriverDriver_id();

}
