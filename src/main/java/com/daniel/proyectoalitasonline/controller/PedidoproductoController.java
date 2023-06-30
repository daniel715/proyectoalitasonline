package com.daniel.proyectoalitasonline.controller;

import com.daniel.proyectoalitasonline.dao.IPedidoProductoRepository;
import com.daniel.proyectoalitasonline.dto.Categoria;
import com.daniel.proyectoalitasonline.dto.PedidoProducto;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "pedidoproducto" , produces = "application/json")
@CrossOrigin(origins = "*" )
public class PedidoproductoController {

    private IPedidoProductoRepository pedidoProductoRepository;

    public PedidoproductoController(IPedidoProductoRepository iPedidoProducto){
        this.pedidoProductoRepository = iPedidoProducto;
    }

    @GetMapping("list")
    public Iterable<PedidoProducto> listAll(){
        if (pedidoProductoRepository.findAll().toString() != null) {
            return pedidoProductoRepository.findAll();
        }
        return null;
    }

    @PostMapping(path = "/save", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoProducto savePedidoProducto(@RequestBody PedidoProducto pedidoProducto) {
        return pedidoProductoRepository.save(pedidoProducto);
    }

    @PatchMapping(path = "/update/{pedidoId}/{productoId}", consumes = "application/json")
    public PedidoProducto updatePedidoProducto(@PathVariable("pedidoId") String pedidoId, @PathVariable("productoId") String productoId, @RequestBody PedidoProducto pedidoProducto) {
        return pedidoProductoRepository.updatePedidoProducto(pedidoId, productoId, pedidoProducto);
    }

    @DeleteMapping("/delete/{pedidoId}/{productoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePedidoProducto(@PathVariable("pedidoId") String pedidoId, @PathVariable("productoId") String productoId) {
        try {
            pedidoProductoRepository.delete(pedidoId, productoId);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("No se encontro registro");
        }
    }
}
