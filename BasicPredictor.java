package project2;

import java.util.ArrayList;

/*_________________________________________________________________________________________
 * Variables
 * 			double [initialM]: the starting amount of money in the bank, by default $5000
 * 			double [wallet]: amount of cash in the bank, by default $5000
 * 			StockDataADT [stockData]: stock data organized in (Stock)s and (Week)s
 * 			ArrayList<int[]> [portfolio]: stores indexes of stocks and number of stocks owned
 * Functions

 * 			setPortfolioAmount(amount): puts [amount] number of dollars into [wallet]
 * 			getPortfolioAmount(): returns the amount in [wallet]
 * 			setDataSet(data): sets [stockData] to [data]
 * 			predict(): abstract; must be implemented by child class
 * 			buyStocks(arr, weekIndex): "buys" stocks--updates [portfolio] and [wallet]
 * 			calculateProfit(weekIndex, arr): "sells" stocks and prints progress for the week
 * 			printPort(arr, arr2): prints portfolio and stocks sold or bought during week
 * 			getStockNum(stockIndex): returns number of shares of stock # [stockIndex] owned
 * 			getStockInd(stockIndex): returns index of stock # [stockIndex] in [portfolio]
 *_________________________________________________________________________________________*/


public abstract class BasicPredictor implements PredictorADT{
	protected double initialM = 5000;
	protected double wallet = 5000;
	protected StockDataADT stockData = null;
	protected ArrayList<int[]> portfolio;

	BasicPredictor()
	{
		portfolio = new ArrayList<>();
	}	
	
	BasicPredictor(StockDataADT data)
	{
		this(); // call the other constructor
		setDataSet(data);
	}	

	public abstract void predict(); 

	// function to set initial amount of money to start with
	// @param [amount]: amount of money to start with
	public void setPortfolioAmount(double amount) 
	{
		initialM = amount;
		wallet = amount;
	}

	// function that returns current amount of money in [wallet]
	public double getPortfolioAmount() 
	{
		return Math.round(wallet*100) * 1.0 / 100;
	}

	// function that initializes or changes data set to use
	// @param [data]: data set to use
	public void setDataSet(StockDataADT data) 
	{
		stockData = data;
	}
	// function that returns phl index
	// ----phl = last week's percent price change / percent difference between 
	// ----last week's highest price and its lowest price
	// @param stockIndex: id # of stock to calculate phl for
	// @param preWeekIndex: index of previous week, whose data will be used
	protected double getPhl(int stockIndex, int prevWeekIndex) 
	{

		// get previous week's info and set default phl to zero
		Week prev = stockData.getStocksWeek(stockIndex, prevWeekIndex);
		double phl = 0.0;

		// if there exists a week prior to current week
		if(prev != null) 
		{

			// divide the percent price change by percent difference b/t high and low
			// ----multiplied by (-1) so that stocks whose price went down are prioritized
			double ppc = prev.getPerP();
			double high = prev.getHigh();
			double low = prev.getLow();
			phl = -(ppc * high) / (high - low);
		}
		return phl;
	}

	// function to buy stocks, update portfolio, and adjust money in wallet
	// @param arr: array of stocks' phl indexes
	// @param weekIndex: index of week whose data should be used
	protected void buyStocks(double[] arr, int weekIndex) 
	{

		// calculate total of positive phl indexes (down bother with negative-phl stocks)
		double num = 0;
		for(int i = 0; i < arr.length; i++) 
		{
			if(arr[i] > 0) num += arr[i];
		}

		// for each stock
		for(int i = 0; i < arr.length; i++) 
		{

			// if its phl index is positive
			if(arr[i] > 0) 
			{

				// allot money equal to the proportion of this stock's phl to the total
				// of all positive phls
				double money = (arr[i] / num) * wallet;

				// get price of stock at beginning of this week
				// and find the number of stocks one can buy with allotted money without going over
				double price = stockData.getStocksWeek(i, weekIndex).getOpen();
				int noStocks = (int)Math.floor(money / price);
				wallet = wallet - (noStocks * price);

				// set its value to the number of stocks bought this week (so we can print it out later)
				arr[i] = noStocks;

				// if we already own a number of this stock (i.e. we can find its [i] in [porfolio])
				if(getStockInd(i) != -1) {

					// add previously bought stocks to total [noStocks]
					// and remove previous entry from [portfolio]
					noStocks += getStockNum(i);
					portfolio.remove(getStockInd(i));
				}

				// create array containing info on stock Index and number of stocks owned
				// and add to [portfolio]
				int[] temp = {i, noStocks};
				portfolio.add(temp);

			}
			// if we didn't buy any of the current stock this week, change value to 0 (so we can print it out later)
			else arr[i] = 0;
		}
	}

	// function to sell stocks, update portfolio, and adjust money in wallet
	// @param weekIndex: index of week whose data should be used
	// @param arr: array to store # of shares sold for each stock
	protected void calculateProfit(int weekIndex, int[] arr)
	{

		// create variables to store profit after each sale
		// and for shares that we would like to keep 
		double profit = 0;
		ArrayList<int[]> temp = new ArrayList<int[]>();

		// while [portfolio] still has shares in it (i.e there are still more items to look at)
		while(portfolio.size() > 0)
		{
			int[] current = portfolio.remove(0);

			// only sell the stock if the price for the stock had gone up in the previous week
			// or it is the last week in the quarter
			if(stockData.getStocksWeek(current[0], weekIndex - 1).getPerP() > 0 || weekIndex == stockData.getWeekCount() - 1) {
				double price = stockData.getStocksWeek(current[0], weekIndex).getClose();
				profit += price * current[1];

				// add number of shares sold to stored array
				arr[current[0]] = current[1];
			}

			// else keep it in portfolio for later
			else temp.add(current);
		}

		// set portfolio to the list of shares kept
		// and add [profit]to [wallet]
		portfolio = temp;
		wallet += profit;
	}

	// function that prints current status of portfolio
	// plus information of which stocks were bought and sold during the week
	// @param arr: array containing the counts for each stock bought
	// @param arr2: array containing the counts for each stock sold
	protected void printPort(double arr[], int arr2[]) 
	{

		// print header
		System.out.println("Stock\tNumber");
		for(int i = 0; i < stockData.getStockCount(); i++)
		{

			// print name of stock in first column
			System.out.print(stockData.getStockName(i) + "\t");

			// if stock is in portfolio, print the # of shares owned
			// otherwise, print "-" as a placeholder
			int num = getStockNum(i);
			if(num == 0) System.out.print("-\t");
			else System.out.print(num + "\t");

			// if a stock was bought during the week, print the amount bought
			if(arr[i] != 0) System.out.print("(Bought " + (int)arr[i] + ")\t");
			else System.out.print("\t\t");

			// if a stock was sold during the week, print the amount sold
			if(arr2[i] != 0) System.out.print("(Sold " + arr2[i] + ")\t"); 
			System.out.println();
		}
	}

	// function that returns the number of stock # [stockIndex] owned
	// @param stockIndex: id number of stock to query
	protected int getStockNum(int stockIndex)
	{
		for(int i = 0; i < portfolio.size(); i++)
		{
			if(portfolio.get(i)[0] == stockIndex) return portfolio.get(i)[1];
		}
		return 0;
	}

	// function that returns the index of stock # [stockIndex] in portfolio, if it exists
	// @param stockIndex: id number of stock to query
	protected int getStockInd(int stockIndex)
	{
		for(int i = 0; i < portfolio.size(); i++)
		{
			if(portfolio.get(i)[0] == stockIndex) return i;
		}
		return -1;
	}		
}
