package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

	private List<PokemonMetadata> metadataList;

	public PokemonMetadataProvider() {
		metadataList = new ArrayList<>();
		PokemonMetadata bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
		PokemonMetadata aquali = new PokemonMetadata(133, "Aquali", 186, 168, 260);
		metadataList.add(bulbizarre);
		metadataList.add(aquali);

	}

	public void addPokemonMetadata(PokemonMetadata metadata) {
		metadataList.add(metadata);
	}

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		if (index < 0 || index > 150) {
			throw new PokedexException("index est invalide");
		}
		for (PokemonMetadata metadata : metadataList){
            if(metadata.getIndex() == index)
            	return metadata;
        }
		return null;

	}

}
