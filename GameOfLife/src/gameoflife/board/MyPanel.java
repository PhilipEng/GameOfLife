package gameoflife.board;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JPanel;


public class MyPanel extends JPanel {
//	private int x1;
//	private int x2;
//	private int y1;
//	private int y2;
	private int width;
	private int height;
	private int[][][] boardSpaceData;
	private int numRows;
	private int numColumns;
	
	public MyPanel(int width, int height, int[][][] boardSpaceData, int numRows, int numColumns) {
		this.width = width;
		this.height = height;
		this.boardSpaceData = boardSpaceData;
		this.numRows = numRows;
		this.numColumns = numColumns;
		//this.x1 = x1;
		//this.y1 = y1;
		//this.x2 = x2;
		//this.y2 = y2;
		// TODO Auto-generated constructor stub
	}
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g) {
		System.out.println(Arrays.deepToString(boardSpaceData));

	    for(int x = 0;x<numColumns;x++) {
	    	for(int y = 0;y<numRows;y++) {
	    		if(boardSpaceData[y][x][1] == 0) {
	    		    g.setColor(Color.white);
	    		} else {
	    		    g.setColor(Color.black);
		    		g.drawRect((x*width)+1, (y*height)+1,width-2, height-2);
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
		    		    	g.setColor(Color.green);
		    				break;
		    			case 2:
		    		    	g.setColor(Color.cyan);
		    		    	break;
		    			case 3:
		    		    	g.setColor(Color.orange);
		    		    	break;
		    			case 4:
		    		    	g.setColor(Color.LIGHT_GRAY);
		    		    	break;
		    			case 5:
		    		    	g.setColor(Color.red);
		    		    	break;
		    			default:
		    				break;
		    		}
		    		g.fillRect((x*width)+2, (y*height)+2, width-3, height-3);
	    		    g.setColor(Color.black);
		    		g.drawString(Integer.toString(boardSpaceData[y][x][0]), (x*width)+(width/2)-4, (y*height)+(height/2)+3);

	    		}

	    	}
	    }
	    //g.fillRect(x1,y1,x2,y2);

	    
	  }
}