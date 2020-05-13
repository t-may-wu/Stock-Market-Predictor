package project2;

import java.util.*;

public class Stock 
{
	/*_________________________________________________________________________________________
	 * Variables
	 * 			ArrayList<Week> [weekData]: container for stock data over each week
	 *			private String fullName: full name of this stock
	  *			private String abbrivatedName: abbreviated name of this stock 
	 * Functions
	 * 			Stock(): constructor
	 * 			addWeek(o,h,l,c,v,pp): add week with specified values
	 * 			getWeek(weekIndex): returns week data found at the index [weekIndex]
	 *_________________________________________________________________________________________*/
	
	private ArrayList<Week> weekData;
	private String abbrevatedName;
	
	Stock(String abr){
		abbrevatedName = abr;
		weekData = new ArrayList<Week>();
	}

	public String getAbbrevatedName() {
		return abbrevatedName;
	}

	public void setAbbrevatedName(String abbrivatedName) {
		this.abbrevatedName = abbrivatedName;
	}

	// function that adds a (Week) of data to [this] (Stock)
// @param o: opening price of stock
// @param h: highest price of stock during the week
// @param l: lowest price of stock during the week
// @param c: closing price of stock
// @param v: volume of stock over week
// @param pp: the percent change in price of stock over the week
	public void addWeek(double o, double h, double l, double c, double v, double pp) 
	{
		Week current = new Week(o,h,l,c,v,pp);
		weekData.add(current);
//		System.err.println(weekData.size());
		return;
	}
	
// function that returns the (Week) of data at index [weekIndex]
// @param weekIndex: id of week to get data for	
	public Week getWeek(int weekIndex) 
	{
		if(weekIndex < 0 || weekIndex > weekData.size()) {
			return null;
		}
		return weekData.get(weekIndex);
	}

	public boolean equals (Object rhs) {
		return abbrevatedName.equals(((Stock)rhs).getAbbrevatedName());
		
	}
	public String toString () {
		return abbrevatedName +": "+weekData.toString();
	}
}
