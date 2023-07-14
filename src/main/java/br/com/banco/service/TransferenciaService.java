package br.com.banco.service;


import br.com.banco.dto.FiltroRequestDTO;
import br.com.banco.dto.TransferenciaResponseDTO;
import br.com.banco.entities.Transferencia;
import br.com.banco.exceptions.InvalidDateException;
import br.com.banco.exceptions.NullFilterException;
import br.com.banco.exceptions.ObjectNotFoundException;
import br.com.banco.repositories.ContaRepository;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;
    private final ContaRepository contaRepository;

    @Autowired
    public TransferenciaService(TransferenciaRepository transferenciaRepository, ContaRepository contaRepository) {
        this.transferenciaRepository = transferenciaRepository;
        this.contaRepository = contaRepository;
    }

    public List<Transferencia> findAllByContaId(Integer contaId) {
        validateBankAccountExists(contaId);
        return transferenciaRepository.findAllByContaId(contaId);
    }

    public List<Transferencia> findAllFiltered(FiltroRequestDTO filtro) {
        validateFilterIsNotNull(filtro);
        validateStartDateAndEndDateWereInformed(filtro);

        List<Transferencia> obj;

        if (filtro.getDataInicio() != null && filtro.getDataFim() != null) {
            LocalDateTime dataInicio = DateUtils.strToLocalDateTime(filtro.getDataInicio());
            LocalDateTime dataFim = DateUtils.strToLocalDateTime(filtro.getDataFim());

            validateEndDateIsGreater(dataInicio, dataFim);

            obj = transferenciaRepository.findAllByDataTransferenciaBetween(dataInicio, dataFim);

            if (filtro.getNomeOperador() != null) {
                obj = filterByOperador(obj, filtro);
            }
        } else {
            obj = filterByOperador(transferenciaRepository.findAll(), filtro);
        }

        if (obj.isEmpty()) {
            throw new ObjectNotFoundException("Não foram encontradas transferências com os filtros informados");
        }

        return obj;
    }

    public List<Transferencia> filterByOperador(List<Transferencia> list, FiltroRequestDTO filtro) {
        List<Transferencia> res = new ArrayList<>();

        for (Transferencia transferencia : list) {
            if (Objects.equals(transferencia.getTipo(), "TRANSFERENCIA")) {
                if (transferencia.getValor() > 0 && Objects.equals(transferencia.getConta().getNomeResponsavel(), filtro.getNomeOperador())) {
                    res.add(transferencia);
                } else if (transferencia.getValor() < 0 && Objects.equals(transferencia.getOperadorTransacao(), filtro.getNomeOperador())) {
                    res.add(transferencia);
                }
            }
        }

        return res;
    }

    private void validateFilterIsNotNull(FiltroRequestDTO filtro) {
        if (filtro.getNomeOperador() == null && filtro.getDataInicio() == null && filtro.getDataFim() == null) {
            throw new NullFilterException("Não foram informados filtros");
        }
    }

    public void validateEndDateIsGreater(LocalDateTime startDate, LocalDateTime endDate) {
        if (endDate.isBefore(startDate)) {
            throw new InvalidDateException("A <dataInicio> informada é mais atual que a <dataFim>");
        }
    }

    public void validateStartDateAndEndDateWereInformed(FiltroRequestDTO filtro) {
        if ((filtro.getDataInicio() != null && filtro.getDataFim() == null) || (filtro.getDataFim() != null && filtro.getDataInicio() == null)) {
            throw new InvalidDateException("Ambos os campos <dataInicio> e <dataFim> devem ser informados");
        }
    }

    public void validateBankAccountExists(Integer contaId) {
        if (!contaRepository.existsById(contaId)) {
            throw new ObjectNotFoundException("O número da conta informada não está cadastrado");
        }
    }

    public List<TransferenciaResponseDTO> listToDto(List<Transferencia> list) {
        return list.stream()
                .map(x -> new TransferenciaResponseDTO(x.getId(), x.getDataTransferencia(), x.getValor(),
                        x.getTipo(), x.getOperadorTransacao(), x.getConta().toResponseDto()))
                .collect(Collectors.toList());
    }

    public List<Transferencia> findAll() {
        return transferenciaRepository.findAll();
    }
}
