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

    public List<Carro> listarCarro(){
        return carroRepository.findAll();
    }

    public Carro adicionarCarro(CarroRequestDTO carro){
        Carro carroPersist = this.carroRequestDtoParaCarro(carro);

        return carroRepository.save(carroPersist);
    }

    public Carro atualizarCarro(Long id, CarroRequestDTO carro) throws Exception {
        if(carroRepository.existsById(id)==false){
            throw new Exception("Registro Não encontrado");
        }

        Carro carroPersist = this.carroRequestDtoParaCarro(carro);

        carroPersist.setId(id);

        return carroRepository.save(carroPersist);
    }

    public void deletarCarro(Long id) throws Exception {
        if(carroRepository.existsById(id)==false){
            throw new Exception("Registro não encontrado");
        }
        carroRepository.deleteById(id);
    }

    private Carro carroRequestDtoParaCarro (CarroRequestDTO in){
        Carro out = new Carro();

        out.setModelo(in.getModelo());
        out.setMarca(in.getMarca());

        return out;
    }

}
