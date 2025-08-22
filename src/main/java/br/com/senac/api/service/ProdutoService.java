package br.com.senac.api.service;

import br.com.senac.api.controller.dto.ProdutoRequestDTO;
import br.com.senac.api.model.Carro;
import br.com.senac.api.model.Produto;
import br.com.senac.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto adicionarProduto(ProdutoRequestDTO produto){
        Produto produtoPersist = new Produto();

        produtoPersist.setDescricao(produto.getDescricao());
        produtoPersist.setNome(produto.getNome());

        return produtoRepository.save(produtoPersist);
    }

    public List<Produto> listarProduto(){
        return produtoRepository.findAll();
    }

    public Produto atualizarProduto(Long id, ProdutoRequestDTO produto) throws Exception {
        if(produtoRepository.existsById(id)==false){
            throw new Exception("Registro não encontrado");
        }

        Produto produtoPersist = new Produto();

        produtoPersist.setNome(produto.getNome());
        produtoPersist.setDescricao(produto.getDescricao());

        produtoPersist.setId(id);

        return produtoRepository.save(produtoPersist);
    }
}
