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
		pruebaContactos.put("message", "Somos una start-up que esta siendo creada por 3 jovenes emorendedores\n"
				+ "en 2023 y que pretende estar finalizada a inicios de 2024.\n"
				+ "Aprovechando una idea de negocio ignovadora y sin competencia directa. \n"
				+ "El servicio que queremos ofrecer es una app en la que los usuarios puedan\n"
				+ "comparar los precios de frutas y verduras de distintas fruterias que tienen en su zona.\n"
				+ "\n"
				+ "De esta manera, toda esa gente que esta siendo afectada por la subida constante de\n"
				+ "los precios, puede tener una herramienta echa por nosotros que les puede ayudar a\n"
				+ "ahorrar un poco o por lo contrario que encuentren las mejores frutas y verduras a su critero");
		return pruebaContactos;
	}
	@GetMapping(value = "contact", produces = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseBody
		public HashMap<String, String> AboutUs() 
		{
			HashMap<String, String> pruebaContactos = new HashMap<>();
			pruebaContactos.put("Contacto:", "Email: frutafacil@gmail.com"
					+ " Telephono: +34 608 344 763");
			return pruebaContactos;
		}
	
}