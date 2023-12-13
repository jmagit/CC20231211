package com.example;

public class ApplicationServiceImpl {
	private ProductoService srv;

	public ApplicationServiceImpl(ProductoService srv) {
		this.srv = srv;
	}
	
	public String algo(int id) {
//		return "Producto [id=1, nombre=kk]";
		var item = srv.getOne(id);
		if(item.isEmpty())
			throw new RuntimeException("No encontrado");
		return item.get().toString();
	}
	
}
