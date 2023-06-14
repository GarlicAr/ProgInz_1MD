package lv.venta.models;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lv.venta.models.enums.Categories;


@Entity
@Table(name = "driver_table")
@Getter
@Setter
@NoArgsConstructor
public class Driver extends Person{
	
	
	@Setter(value = AccessLevel.NONE)
	@Id
	@Column(name = "driver_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int driver_id;
	
	@Column(name = "category")
	@NotNull
	private Categories category;
	
	
	@OneToMany(mappedBy = "driver")
	private Collection<Trip> trips;
	
	

	public Driver(@NotNull @Size(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String name,
			@NotNull @Size(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String surname,
			@NotNull Categories category) {
		super(name, surname);
		this.category = category;
	}
	
	
	public void addTrip(Trip input) {
		
		if(!trips.contains(input)) {
			trips.add(input);
		}
	}
	

	
	
	
	
	
}
