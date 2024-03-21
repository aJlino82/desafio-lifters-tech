package desafio.lifters.tech;

import desafio.lifters.tech.entity.*;
import desafio.lifters.tech.repositories.CandidatoRepository;
import desafio.lifters.tech.repositories.CargoRepository;
import desafio.lifters.tech.repositories.EleitorRepository;
import desafio.lifters.tech.service.BoletimService;
import desafio.lifters.tech.service.SessaoService;
import desafio.lifters.tech.service.VotoService;
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
    VotoService votoService;
    @Autowired
    BoletimService boletimService;
    @Autowired
    SessaoService sessaoService;

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

        SessaoVotacao sessaoVotacao = new SessaoVotacao(null, false);
        sessaoService.salva(sessaoVotacao);

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
        Candidato candidato = new Candidato(null, "Zé Colmeia", "333.333.333-33", 10, "c/votacao/fotos/zecolmeia.jpg", 0, presidente);
        candidatoRepository.save(candidato);
        Candidato candidato2 = new Candidato(null, "Catatau", "444.444.444-44", 20, "c/votacao/fotos/catatau.jpg", 0, presidente);
        candidatoRepository.save(candidato2);
        Candidato candidato3 = new Candidato(null, "Dom pixote", "555.555.555.55", 30, "c/votacao/fotos/dpixote.jpg", 0, senador);
        candidatoRepository.save(candidato3);

        //Mock voto
        Voto voto = new Voto(null, candidato, candidato.getCargo().getDescricao());
        votoService.votar(voto);
        Voto voto1 = new Voto(null, candidato, candidato.getCargo().getDescricao());
        votoService.votar(voto1);
        Voto voto2 = new Voto(null, candidato2, candidato2.getCargo().getDescricao());
        votoService.votar(voto2);
        Voto voto3 = new Voto(null, candidato3, candidato3.getCargo().getDescricao());
        votoService.votar(voto3);
        Voto voto4 = new Voto(null, candidato3, candidato3.getCargo().getDescricao());
        votoService.votar(voto4);

        Integer totaldeVotos = boletimService.totalVotos();
        Candidato vencedor = boletimService.buscaVencedor();


        System.out.println("");
        System.out.println("O total de votos para Presidente foi " + boletimService.toralVotosPorCargo(cargo.getDescricao()));
        System.out.println("");
        System.out.println("O total de votos para Senador foi " + boletimService.toralVotosPorCargo(cargo2.getDescricao()));


    }


}
