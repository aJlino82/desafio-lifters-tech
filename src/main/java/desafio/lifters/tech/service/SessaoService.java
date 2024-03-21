package desafio.lifters.tech.service;

import desafio.lifters.tech.entity.SessaoVotacao;
import desafio.lifters.tech.repositories.SessaoVotacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class SessaoService {

    private final SessaoVotacaoRepository sessaoVotacaoRepository;

    public SessaoService(SessaoVotacaoRepository sessaoVotacaoRepository) {
        this.sessaoVotacaoRepository = sessaoVotacaoRepository;
    }

    public SessaoVotacao criaSessao(SessaoVotacao sessaoVotacao) {
        return sessaoVotacaoRepository.save(sessaoVotacao);
    }

    public SessaoVotacao abreSessao(SessaoVotacao sessaoVotacao) {
        sessaoVotacao.abrirSessao();
        return sessaoVotacao;
    }

    public SessaoVotacao fechaSessao(SessaoVotacao sessaoVotacao) {
        sessaoVotacao.encerrarSessao();
        return sessaoVotacao;
    }
}
