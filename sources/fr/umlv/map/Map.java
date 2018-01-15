package fr.umlv.map;

import java.util.ArrayList;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

public class Map {
	private final ArrayList<Position> playableMap = new ArrayList<Position>();
	
	public Map(float x, float y) {
		for(float i = x/4 ; i < 3*x/4 ; i++) {
			for(float j = y/4 ; j < 3*y/4 ; j++) {
				this.playableMap.add(new Position(i, j));
			}
		}
	}
	
	public ArrayList<Position> getPlayableMap(){
		return this.playableMap;
	}
	
	public World initWorld() {
		World map = new World(new Vec2(0,0));
		return map;
	}
	
}