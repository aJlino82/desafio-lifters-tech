package desafio.lifters.tech.controller;

import desafio.lifters.tech.entity.Candidato;
import desafio.lifters.tech.service.CandidatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

    private final CandidatoService candidatoService;

    public CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }

    @PostMapping
    public ResponseEntity<Candidato> cadastrar(@RequestBody Candidato candidato) {
        return ResponseEntity.status(HttpStatus.CREATED).body(candidatoService.salva(candidato));
    }

    @GetMapping
    public List<Candidato> listarTodos() {
        List<Candidato> candidatos = candidatoService.listar();
        return ResponseEntity.ok(candidatos).getBody();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidato> consultarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(candidatoService.consultarPorId(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Candidato> alterar(@PathVariable("id") Long id, @RequestBody Candidato candidato) {
        candidato.setCandidatoId(id);
        Candidato candidatoatualizado = candidatoService.altera(candidato);
        return ResponseEntity.ok(candidatoatualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable("id") Long id) {
        candidatoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
