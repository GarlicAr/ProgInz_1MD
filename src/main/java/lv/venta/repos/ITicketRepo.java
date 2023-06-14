package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.models.Ticket;

@Repository
public interface ITicketRepo extends CrudRepository<Ticket, Integer>{

}
