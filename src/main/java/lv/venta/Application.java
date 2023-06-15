package lv.venta;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.models.Cashier;
import lv.venta.models.City;
import lv.venta.models.Driver;
import lv.venta.models.Ticket;
import lv.venta.models.Trip;
import lv.venta.models.enums.Categories;
import lv.venta.repos.ICashierRepo;
import lv.venta.repos.ICityRepo;
import lv.venta.repos.IDriverRepo;
import lv.venta.repos.ITicketRepo;
import lv.venta.repos.ITripRepo;
import lv.venta.services.IDriverCRUDservice;
import lv.venta.services.ITicketCRUDservice;
import lv.venta.services.ITripCRUDservice;
import lv.venta.services.impl.DriverCRUDservice;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	//@Bean // Calls function when system runs
	public CommandLineRunner testModel(
			ICashierRepo cashierRepo, 
			ICityRepo cityRepo, 
			IDriverRepo driverRepo,
			ITicketRepo ticketRepo, 
			ITripRepo tripRepo,
			IDriverCRUDservice driverService,
			ITicketCRUDservice ticketService,
			ITripCRUDservice tripService) {

		return new CommandLineRunner() {
			
			

			@Override
			public void run(String... args) throws Exception {
				// Drivers

				Driver dr1 = new Driver("Juris", "Zigitis", Categories.schoolbus);
				Driver dr2 = new Driver("Marta", "Kante", Categories.largebus);
				Driver dr3 = new Driver("Zane", "Busule", Categories.minibus);
				driverRepo.save(dr1);
				driverRepo.save(dr2);
				driverRepo.save(dr3);
				
				
				
			
				// Cashiers

				Cashier csh1 = new Cashier("Sergejs", "Bundzinieks");
				Cashier csh2 = new Cashier("Aleksandrs", "Kotlete");
				Cashier csh3 = new Cashier("Ugis", "Cesinieks");
				cashierRepo.save(csh1);
				cashierRepo.save(csh2);
				cashierRepo.save(csh3);

				// Cities

				City ct1 = new City("Liepaja", "Zirgu iela 1");
				City ct2 = new City("Riga", "Krievijas iela 4");
				City ct3 = new City("Aizkraukle", "Stacijas laukums 6");
				City ct4 = new City("Skriveri", "Stacijas laukums 1");
				City ct5 = new City("Cesis", "Vizmas laukums 4");
				City ct6 = new City("Bauska", "Oligarhu centrs 8");
				City ct7 = new City("Daugavpils", "Daugavpilski oblastj 12");
				cityRepo.save(ct1);
				cityRepo.save(ct2);
				cityRepo.save(ct3);
				cityRepo.save(ct4);
				cityRepo.save(ct5);
				cityRepo.save(ct6);
				cityRepo.save(ct7);

				// TripCities

				ArrayList<City> Reiss_Nr1 = new ArrayList<>();
				Reiss_Nr1.add(ct1);
				Reiss_Nr1.add(ct3);

				ArrayList<City> Reiss_Nr2 = new ArrayList<>();
				Reiss_Nr2.add(ct7);
				Reiss_Nr2.add(ct6);
				Reiss_Nr2.add(ct5);

				ArrayList<City> Reiss_Nr3 = new ArrayList<>();
				Reiss_Nr3.add(ct4);
				Reiss_Nr3.add(ct2);
				Reiss_Nr3.add(ct1);

				// Trips

				Trip tr1 = new Trip(dr1, "24/02/2023", 40, Reiss_Nr1);
				Trip tr2 = new Trip(dr2, "12/03/2023", 120, Reiss_Nr2);
				Trip tr3 = new Trip(dr3, "01/02/2023", 210, Reiss_Nr3);
				Trip tr4 = new Trip(dr1, "12/06/2023", 120, Reiss_Nr2);
				tripRepo.save(tr1);
				tripRepo.save(tr2);
				tripRepo.save(tr3);
				tripRepo.save(tr4);
				
				
				
				

				// Tickets

				Ticket tk1 = new Ticket("24/02/2023 16:24", tr1, (float) 24.22, false, csh1);
				Ticket tk2 = new Ticket("12/03/2023 08:24", tr2, (float) 52.42, true, csh2);
				Ticket tk3 = new Ticket("01/02/2023 22:10", tr3, (float) 92.00, false, csh3);
				ticketRepo.save(tk1);
				ticketRepo.save(tk2);
				ticketRepo.save(tk3);
				
				

			}
		};

	}
	
	
	
}
