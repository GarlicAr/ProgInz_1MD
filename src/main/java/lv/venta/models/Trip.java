package lv.venta.models;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Table(name = "trip_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Trip {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "trip_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int trip_id;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Trip_Cities_Table", 
	joinColumns = @JoinColumn(name = "trip_id"), 
	inverseJoinColumns = @JoinColumn(name = "city_id"))
	private Collection<City> cities;
	
	
	@OneToMany(mappedBy =  "trip")
	private Collection<Ticket> tickets;

	
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Driver driver;
	
	@Column(name = "startDate")
	@NotNull
	private String startDate;
	
	@Column(name = "duration")
	@NotNull
	private int duration;

	

	public Trip(
			Driver driver, 
			String startDate,
			int duration,
			ArrayList<City> cities) {
		
		this.cities=cities;
		this.driver = driver;
		this.startDate = startDate;
		this.duration = duration;
	}
	
	
	public void addCity(City city) {
		
		if (!cities.contains(city)) {
			cities.add(city);
		}
		
	}
	
	
	

}
