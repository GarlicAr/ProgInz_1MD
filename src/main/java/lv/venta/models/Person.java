package lv.venta.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@MappedSuperclass
@Getter
@Setter
@ToString
public class Person {
	
	@Column(name = "student_name")
	@NotNull
	@Size(min = 3, max = 15)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+")
	private String name;
	
	@Column(name = "student_surname")
	@NotNull
	@Size(min = 3, max = 15)
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+")
	private String surname;
	

	public Person(@NotNull @Size(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") 
	String name,
			@NotNull @Size(min = 3, max = 15) @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+") 
	String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	
	
	
	
}
