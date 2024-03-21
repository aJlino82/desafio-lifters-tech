package desafio.lifters.tech.controller;

import desafio.lifters.tech.entity.Candidato;
import desafio.lifters.tech.entity.Voto;
import desafio.lifters.tech.service.BoletimService;
import desafio.lifters.tech.service.CandidatoService;
import desafio.lifters.tech.service.VotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

    private final CandidatoService candidatoService;
    private final BoletimService boletimService;
    private final VotoService votoService;

    public CandidatoController(CandidatoService candidatoService, BoletimService boletimService, VotoService votoService) {
        this.candidatoService = candidatoService;
        this.boletimService = boletimService;
        this.votoService = votoService;
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

    @GetMapping("/total/{id}")
    public ResponseEntity<Integer> buscaVotosPorCandidatoId(@PathVariable("id") Long id) {
        Candidato candidato = candidatoService.consultarPorId(id);
        List<Voto> votosList = boletimService.buscaVotoPorCandidato(candidato);
        Integer totalVotosPorCandidato = votosList.size();
        return ResponseEntity.ok(totalVotosPorCandidato);
    }

    @PatchMapping("/total/{id}")
    public ResponseEntity<Integer> totalVotosPorCandidato(@PathVariable("id") Long id) {
        Candidato candidato = candidatoService.consultarPorId(id);
        return ResponseEntity.ok(votoService.totalVotosPorCandidato(candidato));
    }

}
