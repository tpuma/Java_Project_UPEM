package fr.umlv.map;

import java.util.ArrayList;
import java.util.Random;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;

public class Garbage extends Obstacle {

	public Garbage(float x, float y) {
		super(x, y, 20);
		for (float i = x; i < x + getSize(); i++) {
			for (float j = y; j < y + getSize(); j++) {
				this.getWholeObstacle().add(new Position(i, j));
			}
		}
	}

	public void fillGarbages(Map map, ArrayList<Position> obstacles, ArrayList<Garbage> garbages) {
		Random rd = new Random();
		for (int i = 0; i < 3; i++) {
			int j = rd.nextInt(map.getPlayableMap().size());
			System.out.println("random = " + j);
			Position p = map.getPlayableMap().get(j);
			System.out.println("position = " + p);
			// Wall tmpW = new Wall(p.getX(), p.getY());
			// TrashCan tmpT = new TrashCan(p.getX(), p.getY());
			if (obstacles.contains(p) || obstacles.contains(p)) {
				continue;
			}
			garbages.add(new Garbage(p.getX(), p.getY()));
		}
	}
	
	public Body initBody(Map map) {
		BodyDef bdGarbage = new BodyDef();
		
		Body garbage = new Body(bdGarbage, map.initWorld());
		garbage.setType(BodyType.DYNAMIC);
		garbage.setTransform(new Vec2(getUpLeft().getX(), getUpLeft().getY()), 0);
		
		return garbage;
	}

}