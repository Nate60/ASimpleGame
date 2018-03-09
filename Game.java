import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game
{
	
	public static void main(String args[]) throws Exception
	{
		JFrame window = new JFrame(); //display setup
		JPanel display = new JPanel();
		Controller c;
		int FPS = 30;
		final int SCALE = 2;
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		display.setPreferredSize(new Dimension(240 * SCALE, 240 * SCALE));
		display.setFocusable(true);
		display.requestFocus();	
		
		window.setContentPane(display);
		window.setResizable(true);
		window.pack();
		window.setVisible(true);
		
		Board b = new Board();
		c = new Controller(240,240,0,0);
		c.setInFocus(true);
		c.setActive(true);
		c.addComponent(b);
		while(display.getGraphics() == null){
			
		}
		
		long time = System.nanoTime();
		
		while(true){ //update loop
			double delta = (double)(System.nanoTime() - time)/1000000000;
			if(delta < 1.0/FPS)
			{
				long mcs = (long)((1.0/FPS - delta) * 1000);
				Thread.sleep(mcs);
				time = System.nanoTime();
			}
			else
				time = System.nanoTime();
			c.update();
			c.render();
			c.draw((Graphics2D)display.getGraphics(), SCALE);
		}
	}
	
	//public static void bounce(double[] vec, Tile rect)
	public static void bounce(Dot d, Tile rect)
	{
		double[] temp = new double[2];
		temp[0] = d.dx;
		temp[1] = d.dy;
		
		double shortest = 17;
		int shortestI = -1;
		
		if(Math.abs(rect.y1) < shortest)
		{
			shortest = Math.abs(rect.y1);
			shortestI = 0;
		}
			
		if(Math.abs(rect.x2) < shortest)
		{
			shortest = Math.abs(rect.x2);
			shortestI = 1;
		}
		
		if(Math.abs(rect.y2) < shortest)
		{
			shortest = Math.abs(rect.y2);
			shortestI = 2;
		}
		
		if(Math.abs(rect.x1) < shortest)
		{
			shortest = Math.abs(rect.x1);
			shortestI = 3;
		}
		
		if(shortestI == -1){
			System.out.print("");
		}
		
		if(shortestI == 0)
		{
			//vec[0] = vec[0] * shortest / vec[1];
			//vec[1] = shortest;
			d.dy = d.dy - 2 * d.dy;
		}
		else if(shortestI == 1)
		{
			//vec[1] = vec[1] * -shortest / vec[0];
			//vec[0] = -shortest;
			d.dx = d.dx - 2 * d.dx;
		}
		else if(shortestI == 2)
		{
			//vec[0] = vec[0] * -shortest / vec[1];
			//vec[1] = -shortest;
			d.dy = d.dy - 2 * d.dy;
		}
		else if(shortestI == 3)
		{
			//vec[1] = vec[1] * shortest / vec[0];
			//vec[0] = shortest;
			d.dx = d.dx - 2 * d.dx;
		}
		
		if(d.dx == temp[0] && d.dy == temp[1])
			System.out.println("wtf");
		
	}
	
}
