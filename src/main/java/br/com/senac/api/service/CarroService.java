package br.com.senac.api.service;

import br.com.senac.api.controller.dto.CarroRequestDTO;
import br.com.senac.api.model.Carro;
import br.com.senac.api.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public Carro adicionarCarro(CarroRequestDTO carro){
        Carro carroPersist = new Carro();

        carroPersist.setMarca(carro.getMarca());
        carroPersist.setModelo(carro.getModelo());

        return carroRepository.save(carroPersist);
    }

    public List<Carro> listarCarro(){
        return carroRepository.findAll();
    }

    public Carro atualizarCarro(Long id, CarroRequestDTO carro) throws Exception {
        if(carroRepository.existsById(id)==false){
            throw new Exception("Registro Não encontrado");
        }

        Carro carroPersist = new Carro();

        carroPersist.setModelo(carro.getModelo());
        carroPersist.setMarca(carro.getMarca());

        carroPersist.setId(id);

        return carroRepository.save(carroPersist);
    }

}
