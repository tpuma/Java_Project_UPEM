package fr.umlv.map;

import java.util.ArrayList;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;

public class Wall extends Obstacle {

	public Wall(float x, float y) {
		super(x, y, 20);
//		for (float i = x; i < x + getSize(); i++) {
//			for (float j = y; j < y + getSize(); j++) {
//				this.getWholeObstacle().add(new Position(i, j));
//			}
//		}
	}

	public void fillWalls(Map map, ArrayList<Wall> walls) {
		for (float i = map.getPlayableMap().get(0).getX(); i < map.getPlayableMap().get(map.getPlayableMap().size() - 2)
				.getX(); i += this.getSize()) {
			walls.add(new Wall(i, map.getPlayableMap().get(0).getY()));
		}
		for (float i = map.getPlayableMap().get(0).getX(); i < map.getPlayableMap().get(map.getPlayableMap().size() - 2)
				.getX(); i += this.getSize()) {
			walls.add(new Wall(i, map.getPlayableMap().get(map.getPlayableMap().size() - 1).getY()));
		}
	}
	
	public Body initBody(Map map) {
		BodyDef bdWall = new BodyDef();
		
		Body wall = new Body(bdWall, map.initWorld());
		wall.setType(BodyType.STATIC);
		wall.setTransform(new Vec2(getUpLeft().getX(), getUpLeft().getY()), 0);
		
		return wall;
	}
}
