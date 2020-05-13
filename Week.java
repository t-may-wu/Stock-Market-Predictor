package project2;


public class Week 
{

	/*_________________________________________________________________________________________
	 * Variables
	 * 			double [open]: the price of the stock at the beginning of the week
	 * 			double [high]: the highest price of the stock during the week
	 * 			double [low]: the lowest price of the stock during the week
	 * 			double [close]: the price of the stock at the close of the week
	 * 			double [volume]: the number of stocks that were bought/sold during the week
	 * 			double [percentPriceChange]: the percent change in stock price from open to close
	 * Functions
	 * 			Week(): default constructor (unused)
	 * 			Week(o,h,l,c,v,pp): constructor, initializes values for the week
	 * 			getOpen(): returns [open], the opening price
	 * 			getHigh(): returns [high], the highestest price during week
	 * 			getLow(): returns [low], the lowest price during the week
	 * 			getClose(): returns [close], the closing price
	 * 			getVolume(): returns [volume], the number of stocks that were traded
	 * 			getPerP(): returns [percentPriceChange], the percent change in stock price over the week
	 * 			toString(): returns a copy the (Week)'s data in a formatted string
	 *_________________________________________________________________________________________*/
	
	private double open;
	private double high;
	private double low;
	private double close;
	private double volume;
	private double percentPriceChange;
	
// default constructor (not used)
	Week() {};

// constructor that sets the values for each of the variables
	Week(double o, double h, double l, double c, double v, double pp) 
	{
		open = o;
		high = h;
		low = l;
		close = c;
		volume = v;
		percentPriceChange = pp;
	}
	
// Get functions--one for each variable of (Week)
	public double getOpen()		{	return open;	}
	public double getHigh()		{	return high;	}
	public double getLow()		{	return low;		}
	public double getClose()	{	return close;	}
	public double getVolume() 	{ 	return volume;	}
	public double getPerP() 	{	return percentPriceChange;	}
	
// Format [this] as a string to be printed
	public String toString() 
	{
		String result = "Open: " + open;
		result += "\tHigh: " + high;
		result += "\tLow: " + low;
		result += "\tClose: " + close;
		result += "\tVolume: " + volume;
		result += "\tPrice Change: " + percentPriceChange + "%";
		return result;
	}
	
	
}
