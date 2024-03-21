package desafio.lifters.tech.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cargoId;
    private String descricao;
    @OneToMany(mappedBy = "cargo")
    @JsonIgnore
    private Set<Candidato> candidatos = new HashSet<>();

    public Cargo() {
    }

    public Cargo(Long cargoId, String descricao) {
        this.cargoId = cargoId;
        this.descricao = descricao;
    }

    public Long getCargoId() {
        return cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(Set<Candidato> candidatos) {
        this.candidatos = candidatos;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return Objects.equals(cargoId, cargo.cargoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargoId);
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + cargoId +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
