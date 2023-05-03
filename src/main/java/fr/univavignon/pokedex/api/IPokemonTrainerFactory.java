package fr.univavignon.pokedex.api;

/**
 * Factory interface for class that aims to create PokemonTrainer instance.
 * 
 * @author fv
 */
public interface IPokemonTrainerFactory {

	
	PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory);
	
}
