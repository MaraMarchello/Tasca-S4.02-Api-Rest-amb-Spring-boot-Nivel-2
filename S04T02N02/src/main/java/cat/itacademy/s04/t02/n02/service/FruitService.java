package cat.itacademy.s04.t02.n02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cat.itacademy.s04.t02.n02.model.Fruit;
import cat.itacademy.s04.t02.n02.repository.FruitRepository;
import cat.itacademy.s04.t02.n02.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    @Autowired
    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    public Fruit getFruitById(Long id) {
        return fruitRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Fruit not found with id: " + id));
    }

    public Fruit createFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    public Fruit updateFruit(Long id, Fruit fruitDetails) {
        Fruit fruit = getFruitById(id);
        fruit.setName(fruitDetails.getName());
        fruit.setQuantityKilos(fruitDetails.getQuantityKilos());
        return fruitRepository.save(fruit);
    }

    public void deleteFruit(Long id) {
        Fruit fruit = getFruitById(id);
        fruitRepository.delete(fruit);
    }
} 