package com.idat.ec2.service;

import java.util.List;

import com.idat.ec2.dto.ClienteRequestDTO;
import com.idat.ec2.model.Cliente;

public interface ClienteService {

	public void guardarCliente(ClienteRequestDTO p);
	public void eliminarCliente(Integer id);
	public void editarCliente(Cliente c);
	public List<Cliente> listarClientes();
	public Cliente clientsById(Integer id);

}
