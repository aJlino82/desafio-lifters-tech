package desafio.lifters.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class SessaoVotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sessaoId;
    private Boolean sessaoAberta;

    public SessaoVotacao() {
    }

    public SessaoVotacao(Long sessaoId, Boolean sessaoAberta) {
        this.sessaoId = sessaoId;
        this.sessaoAberta = sessaoAberta;
    }

    public void abrirSessao() {
        this.sessaoAberta = true;
    }

    public void encerrarSessao() {
        this.sessaoAberta = false;
    }

    public Long getSessaoId() {
        return sessaoId;
    }

    public void setSessaoId(Long sessaoId) {
        this.sessaoId = sessaoId;
    }

    public Boolean getSessaoAberta() {
        return sessaoAberta;
    }

    public void setSessaoAberta(Boolean sessaoAberta) {
        this.sessaoAberta = sessaoAberta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessaoVotacao that = (SessaoVotacao) o;
        return Objects.equals(sessaoId, that.sessaoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessaoId);
    }

    @Override
    public String toString() {
        return "SessaoVotacao{" +
                "sessaoId=" + sessaoId +
                ", sessaoAberta=" + sessaoAberta +
                '}';
    }
}
