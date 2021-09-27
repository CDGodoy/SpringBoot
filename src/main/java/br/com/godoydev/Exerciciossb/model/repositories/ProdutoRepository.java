package br.com.godoydev.Exerciciossb.model.repositories;

import br.com.godoydev.Exerciciossb.model.entities.Produto;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {

    public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);

    //findByNomeContaining
    //findByNomeIsContaining
    //findByNomeCointains
    //
    //findByNomeStartsWith
    //findByNomeEndsWith
    //
    //findByNomeNotContaining
}
