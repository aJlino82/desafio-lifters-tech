package desafio.lifters.tech;

import desafio.lifters.tech.entity.*;
import desafio.lifters.tech.repositories.CandidatoRepository;
import desafio.lifters.tech.repositories.CargoRepository;
import desafio.lifters.tech.repositories.EleitorRepository;
import desafio.lifters.tech.repositories.VotoRepository;
import desafio.lifters.tech.service.BoletimService;
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
    @Autowired
    BoletimService boletimService;

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
        Eleitor eleitor2 = new Eleitor("Maria", "111.111.222-22", false);
        eleitorRepository.save(eleitor2);
        Eleitor eleitor3 = new Eleitor("José", "123.123.123-12", false);
        eleitorRepository.save(eleitor3);
        Eleitor eleitor4 = new Eleitor("Mário", "321.321.321-32", true);
        eleitorRepository.save(eleitor4);

        //Mock candidato
        Candidato candidato = new Candidato("Zé Colmeia", "333.333.333-33", 20, "c/votacao/fotos/zecolmeia.jpg", presidente);
        candidatoRepository.save(candidato);
        Candidato candidato2 = new Candidato("Catatau", "444.444.444-44", 10, "c/votacao/fotos/catatau.jpg", presidente);
        candidatoRepository.save(candidato2);
        Candidato candidato3 = new Candidato("Dom pixote", "555.555.555.55", 30, "c/votacao/fotos/dpixote.jpg", senador);
        candidatoRepository.save(candidato3);

        //Mock voto
        Voto voto = new Voto(null, null, candidato, candidato.getCargo().getDescricao());
        votoRepository.save(voto);
        Voto voto1 = new Voto(null, null, candidato, candidato.getCargo().getDescricao());
        votoRepository.save(voto1);
        Voto voto2 = new Voto(null, null, candidato2, candidato2.getCargo().getDescricao());
        votoRepository.save(voto2);
        Voto voto3 = new Voto(null, null, candidato3, candidato3.getCargo().getDescricao());
        votoRepository.save(voto3);
        Voto voto4 = new Voto(null, null, candidato3, candidato3.getCargo().getDescricao());
        votoRepository.save(voto4);

        Integer totaldeVotos = boletimService.totalVotos();
        Candidato vencedor = boletimService.buscaVencedor();


        Boletim boletim = new Boletim(null, null, "Presidente", totaldeVotos, vencedor.getNome());
        boletimService.salva(boletim);

        System.out.println("");
        System.out.println("O total de votos para Presidente foi " + boletimService.toralVotosPorCargo(cargo.getDescricao()));
        System.out.println("");
        System.out.println("O total de votos para Senador foi " + boletimService.toralVotosPorCargo(cargo2.getDescricao()));


    }


}
