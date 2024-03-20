package desafio.lifters.tech.repositories;

import desafio.lifters.tech.entity.Eleitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EleitorRepository extends JpaRepository<Eleitor, Long> {
}