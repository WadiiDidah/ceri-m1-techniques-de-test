 	package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokedexFactoryTest {
	@Mock
	private IPokemonMetadataProvider pokemonMetadataProvider;
	
	private IPokedexFactory pokedexFactory;
	@Mock
	private IPokemonFactory factory;
	@Mock
	private IPokedex iPokedex;

	@Before
	public void initialiser() throws PokedexException {
		MockitoAnnotations.initMocks(this);
		 pokedexFactory = new PokedexFactory();
		
		

	}

	@Test
	public void Test_GetPokemon() throws PokedexException {
		Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 614, 64, 4000, 4, 56);
		iPokedex.addPokemon(pokemon);
		
		
		
        assertEquals(Pokedex.class,pokedexFactory.createPokedex(pokemonMetadataProvider,factory).getClass());


	}

}
