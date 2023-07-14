package br.com.banco.dto;

import javax.validation.constraints.Pattern;

import javax.validation.constraints.Pattern;

public class FiltroRequestDTO {

    @Pattern(regexp = "^\\d{2}\\-\\d{2}\\-\\d{4}\\s*(?:\\d{2}:\\d{2}(?::\\d{2})?)?$",
            message = "O campo 'dataInicio' deve seguir o seguinte padrão: dd-MM-yyyy (hh:mm:ss opcional).")
    private String dataInicio;

    @Pattern(regexp = "^\\d{2}\\-\\d{2}\\-\\d{4}\\s*(?:\\d{2}:\\d{2}(?::\\d{2})?)?$",
            message = "O campo 'dataFim' deve seguir o seguinte padrão: dd-MM-yyyy (hh:mm:ss opcional).")
    private String dataFim;

    private String nomeOperador;

    public FiltroRequestDTO(String dataInicio, String dataFim, String nomeOperador) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.nomeOperador = nomeOperador;
    }

    @Override
    public String toString() {
        return "FiltroRequestDTO{" +
                "dataInicio='" + dataInicio + '\'' +
                ", dataFim='" + dataFim + '\'' +
                ", nomeOperador='" + nomeOperador + '\'' +
                '}';
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getNomeOperador() {
        return nomeOperador;
    }

    public void setNomeOperador(String nomeOperador) {
        this.nomeOperador = nomeOperador;
    }
}
