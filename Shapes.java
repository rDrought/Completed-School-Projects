// Alexander Chukwuka
// The "Shapes" class.
import java.awt.*;
import hsa.Console;

public class Shapes
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();
	int letr, x, y, width, length;

	c.println ("Enter either 1, 2, or 3 (In upper or lower case)");
	letr = c.readInt ();

	if (letr == 1)
	{
	    c.println ("Enter the starting position in the form x y");
	    x = c.readInt ();
	    y = c.readInt ();
	    c.println ("Enter the width and length respectively");
	    width = c.readInt ();
	    length = c.readInt ();
	    c.clear ();
	    c.setColor (Color.green);
	    c.fillRect (x, y, width, length);
	}
	else
	{
	    if (letr == 2)
	    {
		c.println ("Enter the starting position in the form x y");
		x = c.readInt ();
		y = c.readInt ();
		c.println ("Enter the width and length respectively");
		width = c.readInt ();
		length = c.readInt ();
		c.clear ();
		c.setColor (Color.blue);
		c.fillRect (x, y, width, length);
	    }
	    else
	    {
		if (letr == 3)
		{
		    c.println ("Enter the starting position in the form x y");
		    x = c.readInt ();
		    y = c.readInt ();
		    c.println ("Enter the width and length respectively");
		    width = c.readInt ();
		    length = c.readInt ();
		    c.clear ();
		    c.setColor (Color.red);
		    c.fillStar (x, y, width, length);
		}
		else
		{
		    c.println ("ERROR!!!!!!");
		}
	    }
	}


    } // main method
} // Shapes class
