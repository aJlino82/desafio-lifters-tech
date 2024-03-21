package desafio.lifters.tech.controller;

import desafio.lifters.tech.entity.Boletim;
import desafio.lifters.tech.entity.Candidato;
import desafio.lifters.tech.entity.Voto;
import desafio.lifters.tech.service.BoletimService;
import desafio.lifters.tech.service.CandidatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boletim")
public class BoletimController {

    private final BoletimService boletimService;
    private final CandidatoService candidatoService;

    public BoletimController(BoletimService boletimService, CandidatoService candidatoService) {
        this.boletimService = boletimService;
        this.candidatoService = candidatoService;
    }

    @PostMapping("/boletim-urna")
    public Boletim emite(@RequestBody Boletim boletim) {
        Integer totaldeVotos = boletimService.totalVotos();
        Candidato vencedor = boletimService.buscaVencedor();

        boletim.setCargo(vencedor.getCargo().getDescricao());
        boletim.setTotalVotos(totaldeVotos);
        boletim.setVencedor(vencedor.getNome());
        System.out.println(boletim);

        return ResponseEntity.ok(boletimService.salva(boletim)).getBody();
    }

    @GetMapping("/candidato/{id}")
    public ResponseEntity<List<Voto>> listaPorcandidato(@PathVariable("id") Long id) {
        Candidato candidato = candidatoService.consultarPorId(id);
        System.out.println(candidato);
        return ResponseEntity.ok(boletimService.buscaVotoPorCandidato(candidato));
    }

    @GetMapping("/cargo/{cargo}")
    public ResponseEntity<List<Voto>> listaPorCargo(@PathVariable("cargo") String cargo) {
        return ResponseEntity.ok(boletimService.findByCargo(cargo));
    }

    @GetMapping("/total")
    public ResponseEntity<String> listaTotal() {
        return ResponseEntity.ok("O total de votos foi " + boletimService.totalVotos());
    }
}
