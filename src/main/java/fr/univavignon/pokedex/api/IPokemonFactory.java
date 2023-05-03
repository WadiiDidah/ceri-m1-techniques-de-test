package fr.univavignon.pokedex.api;

/**
 * Factory interface for class that aims to create Pokemon instance.
 * 
 * @author fv
 */
public interface IPokemonFactory {

	
	Pokemon createPokemon(int index, int cp, int hp, int dust, int candy);
	
}
