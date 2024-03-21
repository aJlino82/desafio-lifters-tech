package desafio.lifters.tech;

import desafio.lifters.tech.entity.Candidato;
import desafio.lifters.tech.entity.Cargo;
import desafio.lifters.tech.entity.Eleitor;
import desafio.lifters.tech.entity.Voto;
import desafio.lifters.tech.repositories.CandidatoRepository;
import desafio.lifters.tech.repositories.CargoRepository;
import desafio.lifters.tech.repositories.EleitorRepository;
import desafio.lifters.tech.repositories.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiftersApplication implements CommandLineRunner {
    @Autowired
    EleitorRepository eleitorRepository;
    @Autowired
    CargoRepository cargoRepository;
    @Autowired
    CandidatoRepository candidatoRepository;
    @Autowired
    VotoRepository votoRepository;

    public static void main(String[] args) {
        SpringApplication.run(LiftersApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //mock cargo
        Cargo cargo = new Cargo(1L, "Presidente");
        cargoRepository.save(cargo);
        Cargo cargo2 = new Cargo(2L, "Senador");
        cargoRepository.save(cargo2);

        Cargo presidente = cargoRepository.findById(1L).orElseThrow(() -> new RuntimeException("Cargo não encontrado"));
        Cargo senador = cargoRepository.findById(2L).orElseThrow(() -> new RuntimeException("Cargo não encontrado"));

        //mock eleitor
        Eleitor eleitor = new Eleitor("João", "000.000.000-00", false);
        eleitorRepository.save(eleitor);
        Eleitor eleitor2 = new Eleitor("Maria", "111.222.333-44", true);
        eleitorRepository.save(eleitor2);

        //Mock candidato
        Candidato candidato = new Candidato("Zé Colmeia", 20, "c/fotos/zecolmeia.jpg", presidente);
        candidatoRepository.save(candidato);
        Candidato candidato2 = new Candidato("Catatau", 10, "c/fotos/catatau.jpg", presidente);
        candidatoRepository.save(candidato2);
        Candidato candidato3 = new Candidato("Guarda Smith", 30, "c/fotos/smith.jpg", senador);
        candidatoRepository.save(candidato3);

        //Mock voto
        Voto voto = new Voto(null, null, candidato.getNumero(), candidato.getCargo().getDescricao());
        votoRepository.save(voto);
        Voto voto1 = new Voto(null, null, candidato.getNumero(), candidato.getCargo().getDescricao());
        votoRepository.save(voto1);
        Voto voto2 = new Voto(null, null, candidato2.getNumero(), candidato2.getCargo().getDescricao());
        votoRepository.save(voto2);
        Voto voto3 = new Voto(null, null, candidato3.getNumero(), candidato3.getCargo().getDescricao());
        votoRepository.save(voto3);


    }
}
