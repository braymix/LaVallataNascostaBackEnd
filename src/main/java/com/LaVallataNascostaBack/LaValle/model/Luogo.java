package com.LaVallataNascostaBack.LaValle.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Luoghi")
public class Luogo {

	@Id
	private String id;

	private String titolo;

	private String descrizione;

	private String foto1;

	private String foto2;

	private String foto3;

	private String coordinate;

	public Luogo( String titolo, String descrizione, String foto1, String foto2, String foto3,
			String coordinate) {
		super();
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.foto1 = foto1;
		this.foto2 = foto2;
		this.foto3 = foto3;
		this.coordinate = coordinate;
	}
}
