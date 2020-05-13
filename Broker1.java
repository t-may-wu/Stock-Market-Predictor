package project2;

import java.util.ArrayList;

public class Broker1 extends BasicPredictor 
{
	/*_________________________________________________________________________________________

	 *	predict(): runs investment simulation--buys and sells stocks for each week
 		uses the range of prices during the previous week to predict which 
 		stocks will be the most profitable

	 _____________________________________________________________________________________*/
	


	
	Broker1(){}

// constructor, initializes object and sets [stockData] to [data]
// @param [data]: data set to use
	Broker1(StockDataADT data)
	{
		setDataSet(data);
	}
	

// function that runs simulation of buying and selling stocks
// uses the range of prices during the previous week to predict which stocks will be the most profitable
	public void predict() 
	{
		if(stockData == null)
		{
			System.out.println("Error: broker does not have a data set. Please set the data set to use.");
			return;
		}
		
	// for each week, starting at the second week
		for(int i = 1; i < stockData.getWeekCount(); i++)
		{

		// store initial value of wallet
		// and create arrays to store data for each stock
		//----later becomes # of shares bought for each stock
		// and quantity of stocks sold during week
			double init = wallet;
			double[] range = new double[stockData.getStockCount()];
			int[] sold = new int[stockData.getStockCount()];
			
		// find the range of previous week's prices for each stock
			for(int j = 1; j < stockData.getStockCount(); j++) 
			{	
				range[j] = stockData.getStocksWeek(j, i-1).getHigh() - stockData.getStocksWeek(j, i-1).getLow();
			}
			
		// buy stocks at current week's value
		// then sell stocks at current week's value
		// and print progress after each week
			buyStocks(range, i);
			calculateProfit(i, sold);
			//printPort(range, sold);

//			System.out.format("Week %d: %.2f + %.2f = %.2f\n", i, init, wallet - init, wallet);
		}
		
	// Print total % return over the quarter
		double tProf = wallet - initialM;
		double tPerc = tProf/wallet * 100;
		//System.out.format("Over one quarter you made $%.2f, a total return of %.2f%%.\n", tProf, tPerc);	
	}

	@Override
	public ArrayList<String> rankStocks(int weekIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	

}