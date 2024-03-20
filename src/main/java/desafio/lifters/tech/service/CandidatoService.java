package desafio.lifters.tech.service;

import desafio.lifters.tech.entity.Candidato;
import desafio.lifters.tech.repositories.CandidatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoService {

    private final CandidatoRepository candidatoRepository;

    public CandidatoService(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

    public List<Candidato> listar() {
        return candidatoRepository.findAll();
    }

    public Candidato salva(Candidato candidato) {
        return candidatoRepository.save(candidato);
    }

    public Candidato consultarPorId(Long id) {
        return candidatoRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Candidato> consultaPorNome(String nome) {
        return candidatoRepository.findByNomeIgnoreCaseContainingOrderByNome(nome);
    }

    public Candidato altera(Candidato candidato) {
        return candidatoRepository.save(candidato);
    }

    public void deleteById(Long id) {
        candidatoRepository.deleteById(id);
    }

}
