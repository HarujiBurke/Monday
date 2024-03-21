package cln.ecrimson.zato.components.pokemon.service;



import cln.ecrimson.zato.components.pokemon.entity.Pokemon;

import java.util.List;
import java.util.Optional;

public interface PokemonService {

    List<Pokemon> getAll();
    String saveAll(List<Pokemon> pokemon);
    boolean save(Pokemon pokemon);

    Optional<Pokemon> getById(Long id);

    boolean delete(Long id);
}