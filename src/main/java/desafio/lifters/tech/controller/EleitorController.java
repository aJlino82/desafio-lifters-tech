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
        Eleitor eleitor = eleitorService.salva(eleitorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(eleitor);
    }

    @GetMapping
    public List<Eleitor> listarTodos() {
        List<Eleitor> eleitores = eleitorService.listar();
        return ResponseEntity.ok(eleitores).getBody();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Eleitor> consultarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(eleitorService.consultarPorId(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Eleitor> alterar(@PathVariable("id") Long id, @RequestBody EleitorDto eleitorDto) {
        Eleitor eleitorAtualizado = eleitorService.altera(eleitorDto, id);
        return ResponseEntity.ok(eleitorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable("id") Long id) {
        eleitorService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Eleitor>> consultaPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(eleitorService.consultaPorNome(nome));
    }
}
