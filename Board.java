import java.awt.Color;
import java.awt.Graphics2D;

public class Board implements Controllable
{
	
	public Tile tiles[];
	private Dot d = new Dot();
	private Paddle p = new Paddle();
	
	public Board()
	{
		
		tiles = new Tile[240/16*240/16];
		
		for(int i = 0; i < tiles.length; i++)
		{
			tiles[i] = new Tile();
			
			if(i / 15 < 6)
			{
				tiles[i].type = (int)(Math.random() * 4);
				tiles[i].x1 = (i % 15) * 16;
				tiles[i].x2 = (i % 15 + 1) * 16;
				tiles[i].y1 = i / 15 * 16;
				tiles[i].y2 = (i / 15 + 1) * 16;
			}
			
		}
	}
	
	@Override
	public void update()
	{
		d.move(this);
		System.out.println(d.getX() + "," + d.getY());
	}

	@Override
	public void render(Graphics2D g)
	{
		
		for(int i = 0; i < tiles.length; i++)
		{
			int b = tiles[i].type;
			
			if(b < 1)
				g.setColor(Color.BLACK);
			else if(b == 1)
				g.setColor(Color.BLUE);
			else if(b == 2)
				g.setColor(Color.GREEN);
			else if(b == 3)
				g.setColor(Color.YELLOW);
			
			g.fillRect((i % 15) * 16, (i / 15) * 16, 16, 16);	
		}
		
		g.setColor(Color.RED);
		g.fillRect(d.getX() - 1, d.getY() - 1, 3, 3);
		g.setColor(Color.WHITE);
		g.fillRect(p.getX(), 220, 32, 12);
	}

}
