package com.crud.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.h2.modelo.Persona;
import com.crud.h2.modeloDAO.IPersona;


@Service
public class PersonaService implements IPersonaService {

	@Autowired
	private IPersona dao;
	
	@Override
	public List<Persona> listar() {
		return dao.listar();
	}

	@Override
	public Persona listPersona(int id) {
		return dao.listPersona(id);
	}

	@Override
	public int agregar(Persona p) {
		dao.agregar(p);
		return 0;
	}

	@Override
	public int editar(Persona p) {
		dao.editar(p);
		return 0;
	}

	@Override
	public void eliminar(int id) {
		dao.eliminar(id);
		
	}

}
