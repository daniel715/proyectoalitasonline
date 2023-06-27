package com.daniel.proyectoalitasonline.controller;

import com.daniel.proyectoalitasonline.dao.IProductoRepository;
import com.daniel.proyectoalitasonline.dto.Categoria;
import com.daniel.proyectoalitasonline.dto.Producto;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "producto" , produces = "application/json")
@CrossOrigin(origins = "*" )
public class ProductoController {

    private IProductoRepository productoRepository;

    public ProductoController(IProductoRepository iProductoRepository){
        this.productoRepository = iProductoRepository;
    }

    @GetMapping("/{productoId}")
    public Producto findById(@PathVariable("productoId") String id){
        if (productoRepository.findById(id) != null ) return productoRepository.findById(id);
        else return null;
    }

    @GetMapping("list")
    public Iterable<Producto> listAll(){
        if (productoRepository.findAll().toString() != null) {
            return productoRepository.findAll();
        }
        return null;
    }

    @PostMapping(path = "/save", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto saveProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @PatchMapping(path = "/update/{productoId}", consumes = "application/json")
    public Producto updateProducto(@PathVariable("productoId") String productoId, @RequestBody Producto producto) {
        return productoRepository.updateProducto(productoId, producto);
    }

    @DeleteMapping("/delete/{productoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProducto(@PathVariable("productoId") String productoId) {
        try {
            productoRepository.delete(productoId);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("No se encontro autor");
        }
    }

}
