package desafio.lifters.tech.service;

import desafio.lifters.tech.entity.Boletim;
import desafio.lifters.tech.entity.Candidato;
import desafio.lifters.tech.entity.Voto;
import desafio.lifters.tech.repositories.BoletimRepository;
import desafio.lifters.tech.repositories.VotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletimService {
    private final BoletimRepository boletimRepository;

    private final VotoRepository votoRepository;

    public BoletimService(BoletimRepository boletimRepository, VotoRepository votoRepository) {
        this.boletimRepository = boletimRepository;
        this.votoRepository = votoRepository;
    }

    public Boletim salva(Boletim boletim) {
        return boletimRepository.save(boletim);
    }

    public List<Voto> buscaVotoPorCandidato(Candidato candidato) {
        return votoRepository.findByCandidato(candidato);
    }

    public List<Voto> findByCargo(String cargo) {
        return votoRepository.findByCargoContainingIgnoreCase(cargo);
    }

    public Integer totalVotos() {
        Integer total = votoRepository.findAll().size();
        return total;
    }

    public Integer toralVotosPorCargo(String cargo) {
        Integer total = votoRepository.totalVotosPorCargo(cargo);
        return total;
    }


    public Candidato buscaVencedor() {
        List<Candidato> candidatos = votoRepository.encontrarCandidatoComMaisVotos();
        Candidato vencedor = candidatos.get(0);
        return vencedor;
    }

}
