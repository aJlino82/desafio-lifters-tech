package desafio.lifters.tech.repositories;

import desafio.lifters.tech.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}
