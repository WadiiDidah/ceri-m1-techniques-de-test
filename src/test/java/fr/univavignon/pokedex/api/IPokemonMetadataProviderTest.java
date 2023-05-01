package fr.univavignon.pokedex.api;

import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;
import org.mockito.ArgumentMatcher.*;
import static org.mockito.Mockito.*;

public class IPokemonMetadataProviderTest {
	
	
	
	IPokemonMetadataProvider pokemonMetadataProvider;
	Pokedex pokedex;
	Pokemon bulbizarre;
	Pokemon aquali;

	@Before
	public void init() {
		
		
		bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
		pokemonMetadataProvider = new PokemonMetadataProvider();
	}
	@Test
	public void Test_GetPokemonMetadata_ReturnsValidMetadata() throws PokedexException {
		// Arrange
		 assertEquals(bulbizarre.getIndex(),pokemonMetadataProvider.getPokemonMetadata(0).getIndex());
	     assertEquals(aquali.getDefense(),pokemonMetadataProvider.getPokemonMetadata(133).getDefense());
		
		
	}

	@Test
	public void Test_GetPokemonMetadata_with_invalideIndex() throws PokedexException {
		// Assert
		assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(190));
	    assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-50));
	}

}
