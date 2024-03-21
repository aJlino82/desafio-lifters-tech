package desafio.lifters.tech.controller;

import desafio.lifters.tech.entity.SessaoVotacao;
import desafio.lifters.tech.service.SessaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SessaoController {

    private final SessaoService sessaoService;

    public SessaoController(SessaoService sessaoService) {
        this.sessaoService = sessaoService;
    }

    @PostMapping("/abrir-sessao")
    public ResponseEntity<SessaoVotacao> iniciarSessao(SessaoVotacao sessaoVotacao) {
        sessaoVotacao.abrirSessao();
        sessaoService.abreSessao(sessaoVotacao);
        return ResponseEntity.ok(sessaoVotacao);
    }

    @PostMapping("/fechar-sessao")
    public ResponseEntity<SessaoVotacao> encerrarSessao(SessaoVotacao sessaoVotacao) {
        sessaoVotacao.encerrarSessao();
        sessaoService.fechaSessao(sessaoVotacao);
        return ResponseEntity.ok(sessaoVotacao);
    }
}
