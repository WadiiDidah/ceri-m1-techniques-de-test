package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class IPokedexTest {

	@Mock
	private IPokedex pokedex;

	private List<Pokemon> pokemons;
	Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56); // 10
	Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2792, 202, 5000, 4, 100); // 6
	Pokemon pokemon3 = new Pokemon(120, "POK3", 186, 168, 260,100, 202, 5000, 4, 100); // 4
	Pokemon pokemon4 = new Pokemon(1, "POKEMON4", 186, 168, 260,300, 202, 5000, 4, 100); // 8

	@Before
	public void initialiser() throws PokedexException {
		MockitoAnnotations.initMocks(this);
		pokemons = pokedex.getPokemons();

	}

	@Test
	public void Test_size() {
		assertEquals(0, pokedex.size());
		pokedex.addPokemon(pokemon1);
		when(pokedex.size()).thenReturn(1);
		assertEquals(1, pokedex.size());

	}

	@Test
	public void Test_add() {
		
		when(pokedex.addPokemon(pokemon2)).thenReturn(133);
		assertEquals(133, pokedex.addPokemon(pokemon2));

	}

	@Test
	public void Test_getPokemon() throws PokedexException {
		
		 when(pokedex.getPokemon(anyInt())).thenAnswer(input -> {
				int index = input.getArgument(0);
				if (index < 0 || index > 150) {
					throw new PokedexException("Veuillez entrer un index  entre 0 et 150");
				}
				return pokemon1;

			});
		 assertEquals(pokemon1,pokedex.getPokemon(0));
		 
		 // test  get avec une exeception
		 assertThrows(PokedexException.class,()->pokedex.getPokemon(151));
		 
	}

	@Test
	public void getPokemons() {
		pokemons.add(pokemon1);
		pokemons.add(pokemon2);
		when(pokedex.getPokemons()).thenReturn(pokemons);
		assertEquals(pokedex.getPokemons(), pokemons);
		assertEquals(pokemons.get(0), pokemon1);
		pokemons.clear();

	}

	@Test
	public void getPoemons_ComparatorName() {
		
		 when(pokedex.getPokemons(PokemonComparators.NAME)).thenAnswer(input -> {
				pokemons.add(pokemon1);
				pokemons.add(pokemon4);
				pokemons.add(pokemon2);
				pokemons.add(pokemon3);
				return pokemons;
			});
		 assertEquals(pokedex.getPokemons(PokemonComparators.NAME).get(0),pokemon1);
		 assertEquals(pokedex.getPokemons(PokemonComparators.NAME).get(1),pokemon4);
		 assertEquals(pokedex.getPokemons(PokemonComparators.NAME).get(2),pokemon2);
		 assertEquals(pokedex.getPokemons(PokemonComparators.NAME).get(3),pokemon3);
	    
		
	}
	
	@Test
	public void getPoemons_ComparatorCP() {
		
		 when(pokedex.getPokemons(PokemonComparators.CP)).thenAnswer(input -> {
				pokemons.add(pokemon2);
				pokemons.add(pokemon1);
				pokemons.add(pokemon4);
				pokemons.add(pokemon3);
				return pokemons;
			});	
		 assertEquals(pokedex.getPokemons(PokemonComparators.CP).get(0),pokemon2);
		 assertEquals(pokedex.getPokemons(PokemonComparators.CP).get(1),pokemon1);
		 assertEquals(pokedex.getPokemons(PokemonComparators.CP).get(2),pokemon4);
		 assertEquals(pokedex.getPokemons(PokemonComparators.CP).get(3),pokemon3);
	    
		
	}
	
	@Test
	public void getPoemons_ComparatorIndex() {
		
		 when(pokedex.getPokemons(PokemonComparators.INDEX)).thenAnswer(input -> {
				pokemons.add(pokemon2);
				pokemons.add(pokemon1);
				pokemons.add(pokemon4);
				pokemons.add(pokemon3);
				return pokemons;
			});	
		 assertEquals(pokedex.getPokemons(PokemonComparators.INDEX).get(0),pokemon2);
		 assertEquals(pokedex.getPokemons(PokemonComparators.INDEX).get(1),pokemon1);
		 assertEquals(pokedex.getPokemons(PokemonComparators.INDEX).get(2),pokemon4);
		 assertEquals(pokedex.getPokemons(PokemonComparators.INDEX).get(3),pokemon3);
	    
		
	}
	

}
