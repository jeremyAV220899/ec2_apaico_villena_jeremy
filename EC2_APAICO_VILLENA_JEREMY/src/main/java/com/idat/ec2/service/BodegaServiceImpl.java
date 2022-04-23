package com.idat.ec2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec2.dto.BodegaRequestDTO;
import com.idat.ec2.model.Bodega;
import com.idat.ec2.repository.BodegaRepository;

@Service
public class BodegaServiceImpl implements BodegaService {

	@Autowired
	private BodegaRepository repository;

	@Override
	public void guardarBodega(BodegaRequestDTO b) {
		Bodega bodega = new Bodega();
		bodega.setIdBodega(b.getIdBodega());
		bodega.setNombre(b.getNombre());
		bodega.setDireccion(b.getDireccion());
		repository.save(bodega);
	}
	@Override
	public void eliminarBodega(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarBodega(Bodega c) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(c);
	}

	@Override
	public List<Bodega> listarBodegas() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Bodega bodegasById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
}
