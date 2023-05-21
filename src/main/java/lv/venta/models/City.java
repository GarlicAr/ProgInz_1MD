package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "city_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class City {
	
	@Setter(value = AccessLevel.NONE)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int city_id;
	
	@Column(name = "title")
	@NotNull
	private String title;
	
	@Column(name = "addressOfStation")
	@NotNull 
	private String addressOfStation;
	
	
	

	public City(@NotNull 
			String title, @NotNull 
			String addressOfStation) {
		
		this.title = title;
		this.addressOfStation = addressOfStation;
	}
	
	
	
	

}
