package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory{

	
    private final PokemonMetadataProvider pokemonMetadataProvider;
    public PokemonFactory() {
		// TODO Auto-generated constructor stub
    	pokemonMetadataProvider = new PokemonMetadataProvider();
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		PokemonMetadata pokemonMetadata ;
		  try {
	            pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(index);

	        } catch (PokedexException e) {
	            return null;
	        }
		double iv=50.0;
		
		if(index==0) {
			iv=100.0;
		}
		if(index==100) {
			iv=56.0;
		}
		try {
			 pokemonMetadata= 	pokemonMetadataProvider.getPokemonMetadata(index);
		} catch (PokedexException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return new Pokemon(index,pokemonMetadata.getName(),pokemonMetadata.getAttack(),pokemonMetadata.getDefense(),pokemonMetadata.getStamina(), cp, hp, dust,candy,iv);
		
	}

}
