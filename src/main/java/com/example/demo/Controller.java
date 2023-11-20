package com.example.demo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.service;

@RestController
public class Controller {

    @Autowired
    private service productoService;

    @GetMapping(value = "products", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Products> obtenerTodosLosProductos() {
            return productoService.obtenerTodosLosProductos();
    }
    @GetMapping(value = "About_Us", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<AboutUss> obtenerAboutUs() {
        return productoService.obtenerAboutUs();
    }
    @GetMapping(value = "Contact", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Contacts> obtenerContact() {
        return productoService.obtenerContact();
    }
}