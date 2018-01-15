package fr.umlv.character;

import fr.umlv.map.Position;

public class Robot {
	private Position position;
	private Bomb bomb;
	private int nbBomb;
	
	public Robot(float x, float y) {
		this.position = new Position(x, y);
		this.bomb = new Bomb(0,0);
		this.nbBomb = 3;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	@Override
	public String toString() {
		return "Robot en "+position.toString();
	}
	
	public void dropBomb() {
		this.bomb.getPosition().setX(this.position.getX());//move()
		this.bomb.getPosition().setY(this.position.getY());
		this.nbBomb--;
	}
	
}
