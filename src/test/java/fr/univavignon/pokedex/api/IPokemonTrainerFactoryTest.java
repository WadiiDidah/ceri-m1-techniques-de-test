package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class IPokemonTrainerFactoryTest {

	@Mock
	private IPokedexFactory pokedexFactory;
	@Mock
	IPokedex ipokedex;
	@Mock
	IPokemonTrainerFactory trainerFactory;
	@Mock
	IPokemonTrainerFactory iPokemonTrainerFactory;
	PokemonTrainer trainer;
	String name = "Wadii Team";
	Team team = Team.VALOR;
	@Before
	public void initialiser() {
		trainer = new PokemonTrainer(name, team, ipokedex);
		MockitoAnnotations.initMocks(this);
		when(trainerFactory.createTrainer(name, team, pokedexFactory)).thenReturn(trainer);
	}

	@Test
	public void testGetNom() {
		trainer =  trainerFactory.createTrainer(name, team, pokedexFactory);
		assertEquals(trainer.getName(),name);

	}
	@Test
	public void testGetTeam() {
		trainer =  trainerFactory.createTrainer(name, team, pokedexFactory);
		assertEquals(trainer.getTeam(),team);

	}
	@Test
	public void testGetpoxdexFactory() {
		trainer =  trainerFactory.createTrainer(name, team, pokedexFactory);
		assertEquals(trainer.getPokedex(),pokedexFactory);

	}
	
}
