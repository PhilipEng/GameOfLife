package gameoflife.board;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.*;

import gameoflife.board.spaces.Space;
import gameoflife.player.Player;
import java.util.ArrayList;

import java.awt.*;




public class BoardGeneration {
	
	private int xwindow;
	private int ywindow;
	private int numRows;
	private int numColumns;
	private int sizeElement;
	private JFrame frame;
	private JFrame frameNew;
	
	/**
	 * Board Generation Construction
	 * 
	 * Board Generation, window size and number of Columns, Rows and elements per space are defined on construction. Generates Jframe's for Board Visualisation.
	 */
	public BoardGeneration() {
		this.xwindow = 1000;
		this.ywindow = 1000;
		this.setNumRows(24);
		this.setNumColumns(18);
		this.setSizeElement(3);	
		this.frame = new JFrame("Game Of Life");
		this.frameNew = new JFrame("Game Of Life");
	}
	

	
	/**
	 * drawBoard() will call the MyPanel class which will paint a JPanel onto our Jframe. Draw Board is used for the beginning of the game, it does not display player positions.
	 * 
	 * Xrect and Yrect determine size of a space on the board in pixels, this is determined by the size of the Jframe and the number of spaces on the board.
	 * 
	 * @param boardSpaceData Board Space data is a 3 dimensional int array (int[][][]) that contains all of the space data (space num, space type and branch num).
	 */
	public void drawBoard(int[][][] boardSpaceData) {
		int xrect = (this.xwindow-15)/this.getNumColumns();
		int yrect = (this.ywindow-40)/this.getNumRows();
		this.frame.setVisible(true);
		frame.setSize(this.xwindow, this.ywindow);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel myPanel = new MyPanel(xrect, yrect, boardSpaceData, this.getNumRows(), this.getNumColumns());
		myPanel.setBackground(Color.WHITE);		
		frame.add(myPanel);

	}
	
	/**
	 * reDrawBoard() redraws the same board as drawBoard() but it includes Players Pawns and Player Legend
	 * 
	 * @param boardSpaceData Board Space data is a 3 dimensional int array (int[][][]) that contains all of the space data (space num, space type and branch num).
	 * @param players List of Player objects, used for placing Player Pawns on the board.
	 * @param spaces List of Space Objects.
	 */
	public void redrawBoard(int[][][] boardSpaceData, ArrayList<Player> players, ArrayList<Space> spaces) {
		int xrect = (this.xwindow-15)/this.getNumColumns();
		int yrect = (this.ywindow-40)/this.getNumRows();
		frame.dispose();
		frameNew.setVisible(true);
		frameNew.setSize(this.xwindow, this.ywindow);
		frameNew.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel myPanel= new MyPanel(xrect, yrect, boardSpaceData, this.getNumRows(), this.getNumColumns(), players, spaces);
		myPanel.setBackground(Color.WHITE);	
		frameNew.repaint();
		frameNew.add(myPanel);
	}


	/**
	 * boardMatrixfromcsvFile() reads the CSV file contained in path and parses it into an int[][][] array.
	 * 
	 * Elements in the CSV file are in the form x_y_z , where x is the space number, y is the space type (int which corresponds to space type) and z is the branch value.
	 * 
	 * @param path Path to Board CSV File.
	 * @param numRows The number of Rows in the CSV file.
	 * @param numColumns The number of Columns in the CSV file.
	 * @param sizeElement Number of elements in each space element.
	 * @return Returns BoardSpaceData, a 3 dimensional int array (int[][][]) that contains all of the space data (space num, space type and branch num).
	 */
	public int[][][] boardMatrixfromcsvFile(Path path, int numRows, int numColumns, int sizeElement){
		int[][][] spaceData = new int[numRows][numColumns][sizeElement];
		String[][] elementData = new String[numColumns][sizeElement];
		int[][] elementIntData = new int[numColumns][sizeElement];
		try (BufferedReader br = Files.newBufferedReader(path)){
			int linesCounter = 0;
			String line = br.readLine();
			
			String[] data = null ;

			while (line != null) {
				line= line.replace("?", "");
				data = line.split(","); //Split the line into card data
				elementData = new String[numColumns][sizeElement];
				elementIntData = new int[numColumns][sizeElement];
				for(int i = 0;i<data.length;i++) {
					elementData[i] = data[i].split("_");
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
			e.printStackTrace();
		}
		return spaceData;
	}



	/**
	 * Returns number of Rows in CSV file.
	 * 
	 * @return Returns numRows
	 */
	public int getNumRows() {
		return numRows;
	}



	/**
	 * Sets number of Rows in CSV file
	 * 
	 * @param numRows Number of Rows in CSV file
	 */
	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}



	/**
	 * Gets number of Columns in CSV file
	 * @return Returns Number of Columns in CSV file
	 */
	public int getNumColumns() {
		return numColumns;
	}



	/**
	 * Sets number of Columns in CSV file
	 * 
	 * @param numColumns Number of Columns in CSV file
	 */
	public void setNumColumns(int numColumns) {
		this.numColumns = numColumns;
	}



	/**
	 * Gets number of elements space in CSV file
	 * 
	 * @return Returns Number of Elements in space in CSV file
	 */
	public int getSizeElement() {
		return sizeElement;
	}



	/**
	 * Sets number of elements space in CSV file
	 * 
	 * @param sizeElement Number of Elements in space in CSV file
	 */
	public void setSizeElement(int sizeElement) {
		this.sizeElement = sizeElement;
	}
}
