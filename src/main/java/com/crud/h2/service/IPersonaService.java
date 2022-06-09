package com.crud.h2.service;

import java.util.List;

import com.crud.h2.modelo.Persona;

public interface IPersonaService {
	
	public List<Persona> listar();

	public Persona listPersona(int id);

	public int agregar(Persona p);

	public int editar(Persona p);

	public void eliminar(int id);

}
