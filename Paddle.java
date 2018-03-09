
public class Paddle {

	private double x, dx;
	
	public Paddle()
	{
		x = 104;
		dx = 0;
	}
	
	public int getX()
	{
		return (int)x;
	}
	
	public void accelerateLeft()
	{
		dx -= 0.3;
		
		if(dx < -3)
		{
			dx = -3;
		}
		
	}
	
	public void accelerateRight()
	{
		dx += 0.3;
		
		if(dx > 3)
		{
			dx = 3;
		}
		
	}
	
}
