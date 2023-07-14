package com.daniel.proyectoalitasonline.controller;


import com.daniel.proyectoalitasonline.dao.IPedidoRepository;
import com.daniel.proyectoalitasonline.dto.Pedido;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "pedido", produces = "application/json")
@CrossOrigin(origins = "*")
public class PedidoController {

    private IPedidoRepository pedidoRepository;

    public PedidoController(IPedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping("/{pedidoId}")
    public Pedido findById(@PathVariable("categoriaId") String id) {
        if (pedidoRepository.findById(id) != null) return pedidoRepository.findById(id);
        else return null;
    }

    @GetMapping("list")
    public Iterable<Pedido> listAll() {
        if (pedidoRepository.findAll().toString() != null) {
            return pedidoRepository.findAll();
        }
        return null;
    }

    @PostMapping(path = "/save", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido savePedido(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @PatchMapping(path = "/update/{pedidoId}", consumes = "application/json")
    public Pedido updatePedido(@PathVariable("pedidoId") String pedidoId, @RequestBody Pedido pedido) {
        return pedidoRepository.updatePedido(pedidoId, pedido);
    }

    @DeleteMapping("/delete/{pedidoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePedido(@PathVariable("pedidoId") String pedidoId) {
        try {
            pedidoRepository.delete(pedidoId);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("No se encontro pedido");
        }
    }
}
