package model;

public class MapOne extends PokemonMap {
	
	public MapOne() {
		super();
	}

	@Override
	public void initMap() {
		setEveryTileToEmpty(map);
		
	}
	
	@Override
	public String toString() {
		StringBuilder mapRep = new StringBuilder();
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				mapRep.append("[" + map[i][j].toString() + "] ");
			}
			mapRep.append("\n");
		}
		return mapRep.toString();
	}
	
	public void setEveryTileToEmpty(Tile[][] map) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = new EmptyTile();
			}
			
		}
	}

}
