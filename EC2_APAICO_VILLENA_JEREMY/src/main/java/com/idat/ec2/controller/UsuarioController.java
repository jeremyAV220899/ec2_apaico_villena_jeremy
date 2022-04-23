package com.idat.ec2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.ec2.dto.UsuarioResponseDTO;
import com.idat.ec2.dto.UsuarioResquestDTO;
import com.idat.ec2.security.JWTUserDetailService;
import com.idat.ec2.security.JwtTokenUtil;



@RestController
@CrossOrigin
public class UsuarioController {
	
	@Autowired
	private JWTUserDetailService jwtUserDetailService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@RequestMapping(method = RequestMethod.POST, path = "/crearToken")
	public ResponseEntity<?>crearToken(@RequestBody UsuarioResquestDTO resquest){
		
		UserDetails userDetail =  jwtUserDetailService.loadUserByUsername(resquest.getUsuario());
		
		return ResponseEntity.ok(new UsuarioResponseDTO(jwtTokenUtil.generateToken(userDetail.getUsername())));
	}
}
