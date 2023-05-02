package fr.univavignon.pokedex.api;

import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;
import org.mockito.ArgumentMatcher.*;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {

	PokemonFactory factory;
	IPokemonMetadataProvider pokemonMetadataProvider;
	Pokedex pokedex;
	Pokemon bulbizarre;
	Pokemon aquali;

	@Before
	public void init() {
		factory = new PokemonFactory();
		pokemonMetadataProvider = new PokemonMetadataProvider();
		bulbizarre = new Pokemon(133, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		aquali = new Pokemon(0, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
		pokemonMetadataProvider = new PokemonMetadataProvider();
	}

	
	@Test
	public void createAquali() throws PokedexException {
	    double delta = 0.0001;
		Assert.assertEquals(aquali.getCp(),factory.createPokemon(0,2729,  202,5000, 4).getCp());
		Assert.assertEquals(aquali.getHp(),factory.createPokemon(0,2729,  202,5000, 4).getHp());
		Assert.assertEquals(aquali.getIndex(),factory.createPokemon(0,2729,  202,5000, 4).getIndex());
		Assert.assertEquals(aquali.getCandy(),factory.createPokemon(0,2729,  202,5000, 4).getCandy());
		Assert.assertEquals(aquali.getDust(),factory.createPokemon(0,2729,  202,5000, 4).getDust());
		Assert.assertEquals(aquali.getIv(),factory.createPokemon(0,2729,  202,5000, 4).getIv(),delta);


	}

	@Test
	public void Test_GetPokemon_with_invalidIndex() throws PokedexException {
		Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 614, 64, 4000, 4, 56);
		assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-12));
		assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(189));
	};

}
