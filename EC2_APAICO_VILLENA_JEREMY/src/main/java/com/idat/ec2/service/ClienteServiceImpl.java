package com.idat.ec2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec2.dto.ClienteRequestDTO;
import com.idat.ec2.model.Cliente;
import com.idat.ec2.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public void guardarCliente(ClienteRequestDTO p) {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(p.getIdCliente());
		cliente.setNombre(p.getNombre());
		cliente.setDni(p.getDni());
		cliente.setDireccion(p.getDireccion());
		repository.save(cliente);
	}

	@Override
	public void eliminarCliente(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarCliente(Cliente c) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(c);
	}

	@Override
	public List<Cliente> listarClientes() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Cliente clientsById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
