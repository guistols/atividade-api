package br.com.senac.api.controller;


import br.com.senac.api.controller.dto.CarroRequestDTO;
import br.com.senac.api.model.Carro;
import br.com.senac.api.service.CarroService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.Socket;
import java.util.List;

@Controller
@RequestMapping("/carro")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @PostMapping("/adicionar-carro")
    public ResponseEntity<Carro>adicionarCarro(@RequestBody CarroRequestDTO carro){
        System.out.println(carro.toString());
        return ResponseEntity.ok(carroService.adicionarCarro(carro));
    }

    @GetMapping("/listar-carro")
    public ResponseEntity<List<Carro>>listarCarro(){
        return ResponseEntity.ok(carroService.listarCarro());
    }

    @PutMapping("/atualizar-carro/{id}")
    public ResponseEntity<Carro> atualizarCarro(@PathVariable Long id, @RequestBody CarroRequestDTO carro){
        try{
            return ResponseEntity.ok(carroService.atualizarCarro(id,carro));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/deletar-carro/{id}")
    public ResponseEntity<Void> deletarCarro(@PathVariable Long id){
        try{
            carroService.deletarCarro(id);
            return ResponseEntity.ok(null);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
}
