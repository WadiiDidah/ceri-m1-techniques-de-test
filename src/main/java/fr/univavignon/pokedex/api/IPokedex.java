package fr.univavignon.pokedex.api;

import java.util.Comparator;
import java.util.List;

/**
 * IPokedex interface. An IPokedex aims to store all information about
 * captured pokemon, as their default metadata as well.
 * 
 * @author fv
 */
public interface IPokedex extends IPokemonMetadataProvider, IPokemonFactory {
	
	
	
	int addPokemon(Pokemon pokemon);
	
	
	
	Pokemon getPokemon(int id) throws PokedexException;
	
	
	List<Pokemon> getPokemons();

	
	List<Pokemon> getPokemons(Comparator<Pokemon> order);
	
}
