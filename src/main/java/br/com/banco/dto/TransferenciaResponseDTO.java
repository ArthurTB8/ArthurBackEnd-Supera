package br.com.banco.dto;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class TransferenciaResponseDTO {

    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataTransferencia;

    private Double valor;
    private String tipo;
    private String operadorTransacao;
    private ContaResponseDTO conta;

    public TransferenciaResponseDTO(Integer id, LocalDateTime dataTransferencia, Double valor, String tipo, String operadorTransacao, ContaResponseDTO conta) {
        this.id = id;
        this.dataTransferencia = dataTransferencia;
        this.valor = valor;
        this.tipo = tipo;
        this.operadorTransacao = operadorTransacao;
        this.conta = conta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(LocalDateTime dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOperadorTransacao() {
        return operadorTransacao;
    }

    public void setOperadorTransacao(String operadorTransacao) {
        this.operadorTransacao = operadorTransacao;
    }

    public ContaResponseDTO getConta() {
        return conta;
    }

    public void setConta(ContaResponseDTO conta) {
        this.conta = conta;
    }
}
