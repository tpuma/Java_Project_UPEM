package fr.umlv.map;

public class Position {
	private float x;
	private float y;
	
	public Position(float x, float y) {
		if(x < 0 || y < 0) {
			throw new IllegalArgumentException("x or y can't be negatives");
		}
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float squareDistance(Position p) {
		float dx = this.x-p.x;
		float dy = this.y-p.y;
		return dx*dx + dy*dy;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Position)) {
			return false;
		}
		Position p = (Position) o;
		return this.x == p.x && this.y == p.y;
	}
}
