package br.com.godoydev.Exerciciossb.controllers;

import br.com.godoydev.Exerciciossb.models.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
