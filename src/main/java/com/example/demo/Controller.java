package com.example.demo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping(value = "products/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> agregarProducto(@RequestBody Products producto) {
        productoService.insertarProducto(producto);
        return ResponseEntity.ok("Producto agregado exitosamente.");
    }

    @PutMapping(value = "products/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarProducto(@RequestBody Products producto) {
        productoService.actualizarProducto(producto);
        return ResponseEntity.ok("Producto actualizado exitosamente.");
    }

    @DeleteMapping(value = "products/delete/{productId}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long productId) {
        productoService.eliminarProducto(productId);
        return ResponseEntity.ok("Producto eliminado exitosamente.");
    }
    @GetMapping(value = "products/higherThanFive", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Products> obtenerProductosPrecioSuperiorOIgualA5() {
        return productoService.obtenerTodosLosProductosPrecioSuperiorOIgualA5();
    }
    @GetMapping(value = "products/lowerThanFive", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Products> obtenerProductosPrecioInferiorA5() {
        return productoService.obtenerTodosLosProductosPrecioInferiorA5();
    }


}