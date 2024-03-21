package desafio.lifters.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
public class Boletim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boletinId;
    @CreationTimestamp
    private Date dataRelatorio;
    private String cargo;
    private Integer totalVotos;
    private String Vencedor;
}
