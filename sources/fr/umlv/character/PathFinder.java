package fr.umlv.character;

import java.util.ArrayList;
//import java.util.Objects;
//
//import fr.umlv.map.Obstacle;
import fr.umlv.map.Position;

public class PathFinder {
	private class Cell {
		private Position p;
		private float cost;
		
		private Cell(Position p, float cost) {
			this.p = p;
			this.cost = cost;
		}
	}
	//private Position start;
	//private int found;
	//Nodes already evaluated
	private ArrayList<Cell> closedSet = new ArrayList<Cell>();
	//Nodes not evaluated yet
	private ArrayList<Cell> openSet = new ArrayList<Cell>();
	// Road to use
	private ArrayList<Cell> actualRoad = new ArrayList<Cell>();
	//Map to use
	//private final Screen map;
	/*public PathFinder(int x, int y) {
		this.start = new Position(x,y);
		this.found = 0;
	}*/
	
	public void pathFinding(Position start, Position goal, ArrayList<Position> obstacles) {
		openSet.add(new Cell(start,0));
		while(!openSet.isEmpty()) {
			Cell current = openSet.get(0);
			for(Cell c : openSet) {
				if(c.cost < current.cost ) {
					current = c;
				}
			}
			openSet.remove(current);
			closedSet.add(current);
			
			if(current.p.equals(goal)) {
				return;
			}
			for(float i = (current.p.getX())-1, j = (current.p.getY())-1; i <= i+2 && j <= j+2; i++, j++) {
				//Neighbor coordinate
				Position neighborPos = new Position(i,j);
				//Actual neighbor
				Cell neighbor  = new Cell(neighborPos, current.p.squareDistance(neighborPos));
				if(obstacles.contains(neighborPos) || closedSet.contains(neighbor)){
					continue;
				}
				if(!openSet.contains(neighbor)) {
					openSet.add(neighbor);
				}
				float totalCost = current.cost + current.p.squareDistance(neighborPos);
				if(totalCost >= neighbor.cost) {
					continue;
				}
				actualRoad.add(current);
				neighbor.cost = totalCost;
			}
			throw new IllegalStateException("error in path finding");
		}
		
		
	}
	
	public ArrayList<Cell> drawPath(ArrayList<Cell> actualRoad, Cell current) {
		ArrayList<Cell> totalPath = new ArrayList<Cell>();
		totalPath.add(current);
		for(int i = 1 ; actualRoad.contains(current); i++) {
			current = actualRoad.get(i);
			totalPath.add(current);
		}
		return totalPath;
	}
}
