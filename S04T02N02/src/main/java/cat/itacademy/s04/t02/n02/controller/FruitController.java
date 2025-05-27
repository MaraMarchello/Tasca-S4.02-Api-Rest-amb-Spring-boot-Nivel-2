package cat.itacademy.s04.t02.n02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cat.itacademy.s04.t02.n02.model.Fruit;
import cat.itacademy.s04.t02.n02.service.FruitService;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    private final FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAll() {
        List<Fruit> fruits = fruitService.getAllFruits();
        return ResponseEntity.ok(fruits);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getOne(@PathVariable Long id) {
        Fruit fruit = fruitService.getFruitById(id);
        return ResponseEntity.ok(fruit);
    }

    @PostMapping("/add")
    public ResponseEntity<Fruit> add(@Valid @RequestBody Fruit fruit) {
        Fruit createdFruit = fruitService.createFruit(fruit);
        return ResponseEntity.ok(createdFruit);
    }

    @PutMapping("/update")
    public ResponseEntity<Fruit> update(@Valid @RequestBody Fruit fruit) {
        if (fruit.getId() == null) {
            throw new IllegalArgumentException("Fruit ID must be provided for update");
        }
        Fruit updatedFruit = fruitService.updateFruit(fruit.getId(), fruit);
        return ResponseEntity.ok(updatedFruit);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fruitService.deleteFruit(id);
        return ResponseEntity.noContent().build();
    }
} 