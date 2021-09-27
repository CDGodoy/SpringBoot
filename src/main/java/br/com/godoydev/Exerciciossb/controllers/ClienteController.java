package br.com.godoydev.Exerciciossb.controllers;

import br.com.godoydev.Exerciciossb.model.entities.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "/clientes")
public class ClienteController {

    @GetMapping("/qualquer2")
    public Cliente obterCliente(){
        return new Cliente(01, "Teste", "123.456.789-00");
    }

    @GetMapping("/{id}")
    public Cliente obterClientePorId1(@PathVariable int id){
        return new Cliente(id, "Maria", "123.456.789-00");
    }

    @GetMapping
    public Cliente obterClientePorId2(@RequestParam(name = "id", defaultValue = "1") int id){
        return new Cliente(id, "João", "123.456.789-00");
    }
}
