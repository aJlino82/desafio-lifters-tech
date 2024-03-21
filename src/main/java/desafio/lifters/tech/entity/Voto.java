package desafio.lifters.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Objects;

@Entity
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long votoId;
    @CreationTimestamp
    private Instant diaHoraVoto;
    private Integer numeroCandidato;
    private String cargoCandidato;

    public Voto() {
    }

    public Voto(Long votoId, Instant diaHoraVoto, Integer numeroCandidato, String cargoCandidato) {
        this.votoId = votoId;
        this.diaHoraVoto = diaHoraVoto;
        this.numeroCandidato = numeroCandidato;
        this.cargoCandidato = cargoCandidato;
    }

    public Long getVotoId() {
        return votoId;
    }

    public void setVotoId(Long votoId) {
        this.votoId = votoId;
    }

    public Instant getDiaHoraVoto() {
        return diaHoraVoto;
    }

    public void setDiaHoraVoto(Instant diaHoraVoto) {
        this.diaHoraVoto = diaHoraVoto;
    }

    public Integer getNumeroCandidato() {
        return numeroCandidato;
    }

    public void setNumeroCandidato(Integer numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
    }

    public String getCargoCandidato() {
        return cargoCandidato;
    }

    public void setCargoCandidato(String cargoCandidato) {
        this.cargoCandidato = cargoCandidato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voto voto = (Voto) o;
        return Objects.equals(votoId, voto.votoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(votoId);
    }

    @Override
    public String toString() {
        return "Voto{" +
                "votoId=" + votoId +
                ", diaHoraVoto=" + diaHoraVoto +
                ", numeroCandidato=" + numeroCandidato +
                ", cargoCandidato='" + cargoCandidato + '\'' +
                '}';
    }
}
