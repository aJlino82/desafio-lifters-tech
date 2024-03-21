package desafio.lifters.tech.controller;

import desafio.lifters.tech.entity.SessaoVotacao;
import desafio.lifters.tech.service.SessaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class SessaoController {

    private final SessaoService sessaoService;

    public SessaoController(SessaoService sessaoService) {
        this.sessaoService = sessaoService;
    }

    @PostMapping("/abrir-sessao")
    public ResponseEntity<SessaoVotacao> iniciarSessao(@RequestBody SessaoVotacao sessaoVotacao) {
        return ResponseEntity.ok(sessaoService.salva(sessaoVotacao));
    }

    @PatchMapping("/fechar-sessao")
    public ResponseEntity<SessaoVotacao> encerrarSessao(@RequestBody SessaoVotacao sessaoVotacao) {
        return ResponseEntity.ok(sessaoService.salva(sessaoVotacao));
    }
}
