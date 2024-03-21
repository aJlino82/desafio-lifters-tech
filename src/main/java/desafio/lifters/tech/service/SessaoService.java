package desafio.lifters.tech.service;

import desafio.lifters.tech.entity.SessaoVotacao;
import desafio.lifters.tech.repositories.SessaoVotacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessaoService {

    private final SessaoVotacaoRepository sessaoVotacaoRepository;

    public SessaoService(SessaoVotacaoRepository sessaoVotacaoRepository) {
        this.sessaoVotacaoRepository = sessaoVotacaoRepository;
    }

    public SessaoVotacao salva(SessaoVotacao sessaoVotacao) {
        sessaoVotacao.setSessaoId(1L);
        return sessaoVotacaoRepository.save(sessaoVotacao);
    }

    public List<SessaoVotacao> listaTodos() {
        return sessaoVotacaoRepository.findAll();
    }
}
