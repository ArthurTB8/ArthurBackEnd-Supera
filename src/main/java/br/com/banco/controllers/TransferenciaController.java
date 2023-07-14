package br.com.banco.controllers;
import br.com.banco.dto.FiltroRequestDTO;
import br.com.banco.dto.TransferenciaResponseDTO;
import br.com.banco.entities.Transferencia;
import br.com.banco.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    @Autowired
    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @GetMapping("/{contaId}")
    public ResponseEntity<List<TransferenciaResponseDTO>> findAllByContaId(@PathVariable Integer contaId) {
        List<Transferencia> transferencias = transferenciaService.findAllByContaId(contaId);
        List<TransferenciaResponseDTO> response = transferenciaService.listToDto(transferencias);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TransferenciaResponseDTO>> findAllFiltered(@Valid @RequestBody FiltroRequestDTO filtro) {
        List<Transferencia> transferencias = transferenciaService.findAllFiltered(filtro);
        List<TransferenciaResponseDTO> response = transferenciaService.listToDto(transferencias);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TransferenciaResponseDTO>> findAll() {
        List<Transferencia> transferencias = transferenciaService.findAll();
        List<TransferenciaResponseDTO> response = transferenciaService.listToDto(transferencias);

        return ResponseEntity.ok(response);
    }
}
