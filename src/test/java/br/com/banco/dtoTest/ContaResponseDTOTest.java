package br.com.banco.dtoTest;


import br.com.banco.dto.ContaResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

    @SpringBootTest
    public class ContaResponseDTOTest {

        @Test
        public void testGettersAndSetters() {
            // Criação de um objeto ContaResponseDTO para teste
            Integer id = 1;
            String nomeResponsavel = "Fulano";
            ContaResponseDTO contaResponseDTO = new ContaResponseDTO(id, nomeResponsavel);

            // Verificação dos getters
            assertEquals(id, contaResponseDTO.getId());
            assertEquals(nomeResponsavel, contaResponseDTO.getNomeResponsavel());

            // Modificação dos valores usando os setters
            Integer newId = 2;
            String newNomeResponsavel = "Sicrano";
            contaResponseDTO.setId(newId);
            contaResponseDTO.setNomeResponsavel(newNomeResponsavel);

            // Verificação das modificações
            assertEquals(newId, contaResponseDTO.getId());
            assertEquals(newNomeResponsavel, contaResponseDTO.getNomeResponsavel());
        }
    }
