package fr.umlv.map;

import java.util.ArrayList;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;

public class TrashCan extends Obstacle {

	public TrashCan(float x, float y) {
		super(x, y, 20);
		for (float i = x; i < x + getSize(); i++) {
			for (float j = y; j < y + getSize(); j++) {
				this.getWholeObstacle().add(new Position(i, j));
			}
		}
	}

	public void fillTrashes(Map map, ArrayList<TrashCan> trashes) {
		for (float i = map.getPlayableMap().get(0).getY(); i < map.getPlayableMap().get(map.getPlayableMap().size() - 2)
				.getY(); i += this.getSize()) {
			trashes.add(new TrashCan(map.getPlayableMap().get(0).getX(), i));
		}
		for (float i = map.getPlayableMap().get(0).getY(); i < map.getPlayableMap().get(map.getPlayableMap().size() - 2)
				.getY(); i += this.getSize()) {
			trashes.add(new TrashCan(map.getPlayableMap().get(map.getPlayableMap().size() - 1).getX(), i));
		}
	}
	public Body initBody(Map map) {
		BodyDef bdTrash = new BodyDef();
		
		Body trash = new Body(bdTrash, map.initWorld());
		trash.setType(BodyType.STATIC);
		trash.setTransform(new Vec2(getUpLeft().getX(), getUpLeft().getY()), 0);
		
		return trash;
	}
}
