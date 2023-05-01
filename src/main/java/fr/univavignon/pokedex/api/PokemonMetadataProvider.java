package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

	private List<PokemonMetadata> metadataList;

	public PokemonMetadataProvider() {
		 metadataList = new ArrayList<>();

	}
	
	public void addPokemonMetadata(PokemonMetadata metadata) {
        metadataList.add(metadata);
    }

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		if (index < 0 || index >= metadataList.size()) {
            throw new PokedexException("index est invalide");
        }
        return metadataList.get(index);
		
	}

}
