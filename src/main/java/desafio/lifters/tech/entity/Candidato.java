package desafio.lifters.tech.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidatoId;
    @Column(unique = true)
    private String cpf;
    private String nome;
    private Integer numero;
    private String caminhoFoto;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    @JsonBackReference
    private Cargo cargo;

    public String getCpf() {
        return cpf;
    }

    public Candidato() {
    }

    public Candidato(String nome, String cpf, Integer numero, String caminhoFoto, Cargo cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.numero = numero;
        this.caminhoFoto = caminhoFoto;
        this.cargo = cargo;
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
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
                ", cargo=" + cargo +
                '}';
    }
}
