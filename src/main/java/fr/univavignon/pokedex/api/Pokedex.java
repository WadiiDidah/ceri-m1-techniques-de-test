package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {
	private final List<Pokemon> pokemons;
	IPokemonMetadataProvider pokemonmetadataProvider;
	IPokemonFactory pokemonFactory;

	public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
		this.pokemonmetadataProvider = metadataProvider;
		this.pokemonFactory = pokemonFactory;
		pokemons = new ArrayList<>();
	}

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {

		// TODO Auto-generated method stub
		return pokemonmetadataProvider.getPokemonMetadata(index);
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		// TODO Auto-generated method stub
		return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
	}

	@Override
	public int size() {
		
		return this.pokemons.size();
	}

	@Override
	public int addPokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub
		 this.pokemons.add(pokemon);
		return pokemons.size();
	}

	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		if (id < 0 || id >= this.pokemons.size()) {
            throw new PokedexException("index est invalide: " + id);
        }
        return this.pokemons.get(id);
	}

	@Override
	public List<Pokemon> getPokemons() {
		// TODO Auto-generated method stub
		
		 return Collections.unmodifiableList(this.pokemons);
	}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		 List<Pokemon> pokemonstrie = new ArrayList<>(this.pokemons);
	     Collections.sort(pokemonstrie, order);
	     return Collections.unmodifiableList(pokemonstrie);
	}

}
