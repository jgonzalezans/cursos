package model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pais {
	private int idpais;
	@SerializedName(value="name")
	private String nombre;
	@SerializedName(value="population")
	private long poblacion;
	@SerializedName(value="capital")
	private String capital;
	@SerializedName(value="region")
	private String continente;
}
