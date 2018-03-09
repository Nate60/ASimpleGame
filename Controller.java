


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Controller {

	private ArrayList<Controllable> ComponentFrames = new ArrayList<Controllable>();
	//private ArrayList<Event> eventQueue = new ArrayList<Event>();
	private int width, height, x, y;
	BufferedImage displayFrame;
	private Graphics2D g;
	private boolean active = false;
	private boolean inFocus = false;
	
	
	/**
	 * Constructor that specifies the region that the controller will draw in
	 * 
	 */
	
	public Controller(int width, int height, int x, int y){
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		displayFrame = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		g = (Graphics2D) displayFrame.createGraphics();
	}
	
	public void update(){
		
		if(active)
		
			for(Controllable c: ComponentFrames){
				
				c.update();
				
			}
		
	}
	
	public void render(){
	
		if(inFocus)
		
			for(Controllable c: ComponentFrames){
				c.render(g);
			}
		
	}
	
	public void draw(Graphics2D g2, double scale){
	
		g2.drawImage(displayFrame, (int)(x * scale), (int)(y * scale), (int)(width * scale), (int)(height * scale),null);
		
	}
	
	//MUTATORS
	
	public void addComponent(Controllable c){
		ComponentFrames.add(c);
	}
	
	public void setActive(boolean b){
		active = b;
	}
	
	public void setInFocus(boolean b){
		inFocus = b;
	}
		
}
