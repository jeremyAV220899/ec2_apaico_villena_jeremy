package com.idat.ec2.service;

import java.util.List;

import com.idat.ec2.dto.BodegaRequestDTO;
import com.idat.ec2.model.Bodega;

public interface BodegaService {

	public void guardarBodega(BodegaRequestDTO b);

	public List<Bodega> listarBodegas();

	public Bodega bodegasById(Integer id);

	public void editarBodega(Bodega c);

	public void eliminarBodega(Integer id);

}
