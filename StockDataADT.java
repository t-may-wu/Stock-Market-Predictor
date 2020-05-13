package project2;

public interface StockDataADT 
{	
	public int getStockCount();
	public int getWeekCount();
	public Week getStocksWeek(int stockIndex, int weekIndex);
	public String getStockName(int index);
	public String getWeekDate(int weekIndex);
	public String getStockSymbol(int index);
}
