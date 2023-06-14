package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.models.Trip;

@Repository
public interface ITripRepo extends CrudRepository<Trip, Integer>{

}
