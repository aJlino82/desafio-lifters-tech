package desafio.lifters.tech.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Eleitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eleitorId;
    private String nome;
    @Column(unique = true)
    private String cpf;
    private Boolean votou;

    public Eleitor() {
    }

    public Eleitor(String nome, String cpf, Boolean votou) {
        this.nome = nome;
        this.cpf = cpf;
        this.votou = votou;
    }

    public Long getEleitorId() {
        return eleitorId;
    }

    public void setEleitorId(Long eleitorId) {
        this.eleitorId = eleitorId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getVotou() {
        return votou;
    }

    public void setVotou(Boolean votou) {
        this.votou = votou;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eleitor eleitor = (Eleitor) o;
        return Objects.equals(eleitorId, eleitor.eleitorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eleitorId);
    }

    @Override
    public String toString() {
        return "Eleitor{" +
                "candidatoId=" + eleitorId +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", votou=" + votou +
                '}';
    }
}
