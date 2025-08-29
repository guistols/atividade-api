package br.com.senac.api.controller;

import br.com.senac.api.controller.dto.PessoaRequestDTO;
import br.com.senac.api.model.Pessoa;
import br.com.senac.api.service.PessoaService;
import br.com.senac.api.utils.ResponseUtil;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/adicionar-pessoa")
    public ResponseEntity<Pessoa>adicionarPessoa(@RequestBody PessoaRequestDTO pessoa){
        System.out.println(pessoa.toString());
        return ResponseEntity.ok(pessoaService.adicionarPessoa(pessoa));
    }

    @GetMapping("/listar-pessoa")
    public ResponseEntity<List<Pessoa>>listarPessoa(){
        return ResponseEntity.ok(pessoaService.listarPessoa());
    }

    @GetMapping("/listar-pessoa-id/{id}")
    public ResponseEntity<Pessoa>listarPessoaId(@PathVariable Long id){
        try {
            return ResponseEntity.ok(pessoaService.listarPessoaId(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PutMapping("/atualizar-pessoa/{id}")
    public ResponseEntity<Pessoa>atualizarPessoa(@PathVariable Long id, @RequestBody PessoaRequestDTO pessoa){
        try{
            return ResponseEntity.ok(pessoaService.atualizarPessoa(id,pessoa));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/deletar-pessoa/{id}")
    public ResponseEntity<?> deletarPessoa(@PathVariable Long id){
        try{
            pessoaService.deletarPessoa(id);
            return ResponseEntity.ok(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.response(e.getMessage()));
        }
    }

}
