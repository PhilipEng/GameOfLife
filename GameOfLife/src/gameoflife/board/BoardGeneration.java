package gameoflife.board;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import javax.swing.*;


import java.awt.*;




public class BoardGeneration {
	
	private int xwindow;
	private int ywindow;
	private int numRows;
	private int numColumns;
	private int sizeElement;
	
	public BoardGeneration() {
		this.xwindow = 1000;
		this.ywindow = 1000;
		this.setNumRows(24);
		this.setNumColumns(18);
		this.setSizeElement(3);
	}
	

	
	public void drawBoard(int[][][] boardSpaceData) {
		int xrect = (this.xwindow-15)/this.getNumColumns();
		int yrect = (this.ywindow-40)/this.getNumRows();

		JFrame frame = new JFrame("GameOfLifeBoard");
		frame.setVisible(true);
		frame.setSize(this.xwindow, this.ywindow);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel myPanel = new MyPanel(xrect, yrect, boardSpaceData, this.getNumRows(), this.getNumColumns());
		myPanel.setBackground(Color.WHITE);		
		frame.add(myPanel);

	}

	
	public int[][][] boardMatrixfromcsvFile(Path path, int numRows, int numColumns, int sizeElement){
		int[][][] spaceData = new int[numRows][numColumns][sizeElement];
		String[][] elementData = new String[numColumns][sizeElement];
		int[][] elementIntData = new int[numColumns][sizeElement];
		try (BufferedReader br = Files.newBufferedReader(path)){
			int linesCounter = 0;
			String line = br.readLine();
			
			/*for(int i = 0; i < 19; i++) { // Read and ignore the first 19 lines of text
				line = br.readLine();
			}*/
			
			String[] data = null ; //Split the line into card data

			while (line != null) {
				line= line.replace("?", "");
				data = line.split(","); //Split the line into card data
				System.out.println(line);
				elementData = new String[numColumns][sizeElement];
				elementIntData = new int[numColumns][sizeElement];
				for(int i = 0;i<data.length;i++) {
					elementData[i] = data[i].split("_");
					System.out.println(Arrays.deepToString(elementData[i]));
					for(int j = 0;j<sizeElement;j++) {
						elementIntData[i][j] = Integer.parseInt(elementData[i][j]);
					}
				}
				spaceData[linesCounter] = elementIntData;
				line = br.readLine();	//If null, loop is exited
				linesCounter = linesCounter+1;
			}

			return spaceData;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return spaceData;
	}



	public int getNumRows() {
		return numRows;
	}



	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}



	public int getNumColumns() {
		return numColumns;
	}



	public void setNumColumns(int numColumns) {
		this.numColumns = numColumns;
	}



	public int getSizeElement() {
		return sizeElement;
	}



	public void setSizeElement(int sizeElement) {
		this.sizeElement = sizeElement;
	}
}
