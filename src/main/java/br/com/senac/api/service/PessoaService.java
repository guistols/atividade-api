package br.com.senac.api.service;


import br.com.senac.api.controller.dto.PessoaRequestDTO;
import br.com.senac.api.model.Pessoa;
import br.com.senac.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public Pessoa adicionarPessoa(PessoaRequestDTO pessoa){

        Pessoa pessoaPersist = this.pessoaRequestDtoParaPessoa(pessoa);

        return pessoaRepository.save(pessoaPersist);

    }

    public List<Pessoa> listarPessoa(){
        return pessoaRepository.findAll();
    }

    public Pessoa listarPessoaId(Long id) throws Exception {
        Optional<Pessoa> pessoaId = pessoaRepository.findById(id);
        if(pessoaId.isEmpty()){
            throw new Exception("Registro não encontrado");
        }
        return pessoaId.get();
    }

    public Pessoa atualizarPessoa(Long id, PessoaRequestDTO pessoa) throws Exception{
        if(pessoaRepository.existsById(id)==false){
            throw new Exception("Registro não encontrado");
        }
        Pessoa pessoaPersist = this.pessoaRequestDtoParaPessoa(pessoa);

        pessoaPersist.setId(id);

        return pessoaRepository.save(pessoaPersist);
    }

    private Pessoa pessoaRequestDtoParaPessoa( PessoaRequestDTO in){
        Pessoa out = new Pessoa();

        out.setNome(in.getNome());
        out.setSobrenome(in.getSobrenome());

        return out;


    }

    public void deletarPessoa(Long id) throws Exception{
        if(pessoaRepository.existsById(id)==false){
            throw new RuntimeException("Registro não encontrado");
        }

        pessoaRepository.deleteById(id);
    }

}
