package com.idat.ec2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.ec2.dto.BodegaRequestDTO;
import com.idat.ec2.dto.ClienteRequestDTO;
import com.idat.ec2.model.Bodega;
import com.idat.ec2.model.Cliente;
import com.idat.ec2.service.BodegaService;


@RestController
@RequestMapping("/bodega/v1")
public class BodegaController {

	@Autowired
	private BodegaService service;
	

	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<Bodega>>listar(){
		
		return new ResponseEntity<List<Bodega>>(service.listarBodegas(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody BodegaRequestDTO bodega){
		service.guardarBodega(bodega);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<Bodega> bodegasById(@PathVariable Integer id){
		Bodega bodega = service.bodegasById(id);
		if(bodega != null) {
			return new ResponseEntity<Bodega>(bodega, HttpStatus.OK);

		}
		return new ResponseEntity<Bodega>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Bodega bodega = service.bodegasById(id);
		if(bodega != null) {
			service.eliminarBodega(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody Bodega bodegas){
		Bodega bodega = service.bodegasById(bodegas.getIdBodega());
		if(bodega != null) {
			service.editarBodega(bodega);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
