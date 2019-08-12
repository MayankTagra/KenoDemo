package DataProvider;

import org.testng.annotations.Test;

public class GroupsExample {
	@Test(groups= {"car"})
	public void  GroupExample1()
	{
		System.out.println("Inisde Group Example1");
	}
	@Test(groups= {"scooter"})
	public void GroupExample2()
	{
		System.out.println("Inside GroupExample2");
	}
	@Test(groups= {"car","scooter"})
	public void GroupExample3()
	{
		System.out.println("Inside GroupExample3");
	}
	@Test(groups= {"car"})
	public void GroupExample4()
	{
		System.out.println("Inside GroupExample4");
	}

}
