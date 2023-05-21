package lv.venta.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.venta.models.enums.Categories;


@Entity
@Table(name = "driver_table")
@Getter
@Setter
@NoArgsConstructor
public class Driver extends Person{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private int driver_id;
	
	@Column(name = "category")
	@NotNull
	private Categories category;
	
	

	public Driver(@NotNull @Size(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String name,
			@NotNull @Size(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String surname,
			@NotNull Categories category) {
		super(name, surname);
		this.category = category;
	}
	
	

	
	
	
	
	
}
