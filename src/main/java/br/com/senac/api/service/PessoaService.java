package br.com.senac.api.service;


import br.com.senac.api.controller.dto.PessoaRequestDTO;
import br.com.senac.api.model.Pessoa;
import br.com.senac.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public Pessoa adicionarPessoa(PessoaRequestDTO pessoa){
        Pessoa pessoaPersist = new Pessoa();

        pessoaPersist.setNome(pessoa.getNome());
        pessoaPersist.setSobrenome(pessoa.getSobrenome());


        return pessoaRepository.save(pessoaPersist);

    }

    public List<Pessoa> listarPessoa(){
        return pessoaRepository.findAll();
    }

    public Pessoa atualizarPessoa(Long id, PessoaRequestDTO pessoa) throws Exception{
        if(pessoaRepository.existsById(id)==false){
            throw new Exception("Registro não encontrado");
        }

        Pessoa pessoaPersist = new Pessoa();

        pessoaPersist.setNome(pessoa.getNome());
        pessoaPersist.setSobrenome(pessoa.getSobrenome());

        pessoaPersist.setId(id);

        return pessoaRepository.save(pessoaPersist);
    }
}
