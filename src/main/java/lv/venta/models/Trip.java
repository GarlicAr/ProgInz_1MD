package lv.venta.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "trip_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Trip {
	
	private int trip_id;
	
	

}
