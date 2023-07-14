package br.com.banco.dtoTest;

import br.com.banco.dto.ContaResponseDTO;
import br.com.banco.dto.TransferenciaResponseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TransferenciaResponseDTOTest {

    @Test
    public void testGettersAndSetters() {
        // Criação de objetos para teste
        Integer id = 1;
        LocalDateTime dataTransferencia = LocalDateTime.now();
        Double valor = 100.0;
        String tipo = "TRANSFERENCIA";
        String operadorTransacao = "Operador";
        ContaResponseDTO conta = new ContaResponseDTO(1, "Fulano");
        TransferenciaResponseDTO transferenciaResponseDTO = new TransferenciaResponseDTO(id, dataTransferencia, valor, tipo, operadorTransacao, conta);

        // Verificação dos getters
        assertEquals(id, transferenciaResponseDTO.getId());
        assertEquals(dataTransferencia, transferenciaResponseDTO.getDataTransferencia());
        assertEquals(valor, transferenciaResponseDTO.getValor());
        assertEquals(tipo, transferenciaResponseDTO.getTipo());
        assertEquals(operadorTransacao, transferenciaResponseDTO.getOperadorTransacao());
        assertNotNull(transferenciaResponseDTO.getConta());

        // Modificação dos valores usando os setters
        Integer newId = 2;
        LocalDateTime newDataTransferencia = LocalDateTime.now();
        Double newValor = 200.0;
        String newTipo = "SAQUE";
        String newOperadorTransacao = "Novo Operador";
        ContaResponseDTO newConta = new ContaResponseDTO(2, "Sicrano");
        transferenciaResponseDTO.setId(newId);
        transferenciaResponseDTO.setDataTransferencia(newDataTransferencia);
        transferenciaResponseDTO.setValor(newValor);
        transferenciaResponseDTO.setTipo(newTipo);
        transferenciaResponseDTO.setOperadorTransacao(newOperadorTransacao);
        transferenciaResponseDTO.setConta(newConta);

        // Verificação das modificações
        assertEquals(newId, transferenciaResponseDTO.getId());
        assertEquals(newDataTransferencia, transferenciaResponseDTO.getDataTransferencia());
        assertEquals(newValor, transferenciaResponseDTO.getValor());
        assertEquals(newTipo, transferenciaResponseDTO.getTipo());
        assertEquals(newOperadorTransacao, transferenciaResponseDTO.getOperadorTransacao());
        assertNotNull(transferenciaResponseDTO.getConta());
        assertEquals(newConta.getId(), transferenciaResponseDTO.getConta().getId());
        assertEquals(newConta.getNomeResponsavel(), transferenciaResponseDTO.getConta().getNomeResponsavel());
    }
}
