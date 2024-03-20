package desafio.lifters.tech.controller;

import desafio.lifters.tech.entity.Cargo;
import desafio.lifters.tech.service.CargoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    private final CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @PostMapping
    public ResponseEntity<Cargo> cadastrar(@RequestBody Cargo cargo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoService.salva(cargo));
    }

    @GetMapping
    public List<Cargo> listarTodos() {
        List<Cargo> cargos = cargoService.listar();
        return ResponseEntity.ok(cargos).getBody();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> consultarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(cargoService.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable("id") Long id) {
        cargoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
