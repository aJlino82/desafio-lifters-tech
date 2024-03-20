package desafio.lifters.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidatoId;
    private String nome;
    private Integer numero;
    private String caminhoFoto;

    public Candidato() {
    }

    public Candidato(String nome, Integer numero, String caminhoFoto) {
        this.nome = nome;
        this.numero = numero;
        this.caminhoFoto = caminhoFoto;
    }

    public Long getCandidatoId() {
        return candidatoId;
    }

    public void setCandidatoId(Long candidatoId) {
        this.candidatoId = candidatoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidato candidato = (Candidato) o;
        return Objects.equals(candidatoId, candidato.candidatoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidatoId);
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "candidatoId=" + candidatoId +
                ", nome='" + nome + '\'' +
                ", numero=" + numero +
                ", caminhoFoto='" + caminhoFoto + '\'' +
                '}';
    }
}
