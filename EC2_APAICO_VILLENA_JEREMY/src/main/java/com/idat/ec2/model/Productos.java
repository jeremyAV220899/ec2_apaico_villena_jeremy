package com.idat.ec2.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name="productos")
@Entity
public class Productos {
	private static final long serialVersionUID = 6026109738059984351L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	private String Producto;
	private String descripcion;
	private Double precio;
	private Integer stock;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="producto_cliente",
	joinColumns = @JoinColumn(name="id_producto", 
	nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition 
			= "foreign key (id_producto) references productos (id_producto)")),
	inverseJoinColumns =  @JoinColumn(name="id_cliente", 
	nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition 
			= "foreign key (id_cliente) references clientes (id_cliente)"))
	)
	private List<Cliente> clientes = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "productos")
	private List<Productos> productos = new ArrayList<>();

	
	
	public List<Productos> getProductos() {
		return productos;
	}
	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getProducto() {
		return Producto;
	}
	public void setProducto(String producto) {
		Producto = producto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	
	
}
