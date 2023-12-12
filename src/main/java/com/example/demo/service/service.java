package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.AboutUss;
import com.example.demo.Contacts;
import com.example.demo.Products;
import com.example.demo.dao.Dao;

import java.util.List;
 
@Service
public class service {
 
    @Autowired
    private Dao productoDAO;
 
    public List<Products> obtenerTodosLosProductos() {
        return productoDAO.obtenerTodosLosProductos();
    }
    public List<AboutUss> obtenerAboutUs() {
        return productoDAO.obtenerAboutUs();
    }
    public List<Contacts> obtenerContact() {
        return productoDAO.obtenerContact();
    }
    public void insertarProducto(Products producto) {
        productoDAO.insertarProducto(producto);
    }

    public void actualizarProducto(Products producto) {
        productoDAO.actualizarProducto(producto);
    }
    
    public void eliminarProducto(Long productId) {
        productoDAO.eliminarProducto(productId);
    }
    
    public List<Products> obtenerTodosLosProductosPrecioSuperiorOIgualA5() {
        return productoDAO.obtenerTodosLosProductosPrecioSuperiorOIgualA5();
    }
    public List<Products> obtenerTodosLosProductosPrecioInferiorA5() {
        return productoDAO.obtenerTodosLosProductosPrecioInferiorA5();
    }

}