package br.com.banco.serviceTest;

import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.ContaRepository;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.service.TransferenciaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TransferenciaServiceTest {

    // Injeta uma instância da classe TransferenciaService para ser testada
    @InjectMocks
    private TransferenciaService transferenciaService;


    // Cria um mock do repositório de transferências
    @Mock
    private TransferenciaRepository transferenciaRepository;


    // Cria um mock do repositório de contas
    @Mock
    private ContaRepository contaRepository;


    // Inicializa os mocks antes de cada teste
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    // Teste do método findAllByContaId da classe TransferenciaService
    @Test
    public void testFindAllByContaId() {
        Integer contaId = 1;
        List<Transferencia> expected = new ArrayList<>();
        when(transferenciaRepository.findAllByContaId(contaId)).thenReturn(expected);

        List<Transferencia> actual = transferenciaService.findAllByContaId(contaId);
        assertEquals(expected, actual);
    }
}
