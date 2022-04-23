package com.idat.ec2.service;

import java.util.List;

import com.idat.ec2.dto.ProductosRequestDTO;
import com.idat.ec2.model.Productos;

public interface ProductoService {

	public void eliminarProducto(Integer id);

	public void editarProducto(Productos p);

	public List<Productos> listarProductos();

	public Productos productosById(Integer id);

	public void guardarProductos(ProductosRequestDTO p);

}
