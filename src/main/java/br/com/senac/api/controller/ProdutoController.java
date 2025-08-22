package br.com.senac.api.controller;

import br.com.senac.api.controller.dto.ProdutoRequestDTO;
import br.com.senac.api.model.Produto;
import br.com.senac.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;



    @PostMapping("/adicionar-produto")
    public ResponseEntity<Produto>adicionarProduto(@RequestBody ProdutoRequestDTO produto){
        System.out.println(produto.toString());
        return ResponseEntity.ok(produtoService.adicionarProduto(produto));
    }

    @GetMapping("/listar-produto")
    public ResponseEntity<List<Produto>>listarProduto(){
        return ResponseEntity.ok(produtoService.listarProduto());
    }

    @PutMapping("/atualizar-produto/{id}")
    public ResponseEntity<Produto>atualizarProduto(@PathVariable Long id, @RequestBody ProdutoRequestDTO produto) {
        try{
            return ResponseEntity.ok(produtoService.atualizarProduto(id,produto));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
}
