package br.com.senac.api.controller.dto;

import br.com.senac.api.model.Carro;

public class CarroResponseDTO extends CarroRequestDTO {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
