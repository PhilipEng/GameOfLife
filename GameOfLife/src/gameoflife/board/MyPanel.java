package gameoflife.board;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import gameoflife.board.objects.PawnColour;
import gameoflife.board.spaces.Space;
import gameoflife.player.Player;


public class MyPanel extends JPanel {
	private int width;
	private int height;
	private int[][][] boardSpaceData;
	private int numRows;
	private int numColumns;
	private ArrayList<Player> players;
	private ArrayList<Space> spaces;
	public Color myPink;
	public Color myRed;
	public Color myBlue;
	
	/**
	 * MyPanel constructor 1, this constructor is used by the drawBoard method, does not have information about players or spaces
	 * 
	 * Some custom Colours are defined.
	 * @param width Width of a space
	 * @param height Height of a space
	 * @param boardSpaceData Board Space data is a 3 dimensional int array (int[][][]) that contains all of the space data (space num, space type and branch num).
	 * @param numRows number of Rows of spaces
	 * @param numColumns number of Columns of Spaces
	 */
	public MyPanel(int width, int height, int[][][] boardSpaceData, int numRows, int numColumns) {
		this.width = width;
		this.height = height;
		this.boardSpaceData = boardSpaceData;
		this.numRows = numRows;
		this.numColumns = numColumns;
		this.players = new ArrayList<Player>();
		this.spaces = new ArrayList<Space>();
		myPink = new Color(255,77,166);
		myRed = new Color(255, 51, 51);
		myBlue = new Color(66, 134, 244);
	}
	
	/**
	 * 
	 * MyPanel constructor 2, this constructor is used by the redrawBoard method, takes in information on the players and spaces.
	 * 
	 * Some custom colours are defined.
	 * @param width Width of a space
	 * @param height Height of a space
	 * @param boardSpaceData Board Space data is a 3 dimensional int array (int[][][]) that contains all of the space data (space num, space type and branch num).
	 * @param numRows number of Rows of spaces
	 * @param numColumns number of Columns of Spaces
	 * @param players List of Player objects
	 * @param spaces List of Space objects
	 */
	public MyPanel(int width, int height, int[][][] boardSpaceData, int numRows, int numColumns,
			ArrayList<Player> players, ArrayList<Space> spaces) {
		this.width = width;
		this.height = height;
		this.boardSpaceData = boardSpaceData;
		this.numRows = numRows;
		this.numColumns = numColumns;
		this.players = players;
		this.spaces = spaces;
		myPink = new Color(255,77,166);
		myRed = new Color(255, 51, 51);
		myBlue = new Color(66, 134, 244);
	}
	
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * 
	 * Overriding Jpanel paintComponent() method to paint the spaces on the gameboard.
	 * 
	 * Also paints Player Pawns and a legend if players is not empty
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBoardSpaces(g);
		//drawPawnLegend(g);

		if(!this.players.isEmpty()) {
			drawPawnPositions(g);
			drawPawnLegend(g);
		}
	 }
	
	/**
	 * drawBoardSpaces draws the board defined by the information in boardSpaceData.
	 * 
	 * Paints a rectangle for all spaces in boardSpaceData. Colour of the rectangle is selected based on the second element in BoardSpaceData, which is the space type (eg. Stop Spaces are Red, Payday Spaces are green.)
	 * Writes the name of the spacetype on the rectangle, also based on the second element of BoardSpaceData.
	 * Retirement Space is drawn larger than other spaces.
	 * 
	 * @param g Graphics object
	 */
	public void drawBoardSpaces(Graphics g) {
		Font defaultFont = g.getFont();
		for(int x = 0;x<numColumns;x++) {
	    	for(int y = 0;y<numRows;y++) {
	    		if(boardSpaceData[y][x][1] == 0) {
	    		    g.setColor(Color.white);
	    		} else {
	    			if(boardSpaceData[y][x][1] != 16) {
	    				g.setColor(Color.black);
			    		g.drawRoundRect((x*width)+1, (y*height)+1,width-2, height-2, 7, 7);
	    			}else {
	    				g.setColor(Color.black);
	    				g.drawRoundRect((x*width)-(width/2)+1, (y*height)-(height/2)+1, width+(width/2)-2, 2*height-2, 10,10);

	    			}
		    		switch (boardSpaceData[y][x][1]) {			
		    			case 0:
		    				break;
		    			case 1:
		    		    	g.setColor(Color.yellow);
		    				break;
		    			case 2:
		    		    	g.setColor(Color.yellow);
		    		    	break;
		    			case 3:
		    		    	g.setColor(Color.green);
		    		    	break;
		    			case 4:
		    		    	g.setColor(Color.yellow);
		    		    	break;
		    			case 5:
		    		    	g.setColor(myPink);
		    		    	break;
		    			case 6:
		    		    	g.setColor(Color.cyan);
		    		    	break;
		    			case 7:
		    		    	g.setColor(myBlue);
		    		    	break;
		    			case 8:
		    		    	g.setColor(myBlue);
		    		    	break;
		    			case 9:
		    		    	g.setColor(Color.lightGray);
		    		    	break;
		    			case 10:
		    		    	g.setColor(myRed);
		    		    	break;
		    			case 11:
		    		    	g.setColor(myRed);
		    		    	break;
		    			case 12:
		    		    	g.setColor(myRed);
		    		    	break;
		    			case 13:
		    		    	g.setColor(myRed);
		    		    	break;
		    			case 14:
		    		    	g.setColor(myRed);
		    		    	break;
		    			case 15:
		    		    	g.setColor(myRed);
		    		    	break;
		    			case 16:
		    		    	g.setColor(Color.orange);
		    		    	break;
		    			default:
		    				break;
		    		}
	    			if(boardSpaceData[y][x][1] != 16) {
	    				g.fillRoundRect((x*width)+2, (y*height)+2, width-3, height-3, 7, 7);
	    				g.setColor(Color.black);
	    				g.setFont(defaultFont);
	    				g.drawString(intToSpaceType(boardSpaceData[y][x][1]), (x*width)+4, (y*height)+(height/2)+3);

	    			} else {
	    				g.fillRoundRect((x*width)-(width/2)+2, (y*height)-(height/2)+2, width+(width/2)-3, 2*height-3, 10,10);
	    				g.setColor(Color.black);
	    				g.setFont(defaultFont.deriveFont(18f));
			    		g.drawString(intToSpaceType(boardSpaceData[y][x][1]), (x*width)-10, (y*height)+(height/2)+3);
	    			}
	    		}
	    	}
		}
	}
	
	/**
	 * drawPawnPositions draws oval's for each players pawn, based on the pawn colour they selected at the beginning of the game.
	 * 
	 * Pawn's are slightly offset in the x axis to allow multiple pawns to be displayed on the one space.
	 * @param g Graphic object
	 */
	public void drawPawnPositions(Graphics g) {
		int numPlayers = players.size();
		for(int i = 0; i<numPlayers; i++) {
			g.setColor(PawnColour.toColor(players.get(i).getPawn().getColour()));
			g.fillOval(spaces.get(players.get(i).getPawn().getSpaceNum()-1).getxpos()*width+3+i*8, spaces.get(players.get(i).getPawn().getSpaceNum()-1).getypos()*height+8, (width/2)-3, (height/2)+5);
			g.setColor(Color.black);
			g.drawOval(spaces.get(players.get(i).getPawn().getSpaceNum()-1).getxpos()*width+3+i*8, spaces.get(players.get(i).getPawn().getSpaceNum()-1).getypos()*height+8, (width/2)-3, (height/2)+5);
		}
	}
	
	/**
	 * drawPawnLegend() paints a legend in the top right corner of the board, with the name and pawn colour of every player
	 * 
	 * @param g Graphics Object
	 */
	public void drawPawnLegend(Graphics g) {
		int numPlayers = players.size();
		g.drawRect((numColumns-1)*width-45, 10, 100, numPlayers*25);
		for(int i = 0;i<numPlayers;i++) {
			g.setColor(Color.black);
			g.drawString(players.get(i).getName(), (numColumns-1)*width-10, 28+25*i);
			g.setColor(PawnColour.toColor(players.get(i).getPawn().getColour()));
			g.fillOval((numColumns-1)*width-35, 15+25*i, (width/3)-3, (height/3)+5);
			g.setColor(Color.black);
			g.drawOval((numColumns-1)*width-35, 15+25*i, (width/3)-3, (height/3)+5);
		}
	}
	
	/** 
	 * intToSpaceType() converts the int index of a space type (1-16) into a string describing that space type.
	 * 
	 * Used in drawBoardSpaces.
	 * @param spaceTypeNum Int index of SpaceType
	 * @return Returns a string of the space Type
	 */
	public String intToSpaceType(int spaceTypeNum) {
		
		String type = new String();
		
		switch(spaceTypeNum) {
		case 1:
			type = "Career";
			break;
		case 2:
			type = "College";
			break;
		case 3:
			type = "Payday!";
			break;
		case 4:
			type = "Action";
			break;
		case 5:
			type = "Holiday";
			break;
		case 6:
			type = "SpinWin";
			break;
		case 7:
			type = "Baby";
			break;
		case 8:
			type = "Twins";
			break;
		case 9:
			type = "House";
			break;
		case 10:
			type = "Graduate";
			break;
		case 11:
			type = "Marriage";
			break;
		case 12:
			type = "School";
			break;
		case 13:
			type = "Family";
			break;
		case 14:
			type = "Baby Stop";
			break;
		case 15:
			type = "Holiday";
			break;
		case 16:
			type = "Retire";
			break;
		}
		return type;
	}
}