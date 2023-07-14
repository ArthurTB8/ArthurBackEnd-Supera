package br.com.banco.entities;
import br.com.banco.dto.ContaResponseDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "conta")
public class Conta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Integer id;

    @Column(name = "nome_responsavel")
    private String nomeResponsavel;

    @OneToMany(mappedBy = "conta")
    private List<Transferencia> transferencias;

    public Conta() {
    }

    public Conta(Integer id, String nomeResponsavel) {
        this.id = id;
        this.nomeResponsavel = nomeResponsavel;
    }

    public Conta(Integer id, String nomeResponsavel, List<Transferencia> transferencias) {
        this.id = id;
        this.nomeResponsavel = nomeResponsavel;
        this.transferencias = transferencias;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", nomeResponsavel='" + nomeResponsavel + '\'' +
                ", transferencias=" + transferencias +
                '}';
    }

    public ContaResponseDTO toResponseDto() {
        return new ContaResponseDTO(id, nomeResponsavel);
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

    public List<Transferencia> getTransferencias() {
        return transferencias;
    }

    public void setTransferencias(List<Transferencia> transferencias) {
        this.transferencias = transferencias;
    }
}
