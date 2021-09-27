package br.com.godoydev.Exerciciossb.controllers;

import br.com.godoydev.Exerciciossb.model.entities.Produto;
import br.com.godoydev.Exerciciossb.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

//    @PostMapping
//    public @ResponseBody Produto novoProduto(@RequestParam String nome,
//                                             @RequestParam double preco,
//                                             @RequestParam double desconto){
//        Produto produto = new Produto(nome, preco, desconto);
//        produtoRepository.save(produto);
//        return produto;
//    }
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody Produto novoProduto(@Valid Produto produto){
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping
    public Iterable<Produto> obterProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping(path = "/nome/{parteNome}")
    public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome){
        return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
    }

    @GetMapping(path = "/pagina/{numeroPagina}")
    public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina){
        Pageable page = PageRequest.of(numeroPagina,5);
        return produtoRepository.findAll(page);
    }

    @GetMapping(path="/{id}")
    public Optional<Produto> obterProdutoPorId(@PathVariable int id){
        return produtoRepository.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void excluirProduto(@PathVariable int id){
        produtoRepository.deleteById(id);
    }


//    @PutMapping
//    public Produto alterarProduto(@Valid Produto produto){
//        return produtoRepository.save(produto);
//    }

}
