package desafio.lifters.tech.service;

import desafio.lifters.tech.entity.Voto;
import desafio.lifters.tech.repositories.VotoRepository;
import org.springframework.stereotype.Service;

@Service
public class VotoService {

    private final VotoRepository votoRepository;

    public VotoService(VotoRepository votoRepository) {
        this.votoRepository = votoRepository;
    }

    public Voto votar(Voto voto) {
        return votoRepository.save(voto);
    }

}
