package desafio.lifters.tech.controller;

import desafio.lifters.tech.entity.Eleitor;
import desafio.lifters.tech.entity.dto.EleitorDto;
import desafio.lifters.tech.service.EleitorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eleitores")
public class EleitorController {

    private final EleitorService eleitorService;

    public EleitorController(EleitorService eleitorService) {
        this.eleitorService = eleitorService;
    }

    @PostMapping
    public ResponseEntity<Eleitor> cadastrar(@RequestBody EleitorDto eleitorDto) {
        Eleitor eleitor = eleitorService.cadastar(eleitorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(eleitor);
    }

    @GetMapping
    public List<Eleitor> listaTodos() {
        List<Eleitor> eleitores = eleitorService.listar();
        return ResponseEntity.ok(eleitores).getBody();
    }

}
