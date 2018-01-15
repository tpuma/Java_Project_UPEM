package fr.umlv.map;

import java.util.ArrayList;

public abstract class Obstacle {
	private final Position upLeft;
	private final int size;
	private final ArrayList<Position> wholeObstacle = new ArrayList<Position>();
	
	public Obstacle(float x, float y, int size) {
		this.upLeft = new Position(x,y);
		if(size <= 0) {
			throw new IllegalArgumentException("size can't be negative or null");
		}
		this.size = size;
		for(float i = x ; i < x+size ; i++) {
			for(float j = y ; j < y+size ; j++) {
				this.wholeObstacle.add(new Position(i, j));
			}
		}
	}

	
	public Position getUpLeft() {
		return upLeft;
	}
	
	public ArrayList<Position> getWholeObstacle() {
		return wholeObstacle;
	}
	
	public int getSize() {
		return size;
	}
	
	@Override
	public String toString() {
		return upLeft.toString()+" Size = "+size;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Obstacle)) {
			return false;
		}
		Obstacle obs = (Obstacle) o;
		return this.upLeft.equals(obs.upLeft) && 
				this.size == obs.size && 
				this.wholeObstacle.equals(obs.wholeObstacle);
	}
	
	
}
