package desafio.lifters.tech.service;

import desafio.lifters.tech.entity.Eleitor;
import desafio.lifters.tech.entity.dto.EleitorDto;
import desafio.lifters.tech.repositories.EleitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EleitorService {

    private final EleitorRepository eleitorRepository;

    public EleitorService(EleitorRepository eleitorRepository) {
        this.eleitorRepository = eleitorRepository;
    }

    public List<Eleitor> listar() {
        return eleitorRepository.findAll();
    }

    public Eleitor cadastar(EleitorDto eleitorDto) {
        Eleitor eleitor = new Eleitor();
        eleitor.setNome(eleitorDto.getNome());
        eleitor.setCpf(eleitorDto.getCpf());
        eleitor.setVotou(eleitorDto.getVotou());
        return eleitorRepository.save(eleitor);
    }
}
