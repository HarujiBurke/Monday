package cln.ecrimson.zato.components.pokemon.service;

import cln.ecrimson.zato.components.pokemon.entity.Pokemon;
import cln.ecrimson.zato.components.pokemon.repo.PokemonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    PokemonRepo pokemonRepo;

    @Override
    public List<Pokemon> getAll() {
        return pokemonRepo.findAll();
    }

    @Override
    public String saveAll(List<Pokemon> pokemons) {
        AtomicLong result = new AtomicLong();
        pokemons.forEach(pokemon->{
            if (save(pokemon)){
                result.getAndIncrement();
            }
        });
        return result+"";
    }

    @Override
    public boolean save(Pokemon pokemon) {
        try{
            Optional<Pokemon> newOne = Optional.of(pokemonRepo.save(pokemon));
            return newOne.isPresent();
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public Optional<Pokemon> getById(Long id) {
        return pokemonRepo.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        try{
            pokemonRepo.deleteById(id);
            return true;
        }catch (Exception ex){
            return false;
        }

    }
}
