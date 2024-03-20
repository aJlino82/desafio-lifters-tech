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

    public Eleitor salva(EleitorDto eleitorDto) {
        Eleitor eleitor = new Eleitor();
        eleitor.setNome(eleitorDto.getNome());
        eleitor.setCpf(eleitorDto.getCpf());
        eleitor.setVotou(eleitorDto.getVotou());
        return eleitorRepository.save(eleitor);
    }

    public Eleitor consultarPorId(Long id) {
        return eleitorRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Eleitor> consultaPorNome(String nome) {
        return eleitorRepository.findByNomeIgnoreCaseContainingOrderByNome(nome);
    }

    public Eleitor altera(EleitorDto eleitorDto, Long id) {
        Eleitor eleitorEncontrado = eleitorRepository.findById(id).orElseThrow(() -> new RuntimeException("Eleitor inválido"));
        eleitorEncontrado.setNome(eleitorDto.getNome());
        eleitorEncontrado.setCpf(eleitorDto.getCpf());
        eleitorEncontrado.setVotou(eleitorDto.getVotou());
        return eleitorRepository.save(eleitorEncontrado);
    }

    public void deleteById(Long id) {
        eleitorRepository.deleteById(id);
    }
}
