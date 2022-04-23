package com.idat.ec2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.ec2.model.Productos;
@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer>{

}
