package desafio.lifters.tech.repositories;

import desafio.lifters.tech.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {
}