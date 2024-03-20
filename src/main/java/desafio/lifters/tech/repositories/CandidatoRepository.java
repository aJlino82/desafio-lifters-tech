package desafio.lifters.tech.repositories;

import desafio.lifters.tech.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    public List<Candidato> findByNomeIgnoreCaseContainingOrderByNome(String nome);
}
