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
	private  IPokemonTrainerFactory pokemonTrainerFactory;
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
		
		MockitoAnnotations.initMocks(this);
		trainer = new PokemonTrainer(name, team,ipokedex);
		when(trainerFactory.createTrainer(name, team,pokedexFactory)).thenReturn(trainer);
	}

	
	
	@Test
	public void CreateTrainer() {

        assertEquals(trainer.getClass(),trainerFactory.createTrainer(name, team, pokedexFactory).getClass());

	}
	
	@Test
	public void testGetNom() {

		assertEquals("Wadii Team",trainerFactory.createTrainer(name, team, pokedexFactory).getName());

	}
	@Test
	public void testGetTeam() {
		trainer =  trainerFactory.createTrainer(name, team, pokedexFactory);
		assertEquals(Team.VALOR,trainerFactory.createTrainer(name, team, pokedexFactory).getTeam());

	}
	@Test
	public void testGetpoxdexFactory() {
		trainer =  trainerFactory.createTrainer(name, team, pokedexFactory);
		assertEquals(trainer.getPokedex(),trainerFactory.createTrainer(name, team, pokedexFactory).getPokedex());

	}
	
}
