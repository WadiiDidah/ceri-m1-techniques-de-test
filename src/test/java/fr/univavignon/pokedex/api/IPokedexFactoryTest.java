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
	@Mock
	private IPokedexFactory ipokedexFactory;
	@Mock
	private IPokemonFactory factory;
	@Mock
	private IPokedex iPokedex;

	@Before
	public void initialiser() throws PokedexException {
		MockitoAnnotations.initMocks(this);
		PokemonMetadata pokemonMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
		when(pokemonMetadataProvider.getPokemonMetadata(anyInt())).thenAnswer(input -> {
			return pokemonMetadata;
		});

	}

	@Test
	public void Test_GetPokemon() throws PokedexException {
		Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 614, 64, 4000, 4, 56);
		iPokedex.addPokemon(pokemon);
		when(ipokedexFactory.createPokedex(pokemonMetadataProvider, factory)).thenReturn(iPokedex);

		when(factory.createPokemon(anyInt(), eq(613), eq(64), eq(4000), eq(4))).thenAnswer(input -> {

			return pokemon;

		});
		
		assertEquals(ipokedexFactory.createPokedex(pokemonMetadataProvider, factory), iPokedex);
		assertEquals(ipokedexFactory.createPokedex(pokemonMetadataProvider, factory).getPokemon(0), iPokedex.getPokemon(0));
		

	}

}
