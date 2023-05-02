package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class IPokedexTest {

	
    private Pokedex pokedex;


	private List<Pokemon> pokemons=new ArrayList<>();
	Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56); // 10
	Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2792, 202, 5000, 4, 100); // 6
	Pokemon pokemon3 = new Pokemon(120, "POK3", 186, 168, 260,100, 202, 5000, 4, 100); // 4
	Pokemon pokemon4 = new Pokemon(1, "POKEMON4", 186, 168, 260,300, 202, 5000, 4, 100); // 8

	@Before
	public void initialiser() throws PokedexException {
		
		pokedex = new Pokedex();
		pokemons = pokedex.getPokemons();
		pokedex.addPokemon(pokemon1);
		pokedex.addPokemon(pokemon3);
		pokedex.addPokemon(pokemon4);
		pokemons = pokedex.getPokemons();

	}

	@Test
	public void Test_size() {
		assertEquals(3, pokedex.size());
		pokedex.addPokemon(pokemon2);
		assertEquals(4, pokedex.size());

	}

	@Test
	public void Test_add() {
		
		
		assertEquals(pokemons.size()+1, pokedex.addPokemon(pokemon3));

	}

	@Test
	public void Test_getPokemon() throws PokedexException {
		
		
		 assertEquals(pokemon1,pokedex.getPokemon(0));
		 assertEquals(pokemon1.getName(),pokedex.getPokemon(0).getName());
		 assertEquals(pokemon1.getAttack(),pokedex.getPokemon(0).getAttack());
		 assertEquals(pokemon1.getDefense(),pokedex.getPokemon(0).getDefense());
		 assertEquals(pokemon1.getStamina(),pokedex.getPokemon(0).getStamina());
		 
		 
		 // test  get avec une exeception
		 assertThrows(PokedexException.class,()->pokedex.getPokemon(151));
		 
	}

	@Test
	public void getPokemons() {
		assertEquals(pokedex.getPokemons(), pokemons);
		assertEquals(pokedex.getPokemons().size(), pokemons.size());
		assertEquals(pokedex.getPokemons().get(0), pokemon1);
		

	}

	@Test
	public void getPoemons_ComparatorName() {
		
	
		 assertEquals(pokedex.getPokemons(PokemonComparators.NAME).get(0).getName(),pokemon1.getName());
		 assertEquals(pokedex.getPokemons(PokemonComparators.NAME).get(1).getName(),pokemon3.getName());
		 assertEquals(pokedex.getPokemons(PokemonComparators.NAME).get(2).getName(),pokemon4.getName());

		
	}
	
	@Test
	public void getPoemons_ComparatorCP() {
		
		 assertEquals(pokedex.getPokemons(PokemonComparators.CP).get(0).getName(),pokemon3.getName());
		 assertEquals(pokedex.getPokemons(PokemonComparators.CP).get(1).getName(),pokemon4.getName());
		 assertEquals(pokedex.getPokemons(PokemonComparators.CP).get(2).getName(),pokemon3.getName());

	    
		
	}
	
	@Test
	public void getPoemons_ComparatorIndex() {
		
		
		 assertEquals(pokedex.getPokemons(PokemonComparators.INDEX).get(0).getIndex(),pokemon1.getIndex());
		 assertEquals(pokedex.getPokemons(PokemonComparators.INDEX).get(1).getIndex(),pokemon4.getIndex());
		 assertEquals(pokedex.getPokemons(PokemonComparators.INDEX).get(2).getIndex(),pokemon3.getIndex());

	    
		
	}
	

}
