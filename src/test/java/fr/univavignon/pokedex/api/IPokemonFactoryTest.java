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
		bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
		pokemonMetadataProvider = new PokemonMetadataProvider();
	}

	@Test
	public void createAquali() throws PokedexException {

		Assert.assertEquals(aquali.getCp(), aquali.getCp());
		Assert.assertEquals(aquali.getAttack(), aquali.getAttack());
		Assert.assertEquals(aquali.getDefense(), aquali.getDefense());
		Assert.assertEquals(aquali.getCandy(), aquali.getCandy());
		Assert.assertEquals(aquali.getIndex(), aquali.getIndex());
		Assert.assertEquals(aquali.getStamina(), aquali.getStamina());
		Assert.assertEquals(aquali.getDust(), aquali.getDust());
		Assert.assertEquals(aquali.getHp(), aquali.getHp());

	}

	@Test
	public void Test_GetPokemon_with_invalidIndex() throws PokedexException {
		Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 614, 64, 4000, 4, 56);
		assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-12));
		assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(189));
	};

}
