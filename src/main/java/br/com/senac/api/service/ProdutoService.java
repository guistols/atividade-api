package br.com.senac.api.service;

import br.com.senac.api.controller.dto.ProdutoRequestDTO;
import br.com.senac.api.model.Carro;
import br.com.senac.api.model.Produto;
import br.com.senac.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto adicionarProduto(ProdutoRequestDTO produto){
        Produto produtoPersist = produtoRequestDtoParaProduto(produto);

        return produtoRepository.save(produtoPersist);
    }

    public List<Produto> listarProduto(){
        return produtoRepository.findAll();
    }

    public Produto atualizarProduto(Long id, ProdutoRequestDTO produto) throws Exception {
        if(produtoRepository.existsById(id)==false){
            throw new Exception("Registro não encontrado");
        }

        Produto produtoPersist = this.produtoRequestDtoParaProduto(produto);


        produtoPersist.setId(id);

        return produtoRepository.save(produtoPersist);
    }

    public void deletarProduto(Long id) throws Exception{
        if(produtoRepository.existsById(id)==false){
            throw new Exception("Regsitro não encontrado");
        }

        produtoRepository.deleteById(id);
    }


    private Produto produtoRequestDtoParaProduto(ProdutoRequestDTO in){
        Produto out = new Produto();

        out.setNome(in.getNome());
        out.setDescricao(in.getDescricao());

        return out;
    }
}
