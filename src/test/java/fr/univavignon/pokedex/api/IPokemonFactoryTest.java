package fr.univavignon.pokedex.api;

import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;
import org.mockito.ArgumentMatcher.*;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {
	@Test
	public void Test_GetPokemon() throws PokedexException {
		IPokemonFactory factory = Mockito.mock(IPokemonFactory.class);
		Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 614, 64, 4000, 4, 56);
		when(factory.createPokemon(anyInt(), eq(613), eq(64), eq(4000), eq(4))).thenAnswer(input -> {

			return pokemon;

		});
		assertEquals(pokemon, factory.createPokemon(0, 613, 64, 4000, 4));

	}

	@Test
	public void Test_GetPokemon_with_invalidIndex() throws PokedexException {
		IPokemonFactory factory = Mockito.mock(IPokemonFactory.class);
		Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 614, 64, 4000, 4, 56);
		when(factory.createPokemon(anyInt(), eq(613), eq(64), eq(4000), eq(4))).thenAnswer(input -> {
			int index = input.getArgument(0);
			if (index < 0 || index > 150) {
				throw new PokedexException("Veuillez entrer un index  entre 0 et 150");
			}
			return pokemon;

		});
		assertThrows(PokedexException.class, () -> factory.createPokemon(-12, 613, 64, 4000, 4));
		assertThrows(PokedexException.class, () -> factory.createPokemon(190, 613, 64, 4000, 4));
	};

}
