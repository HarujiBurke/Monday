
package cln.ecrimson.zato.components.pokemon.repo;

import cln.ecrimson.zato.components.pokemon.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepo extends JpaRepository<Pokemon, Long> {


    @Query("select case when count(c)> 0 then true else false end from Pokemon c where c.name = :name")
    boolean existsCarExactCustomQuery(@Param("name") String name);

    @Query(value = "select p.* from pokemon p where p.name like ?1",nativeQuery = true)
    List<Pokemon> findAllByName(String searchString);

    @Query(nativeQuery = true, value = "SET search_path TO :schema")
    List<Object> setSchema(@Param("schema") String schema);
    @Query(value = "select p.* from pokemon p where p.name like ?1",nativeQuery = true)
    List<Pokemon> findAllByNameContaining(String searchString);
    @Query(nativeQuery = true, value = "SET search_path TO public")
    void resetSchema();
}
