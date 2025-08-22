package br.com.senac.api.controller.dto;

public class PessoaResponseDTO extends PessoaRequestDTO{
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
