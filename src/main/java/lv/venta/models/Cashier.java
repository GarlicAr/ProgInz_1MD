package lv.venta.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "cashier_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cashier extends Person{
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private int cashier_id;

	public Cashier(@NotNull @Size(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String name,
			@NotNull @Size(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") String surname) {
		super(name, surname);
	}
	
	

}
