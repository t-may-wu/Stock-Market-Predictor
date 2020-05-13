package project2;

import java.util.*;

public class Broker extends BasicPredictor
{
	/*_________________________________________________________________________________________

	 *	predict(): runs investment simulation--buys and sells stocks for each week
		uses previous week's percent price change, highest price, and lowest price (phl index)
		to predict which stocks will be the most profitable	 * 
	 _____________________________________________________________________________________*/
	

	
	Broker(){}
	
// constructor, initializes object and sets [stockData] to [data]
// @param [data]: data set to use
	Broker(StockDataADT data)
	{
		setDataSet(data);
	}
	

	
// function that runs simulation of buying and selling stocks
// uses previous week's percent price change, highest price, and lowest price (phl index)
// to predict which stocks will be the most profitable
	public void predict() 
	{
		if(stockData == null)
		{
			System.out.println("Error: broker does not have a data set. Please set the data set to use.");
			return;
		}
		
	// for each week starting at the second week
		for(int i = 1; i < stockData.getWeekCount(); i++)
		{

		// store initial value of wallet
		// and create arrays to store data for each stock
		//----later becomes # of shares bought for each stock
		// and quantity of stocks sold during week
			double init = wallet;
			double[] phls = new double[stockData.getStockCount()];
			int[] sold = new int[stockData.getStockCount()];
			
		// find phl value for each stock
			for(int j = 0; j < stockData.getStockCount(); j++) 
			{	
				phls[j] = getPhl(j, i - 1);
			}
			
		// buy stocks at current week's value
		// then sell stocks at current week's value
		// and print progress after each week
			buyStocks(phls, i);
			calculateProfit(i, sold);
			//printPort(phls, sold);
			
//			System.out.format("Week %d: %.2f + %.2f = %.2f\n", i, init, wallet - init, wallet);
		}
		
	// Print total 	% return over the quarter
		double tProf = wallet - initialM;
		double tPerc = tProf/wallet * 100;
//		System.out.format("Over one quarter you made $%.2f, a total return of %.2f%%.\n", tProf, tPerc);		
	}

	@Override
	public ArrayList<String> rankStocks(int weekIndex) {
		ArrayList<String> toReturn = new ArrayList<String>();
		Map<Double, String> map = new TreeMap<Double, String>();
		Double[] phls = new Double[stockData.getStockCount()];		
		/* Add entries to the map in any order. */

		for(int j = 0; j < stockData.getStockCount(); j++) 
		{	
			phls[j] = getPhl(j, weekIndex - 1);
			while (map.containsKey(phls[j])) {
				phls[j] += 0.1;
			}
			map.put(phls[j], stockData.getStockSymbol(j));
		}		
		/* Now, iterate over the map's contents, sorted by key. */
		for (Map.Entry<Double, String> entry : map.entrySet()) {
			toReturn.add(entry.getValue());
		}		
		// find phl value for each stock


		return toReturn;
	}
	

}
