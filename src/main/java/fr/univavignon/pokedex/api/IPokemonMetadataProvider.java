package fr.univavignon.pokedex.api;

/**
 * An IPokemonMetadataProvider aims to provide PokemonMetadata
 * for a given pokemon index.
 * 
 * @author fv
 */
public interface IPokemonMetadataProvider {

	
	PokemonMetadata getPokemonMetadata(int index) throws PokedexException;
	
}
