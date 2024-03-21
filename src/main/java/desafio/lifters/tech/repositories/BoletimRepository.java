package desafio.lifters.tech.repositories;

import desafio.lifters.tech.entity.Boletim;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoletimRepository extends JpaRepository<Boletim, Long> {
}