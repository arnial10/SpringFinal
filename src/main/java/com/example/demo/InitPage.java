package com.example.demo;
import java.util.HashMap;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
@RestController
public class InitPage {
	@GetMapping(value = "about_us", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public HashMap<String, String> PaginaInicio() 
	{
		HashMap<String, String> pruebaContactos = new HashMap<>();
		pruebaContactos.put("message", "¡¡Bienvenido a Minimalist!!\r\n"
				+ "Minimalist es una app de recetas de cocina, donde podemos subir y ver recetas, además las puedes agregar a tus favoritos.\r\n"
				+ "Nuestro grupo está compuesto por:\r\n"
				+ "Oscar Gimeno Sáez\r\n"
				+ "Arnau Figueras Moreno\r\n"
				+ "Pol Corado");
		return pruebaContactos;
	}
	@GetMapping(value = "contact", produces = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseBody
		public HashMap<String, String> AboutUs() 
		{
			HashMap<String, String> pruebaContactos = new HashMap<>();
			pruebaContactos.put("Contacto:", "Email: minimalist@gmail.com"
					+ " Telefono: +34 621 334 889");
			return pruebaContactos;
		}
	
}