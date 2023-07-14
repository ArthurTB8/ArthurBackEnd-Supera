package br.com.banco.dtoTest;

import br.com.banco.dto.FiltroRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FiltroRequestDTOTest {

    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();

    @Test
    public void testDataInicioPattern() {
        FiltroRequestDTO filtroRequestDTO = new FiltroRequestDTO("01-01-2022", "31-01-2022", "Operador");
        assertTrue(validator.validate(filtroRequestDTO).isEmpty());
    }

    @Test
    public void testDataFimPattern() {
        FiltroRequestDTO filtroRequestDTO = new FiltroRequestDTO("01-01-2022", "31-01-2022", "Operador");
        assertTrue(validator.validate(filtroRequestDTO).isEmpty());
    }

    @Test
    public void testToString() {
        String dataInicio = "01-01-2022";
        String dataFim = "31-01-2022";
        String nomeOperador = "Operador";
        FiltroRequestDTO filtroRequestDTO = new FiltroRequestDTO(dataInicio, dataFim, nomeOperador);

        String expected = "FiltroRequestDTO{" +
                "dataInicio='" + dataInicio + '\'' +
                ", dataFim='" + dataFim + '\'' +
                ", nomeOperador='" + nomeOperador + '\'' +
                '}';
        assertEquals(expected, filtroRequestDTO.toString());
    }
}
