package ua.cooperok.foxhunting.game;

public class CellCollection {
	
	protected Cell [][] Cells;
	
	protected int width = 10;
	
	protected int height = 10;
	
	public CellCollection() {
		
		Cells = createEmptyCollection();
		
	}
	
	protected Cell[][] createEmptyCollection() {
		
		Cell[][] emptyCells = new Cell[getWidth()][getHeight()];
		
		for(int i = 0; i < getWidth(); i++) {
			
			for(int j = 0; j < getHeight(); j++) {
				
				emptyCells[i][j] = new Cell();
				
			}
			
		}
		
		return emptyCells;
		
	}
	
	public int getWidth() {
		
		return width;
		
	}
	
	public int getHeight() {
		
		return height;
		
	}
	

}
