package desafio.lifters.tech.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long votoId;
    private String cargo;
    @ManyToOne
    @JoinColumn(name = "candidato_id")
    private Candidato candidato;

    public Voto() {
    }

    public Voto(Long votoId, Candidato candidato, String cargo) {
        this.votoId = votoId;
        this.candidato = candidato;
        this.cargo = cargo;
    }

    public Long getVotoId() {
        return votoId;
    }

    public void setVotoId(Long votoId) {
        this.votoId = votoId;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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
                ", candidato=" + candidato +
                ", cargo=" + cargo +
                '}';
    }
}
