public class Setup {

	
	public static void main(String[] args) {
	
	
	Portfolio testPort1;
	
	testPort1 = new Portfolio(1,"Draft Portfolio");
	
	testPort1.createStock("AAPL", 100, 4.44);
	testPort1.createStock("IBM", 200, 5.55);
	testPort1.createStock("F", 300, 6.66);
	testPort1.createStock("MSFT", 400, 7.85);
	testPort1.createStock("DELL.MX", 500, 91.91);
	testPort1.createStock("GOOG", 600, 500.89);
	testPort1.createStock("YHOO", 700,4.50);
	testPort1.createStock("SNE", 800, 1.55);
	testPort1.createStock("TM", 900, 1.65);
	testPort1.createStock("GE", 1000, 1.32);
	
	
	
	
	
	
	
	
	
	for ( Stock s : testPort1.listOfStocks)
	{
		System.out.println(s.calculateCost()+"    "+ s.getStockID());
		
	}
	

	}
	}