package br.com.banco.dto;

public class ContaResponseDTO {

    private Integer id;
    private String nomeResponsavel;

    public ContaResponseDTO(Integer id, String nomeResponsavel) {
        this.id = id;
        this.nomeResponsavel = nomeResponsavel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
}
