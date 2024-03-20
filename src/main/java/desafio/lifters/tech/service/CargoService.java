package desafio.lifters.tech.service;

import desafio.lifters.tech.entity.Cargo;
import desafio.lifters.tech.repositories.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    private final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public List<Cargo> listar() {
        return cargoRepository.findAll();
    }

    public Cargo salva(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    public Cargo consultarPorId(Long id) {
        return cargoRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    

    public Cargo altera(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    public void deleteById(Long id) {
        cargoRepository.deleteById(id);
    }
}
