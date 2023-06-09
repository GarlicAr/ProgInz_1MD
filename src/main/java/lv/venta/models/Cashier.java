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

@Table(name = "cashier_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cashier extends Person{
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "cashier_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private int cashier_id;
	
	@OneToMany(mappedBy = "cashier")
	private Collection<Ticket> tickets = new ArrayList<>();

	public Cashier( 
			String name,
			String surname) {
		
		super(name, surname);
	}

	public void addTicket(Ticket input) {
		
		if(!tickets.contains(input)) {
			tickets.add(input);
		}
		
	}
	
	

}
