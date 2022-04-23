package com.idat.ec2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec2.dto.ProductosRequestDTO;
import com.idat.ec2.model.Productos;
import com.idat.ec2.repository.ProductosRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductosRepository repository;
	
	@Override
	public void guardarProductos(ProductosRequestDTO p) {
		Productos producto = new Productos();
		producto.setIdProducto(p.getIdProducto());
		producto.setProducto(p.getProducto());
		producto.setDescripcion(p.getDescripcion());
		producto.setPrecio(p.getPrecio());
		producto.setStock(p.getStock());
		repository.save(producto);
	}
	
	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarProducto(Productos p) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(p);
	}

	@Override
	public List<Productos> listarProductos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Productos productosById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
