package gameoflife.board;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

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
	}
	
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
	}
	
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBoardSpaces(g);
		//drawPawnLegend(g);

		if(!this.players.isEmpty()) {
			drawPawnPositions(g);
			drawPawnLegend(g);
		}
	 }
	
	public void drawBoardSpaces(Graphics g) {
		for(int x = 0;x<numColumns;x++) {
	    	for(int y = 0;y<numRows;y++) {
	    		if(boardSpaceData[y][x][1] == 0) {
	    		    g.setColor(Color.white);
	    		} else {
	    			if(boardSpaceData[y][x][1] != 16) {
	    				g.setColor(Color.black);
			    		g.drawRect((x*width)+1, (y*height)+1,width-2, height-2);
	    			}else {
	    				g.setColor(Color.black);
			    		g.drawRect((x*width)-(width/2)+1, (y*height)-(height/2)+1, width+(width/2)-2, 2*height-2);

	    			}
		    		switch (boardSpaceData[y][x][1]) { //Need to edit for all 15 different space types. Maybe add text to each space type?
		    										//Start and retirement spaces orange (1, 2, 15)
		    										//Payday space green (3)
		    										//Action spaces yellow (4)
		    										//Holiday spaces cyan (5)
		    										//SpinToWin spaces pink (6)
		    										//Baby spaces magenta (7)
		    										//House spaces light grey (8)
		    										//Stop spaces red (9-14)			
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
		    		    	g.setColor(Color.blue);
		    		    	break;
		    			case 8:
		    		    	g.setColor(Color.blue);
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
		    		    	g.setColor(Color.red);
		    		    	break;
		    			case 16:
		    		    	g.setColor(Color.orange);
		    		    	break;
		    			default:
		    				break;
		    		}
	    			if(boardSpaceData[y][x][1] != 16) {
	    				g.fillRect((x*width)+2, (y*height)+2, width-3, height-3);
	    				g.setColor(Color.black);
			    		g.drawString(Integer.toString(boardSpaceData[y][x][0]), (x*width)+(width/2)-4, (y*height)+(height/2)+3);

	    			} else {
	    				g.fillRect((x*width)-(width/2)+2, (y*height)-(height/2)+2, width+(width/2)-3, 2*height-3);
	    				g.setColor(Color.black);
			    		g.drawString(Integer.toString(boardSpaceData[y][x][0]), (x*width)+4, (y*height)+(height/2)+3);
	    			}
	    		}
	    	}
		}
	}
	
	public void drawPawnPositions(Graphics g) {
		int numPlayers = players.size();
		for(int i = 0; i<numPlayers; i++) {
			g.setColor(PawnColour.toColor(players.get(i).getPawn().getColour()));
			g.fillOval(spaces.get(players.get(i).getPawn().getSpaceNum()).getxpos()*width+3+i*8, spaces.get(players.get(i).getPawn().getSpaceNum()).getypos()*height+8, (width/2)-3, (height/2)+5);
			g.setColor(Color.black);
			g.drawOval(spaces.get(players.get(i).getPawn().getSpaceNum()).getxpos()*width+3+i*8, spaces.get(players.get(i).getPawn().getSpaceNum()).getypos()*height+8, (width/2)-3, (height/2)+5);
		}
	}
	
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
}