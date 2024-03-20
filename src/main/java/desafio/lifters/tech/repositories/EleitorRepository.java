package desafio.lifters.tech.repositories;

import desafio.lifters.tech.entity.Eleitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EleitorRepository extends JpaRepository<Eleitor, Long> {

    public List<Eleitor> findByNomeIgnoreCaseContainingOrderByNome(String nome);
}