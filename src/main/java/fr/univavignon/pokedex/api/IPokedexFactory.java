package fr.univavignon.pokedex.api;

/**
 * Factory interface for class that aims to create IPokedex instance.
 * 
 * @author fv
 */
public interface IPokedexFactory {

	
	IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory);
	
}
