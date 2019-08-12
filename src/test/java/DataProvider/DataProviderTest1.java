package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest1 {
	@DataProvider(name="Authentication")
	public Object[][] getData()
	{
		return new Object[][] {{"vip212@pchmail.com","pch123"},{"res123CH@pchmail.com","pch12"}};
	}
	
	@Test(dataProvider="Authentication")
	public void Test1()
	{
		
	}
}
