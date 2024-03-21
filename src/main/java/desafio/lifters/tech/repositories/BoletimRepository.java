package desafio.lifters.tech.repositories;

import desafio.lifters.tech.entity.Boletim;
import desafio.lifters.tech.entity.Voto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;



public interface BoletimRepository extends JpaRepository<Boletim, Long> {
}