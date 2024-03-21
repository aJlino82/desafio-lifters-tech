package desafio.lifters.tech.repositories;

import desafio.lifters.tech.entity.Candidato;
import desafio.lifters.tech.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VotoRepository extends JpaRepository<Voto, Long> {
    List<Voto> findByCandidato(Candidato candidato);

    List<Voto> findByCargoContainingIgnoreCase(String cargo);

    @Query("SELECT COUNT(*) FROM Voto v WHERE v.cargo = ?1")
    int totalVotosPorCargo(String cargo);

    @Query("SELECT COUNT(*) FROM Voto v WHERE v.candidato = ?1")
    int totalVotosPorCandidato(Candidato candidato);

    @Query("SELECT v.candidato FROM Voto v GROUP BY v.candidato ORDER BY COUNT(*) DESC")
    List<Candidato> encontrarCandidatoComMaisVotos();


}