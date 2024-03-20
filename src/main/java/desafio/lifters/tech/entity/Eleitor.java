package desafio.lifters.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Eleitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidatoId;
    private String nome;
    private String cpf;
    private Boolean votou;

    public Eleitor() {
    }

    public Eleitor(String nome, String cpf, Boolean votou) {
        this.nome = nome;
        this.cpf = cpf;
        this.votou = votou;
    }

    public void votar(Candidato candidato) {
        //construir a classe candidato para receber no parametro...
        if (!votou) {
            votou = true;
        } else {
            System.out.println("O Eleitor " + nome + "já votou");
        }
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
        return Objects.equals(candidatoId, eleitor.candidatoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidatoId);
    }

    @Override
    public String toString() {
        return "Eleitor{" +
                "candidatoId=" + candidatoId +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", votou=" + votou +
                '}';
    }
}
