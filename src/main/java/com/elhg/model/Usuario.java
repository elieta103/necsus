package com.elhg.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Usuario implements Comparable<Usuario> {
	private Long id;
	private String nombre;
	private String correo;
	
	@Override
	public int compareTo(Usuario u) {
		return (int) (this.id - u.getId());
	}
}
