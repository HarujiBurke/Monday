package cln.ecrimson.zato.controller.pokemon;

import cln.ecrimson.zato.components.pokemon.entity.Pokemon;
import cln.ecrimson.zato.components.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pokemons")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public List<Pokemon> getAllPokemons(@RequestParam(required = false, defaultValue = "0") int start,
                                        @RequestParam(required = false, defaultValue = "10") int size) {
        return pokemonService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable Long id) {
        Optional<Pokemon> pokemon = pokemonService.getById(id);
        return pokemon.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> savePokemon(@RequestBody List<Pokemon> pokemons) {
        String result = pokemonService.saveAll(pokemons);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePokemon(@PathVariable Long id) {
        boolean result = pokemonService.delete(id);
        return ResponseEntity.ok("");
    }
}
