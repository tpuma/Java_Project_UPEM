package fr.umlv.graphic;

import java.awt.Color;
//import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
//import java.util.Random;

import fr.umlv.map.Map;
import fr.umlv.zen5.Application;
import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.ScreenInfo;
import fr.umlv.zen5.Event.Action;

import fr.umlv.map.Wall;
import fr.umlv.map.Obstacle;
import fr.umlv.map.Position;
import fr.umlv.map.TrashCan;
import fr.umlv.character.PathFinder;
import fr.umlv.character.Robot;
import fr.umlv.map.Garbage;

public class Screen {

	static class Area {
		// private Ellipse2D.Float ellipse = new Ellipse2D.Float(0, 0, 0, 0);

		void draw(ApplicationContext context, float x, float y, float width, float height) {
			if (x < 170 || x > 1010 || y < 170 || y > 480) {
				return;
			}
			context.renderFrame(graphics -> {
				// graphics.setColor(Color.ORANGE);
				// graphics.fill(new Rectangle2D.Float(0, 0, width, height));
				// // hide the previous rectangle
				// graphics.setColor(Color.ORANGE);
				// graphics.fill(ellipse);

				// show a new ellipse at the position of the pointer
				/*
				 * graphics.setColor(Color.MAGENTA); ellipse = new Ellipse2D.Float(x - 20, y -
				 * 20, 40, 40); graphics.fill(ellipse);
				 */

			});
		}
	}

	public static void main(String[] args) {
		Application.run(Color.ORANGE, context -> {

			// get the size of the screen
			ScreenInfo screenInfo = context.getScreenInfo();
			float width = screenInfo.getWidth();
			float height = screenInfo.getHeight();
			System.out.println("size of the screen (" + width + " x " + height + ")");
			// for(float i = 0, j = 0 ; i < width && j < height ; i++, j++) {
			// add(new Position(i,j));
			// }
			Map map = new Map(width, height);
			ArrayList<Wall> walls = new ArrayList<Wall>();
			// Wall w = new Wall(map.getPlayableMap().get(0).getX(),
			// map.getPlayableMap().get(0).getY());
			Wall w = new Wall(0, 0);
			ArrayList<TrashCan> trashes = new ArrayList<TrashCan>();
			// TrashCan t = new TrashCan(map.getPlayableMap().get(0).getX(),
			// map.getPlayableMap().get(0).getY());
			TrashCan t = new TrashCan(0, 0);
			ArrayList<Garbage> garbages = new ArrayList<Garbage>();
			Garbage g = new Garbage(0, 0);
			ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
			ArrayList<Position> obstacle2 = new ArrayList<Position>();
			Robot r = new Robot(width/2, height/2);

			// wall in ARRAYS

			w.fillWalls(map, walls);

			// trashcan in ARRAYS

			t.fillTrashes(map, trashes);

			obstacles.addAll(walls);
			obstacles.addAll(trashes);
			for (int i = 0; i < walls.size(); i++) {
				obstacle2.addAll(walls.get(i).getWholeObstacle());
			}
			for (int i = 0; i < trashes.size(); i++) {
				obstacle2.addAll(trashes.get(i).getWholeObstacle());
			}

			// random garbage
			g.fillGarbages(map, obstacle2, garbages);
			obstacles.addAll(garbages);
			for (int i = 0; i < garbages.size(); i++) {
				obstacle2.addAll(garbages.get(i).getWholeObstacle());
			}

			context.renderFrame(graphics -> {
				graphics.setColor(Color.ORANGE);
				graphics.fill(new Rectangle2D.Float(0, 0, width, height));
				graphics.setColor(Color.BLACK);
				graphics.fill(new Rectangle2D.Float(map.getPlayableMap().get(0).getX(),
						map.getPlayableMap().get(0).getY(), width / 2, height / 2));

				for (TrashCan tc : trashes) {
					// System.out.println("T "+t);
					graphics.setColor(Color.GREEN);
					graphics.fill(new Rectangle2D.Float(tc.getUpLeft().getX(), tc.getUpLeft().getY(), tc.getSize(),
							tc.getSize()));
					graphics.setColor(Color.BLACK);
					graphics.fill(new Rectangle2D.Float(tc.getUpLeft().getX(), tc.getUpLeft().getY(), tc.getSize(), 1));

				}
				for (Wall wl : walls) {
					// System.out.println("W "+w);
					graphics.setColor(Color.PINK);
					graphics.fill(new Rectangle2D.Float(wl.getUpLeft().getX(), wl.getUpLeft().getY(), wl.getSize(),
							wl.getSize()));
					graphics.setColor(Color.BLACK);
					graphics.fill(new Rectangle2D.Float(wl.getUpLeft().getX(), wl.getUpLeft().getY(), 1, wl.getSize()));

				}

				for (Garbage gb : garbages) {
					// System.out.println("G "+g);
					graphics.setColor(Color.BLUE);
					graphics.fill(new Rectangle2D.Float(gb.getUpLeft().getX(), gb.getUpLeft().getY(), gb.getSize(),
							gb.getSize()));
				}
				// System.out.println(walls.size());
				// System.out.println(trashes.size());
				// System.out.println(garbages.size());
				graphics.setColor(Color.CYAN);
				graphics.fill(new Rectangle2D.Float(r.getPosition().getX(), r.getPosition().getY(), 20, 20));
			});

			Area area = new Area();
			for (;;) {
				Event event = context.pollOrWaitEvent(10);
				if (event == null) { // no event
					continue;
				}
				Action action = event.getAction();
				if (action == Action.KEY_PRESSED || action == Action.KEY_RELEASED) {
					System.out.println("abort abort !");
					context.exit(0);
					return;
				}
				System.out.println(event);

				Point2D.Float location = event.getLocation();
//				Position goal = new Position(location.x, location.y);
//				PathFinder pf = new PathFinder();
//				pf.pathFinding(r.getPosition(), goal, obstacle2);
				area.draw(context, location.x, location.y, width, height);
			}
		});
	}
}
