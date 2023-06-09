package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "ticket_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "ticket_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int ticket_id;
	
	@Column(name = "purchaseDateTime")
	@NotNull
	private String purchaseDateTime;
	
	@Column(name = "trip")
	@NotNull
	private Trip trip;
	
	@Column(name = "price")
	@NotNull
	private float price;
	
	@Column(name = "isChild")
	@NotNull
	private boolean isChild;
	
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="cashier_id")
	private Cashier cashier;

	public Ticket(
			String purchaseDateTime, 
			Trip trip,  
			float price, 
			boolean isChild,
			Cashier cashier) {
		
		this.purchaseDateTime = purchaseDateTime;
		this.trip = trip;
		this.price = price;
		this.isChild = isChild;
		this.cashier = cashier;
	}
	
	
	
	

}
