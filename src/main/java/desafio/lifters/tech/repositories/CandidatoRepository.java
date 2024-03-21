package desafio.lifters.tech.repositories;

import desafio.lifters.tech.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    List<Candidato> findByNomeIgnoreCaseContainingOrderByNome(String nome);

}
