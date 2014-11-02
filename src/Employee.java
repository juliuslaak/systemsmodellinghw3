public abstract class Employee
{
	public String name;
	
	public String surname;
	
	public LevelOfExperience experience;
	
	public abstract float computePay( );
	
	public float payWeeklySalaries( )
	{
		return 0;
	}
	
	public void raiseEmployeeExperience( );
	
	public int increaseWage( )
	{
		return 0;
	}
	
	
}
