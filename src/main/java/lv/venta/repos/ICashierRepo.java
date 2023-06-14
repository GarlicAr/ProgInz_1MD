package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.models.Cashier;
@Repository
public interface ICashierRepo extends CrudRepository<Cashier, Integer>{

}
