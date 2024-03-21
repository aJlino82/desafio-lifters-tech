package desafio.lifters.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Boletim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boletimId;
    private String cargo;
    private Integer totalVotos;
    private String vencedor;

    public Boletim() {
    }

    public Boletim(Long boletimId, String cargo, Integer totalVotos, String vencedor) {
        this.boletimId = boletimId;
        this.cargo = cargo;
        this.totalVotos = totalVotos;
        this.vencedor = vencedor;
    }

    public Long getBoletimId() {
        return boletimId;
    }

    public void setBoletimId(Long boletimId) {
        this.boletimId = boletimId;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(Integer totalVotos) {
        this.totalVotos = totalVotos;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boletim boletim = (Boletim) o;
        return Objects.equals(boletimId, boletim.boletimId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boletimId);
    }

    @Override
    public String toString() {
        return "Boletim{" +
                "boletimId=" + boletimId +
                ", cargo='" + cargo + '\'' +
                ", totalVotos=" + totalVotos +
                ", vencedor='" + vencedor + '\'' +
                '}';
    }
}
