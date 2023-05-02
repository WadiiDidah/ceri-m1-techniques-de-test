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
	
	PokemonTrainer trainer;
	String name="Wadii Team"; 
	Team team = Team.VALOR;
	PokemonTrainerFactory trainerFactory;
	
	@Before
	public void initialiser() {
		MockitoAnnotations.initMocks(this);
		trainerFactory= new PokemonTrainerFactory();
		 trainer = trainerFactory.createTrainer(name, team, new PokedexFactory());
		
	}

	
	
	@Test 
    public void testCreateTrainer() {

        assertEquals(trainer.getClass(),trainer.getClass());

	}
	
	@Test
	public void testGetNom() {

		assertEquals("Wadii Team",trainer.getName());

	}
	@Test
	public void testGetTeam() {
		trainer =  trainerFactory.createTrainer(name, team, pokedexFactory);
		assertEquals(Team.VALOR,trainer.getTeam());

	}
	@Test
	public void testGetpoxdexFactory() {
		trainer =  trainerFactory.createTrainer(name, team, pokedexFactory);
		assertEquals(trainer.getPokedex(),trainer.getPokedex());

	}
	
}
