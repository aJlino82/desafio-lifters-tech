package desafio.lifters.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.Objects;

@Entity
public class Boletim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boletimId;
    @CreationTimestamp
    private Date dataRelatorio;
    private String cargo;
    private Integer totalVotos;
    private String vencedor;

    public Boletim() {
    }

    public Boletim(Long boletimId, Date dataRelatorio, String cargo, Integer totalVotos, String vencedor) {
        this.boletimId = boletimId;
        this.dataRelatorio = dataRelatorio;
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

    public Date getDataRelatorio() {
        return dataRelatorio;
    }

    public void setDataRelatorio(Date dataRelatorio) {
        this.dataRelatorio = dataRelatorio;
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
        vencedor = vencedor;
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
                ", dataRelatorio=" + dataRelatorio +
                ", cargo='" + cargo + '\'' +
                ", totalVotos=" + totalVotos +
                ", vencedor='" + vencedor + '\'' +
                '}';
    }
}
