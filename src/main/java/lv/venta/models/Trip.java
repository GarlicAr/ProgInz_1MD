package lv.venta.models;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "trip_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Trip {
	
	
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int trip_id;
	
	
	@NotNull
	private Collection<City> cities = new ArrayList<>();
	
	@Column(name = "driver")
	@NotNull
	private Driver driver;
	
	@Column(name = "startDate")
	@NotNull
	private String startDate;
	
	@Column(name = "duration")
	@NotNull
	private int duration;
	

	public Trip(@NotNull 
			Driver driver, 
			String startDate,
			int duration) {
		
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
