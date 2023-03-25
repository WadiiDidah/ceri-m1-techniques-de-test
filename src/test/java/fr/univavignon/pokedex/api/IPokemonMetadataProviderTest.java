package fr.univavignon.pokedex.api;

import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;
import org.mockito.ArgumentMatcher.*;
import static org.mockito.Mockito.*;

public class IPokemonMetadataProviderTest {
	@Test
	public void Test_GetPokemonMetadata_ReturnsValidMetadata() throws PokedexException {
		// Arrange
		int pokemonIndex = 1;
		IPokemonMetadataProvider provider = Mockito.mock(IPokemonMetadataProvider.class);
	    PokemonMetadata metadata = new PokemonMetadata(0, "Bulbizarre",126,126, 90);
		when(provider.getPokemonMetadata(anyInt())).thenAnswer(input -> {
			int index = input.getArgument(0);
			return metadata;	

		});
		// Assert
		assertEquals(metadata, provider.getPokemonMetadata(0));
		
	}

	@Test
	public void Test_GetPokemonMetadata_with_invalideIndex() throws PokedexException {
		// Arrange
		int pokemonIndex = 1;
		IPokemonMetadataProvider provider = Mockito.mock(IPokemonMetadataProvider.class);
	    PokemonMetadata metadata = new PokemonMetadata(0, "Bulbizarre",126,126, 90);
		when(provider.getPokemonMetadata(anyInt())).thenAnswer(input -> {
			int index = input.getArgument(0);
			if (index < 0) {
				throw new PokedexException("Veuillez entrer un index  entre 0 et 150");
			} else if (index > 150) {
				throw new PokedexException("index doit être inférieur à 150");
			}
			return metadata;

		});
		// Assert
		assertThrows(PokedexException.class,() -> {provider.getPokemonMetadata(-1);});
		assertThrows(PokedexException.class,() -> {provider.getPokemonMetadata(151);});
	}

}
