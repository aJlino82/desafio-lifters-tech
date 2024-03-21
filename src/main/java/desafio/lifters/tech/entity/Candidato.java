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
    @Column(unique = true)
    private Integer numero;
    private String caminhoFoto;
    private Integer totalDeVotos;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    @JsonBackReference
    private Cargo cargo;

    public Candidato() {
    }

    public Candidato(Long candidatoId, String nome, String cpf, Integer numero, String caminhoFoto, Integer totalDeVotos, Cargo cargo) {
        this.candidatoId = candidatoId;
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
        this.caminhoFoto = caminhoFoto;
        this.totalDeVotos = totalDeVotos;
        this.cargo = cargo;
    }

    public Long getCandidatoId() {
        return candidatoId;
    }

    public void setCandidatoId(Long candidatoId) {
        this.candidatoId = candidatoId;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public Integer getTotalDeVotos() {
        return totalDeVotos;
    }

    public void setTotalDeVotos(Integer totalDeVotos) {
        this.totalDeVotos = totalDeVotos;
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
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", numero=" + numero +
                ", caminhoFoto='" + caminhoFoto + '\'' +
                ", totalDeVotos=" + totalDeVotos +
                ", cargo=" + cargo +
                '}';
    }
}
