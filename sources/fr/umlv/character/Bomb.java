package fr.umlv.character;

import fr.umlv.map.Position;

public class Bomb {
	private Position position;
	private int time;
	
	public Bomb(float x, float y) {
		this.position = new Position(x, y);
		this.time = 0;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	public void addTimeBomb(int n) {
		this.time+=n;
	}
	
	@Override
	public String toString() {
		return "Bomb en "+position.toString();
	}
}
