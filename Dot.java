import java.awt.Rectangle;

public class Dot
{
	private double x,y;
	public double dx,dy;
	
	public Dot(){
		x = 120;
		y = 200;
		dy = -3;
		dx = Math.random() * 2 - 1;
	}
	
	public void move(Board b)
	{
		
		if(x + dx < 0 || (int)((x + dx) / 16) > 14)
		{
			dx *= -1;
		}
		
		if(y + dy < 0 || (int)((y + dy) / 16) > 14)
		{
			dy *= -1;
		}
		
		try
		{
			
			if(b.tiles[ (int)((y + dy) / 16.0) * 15 + (int)((x + dx) / 16.0) ].type > 0)
			{
				//System.out.println((x + dx) + "," + (y + dy) + " collides with " + (int)(x + dx)/16*16 + "," + (int)(y +dy)/16*16);
				b.tiles[(int)((y + dy) / 16.0) * 15 + (int)((x + dx) / 16.0)].type--;
				double vec[] = {dx, dy};
				Tile rect = new Tile();
				rect.x1 = b.tiles[ (int)((y + dy) / 16.0) * 15 + (int)((x + dx) / 16.0) ].x1 - x;
				rect.x2 = b.tiles[ (int)((y + dy) / 16.0) * 15 + (int)((x + dx) / 16.0) ].x2 - x;
				rect.y1 = b.tiles[ (int)((y + dy) / 16.0) * 15 + (int)((x + dx) / 16.0) ].y1 - y;
				rect.y2 = b.tiles[ (int)((y + dy) / 16.0) * 15 + (int)((x + dx) / 16.0) ].y2 - y;
				//rect.x1 -= x;
				//rect.x2 -= x;
				//rect.y1 -= y;
				//rect.y2 -= y;
				Game.bounce(this,rect);
				/*dx = vec[0];
				dy = vec[1];*/
			}
		
		}
		catch(Exception e)
		{
			
		}
			
		x += dx;
		y += dy;
	}
	
	public int getX()
	{
		return (int)x;
	}
	
	public int getY()
	{
		return (int)y;
	}
	
}
