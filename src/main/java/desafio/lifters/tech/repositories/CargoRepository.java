package desafio.lifters.tech.repositories;

import desafio.lifters.tech.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}