public class Waiter extends Employee
{
	public final int COURSE_COST = 800;

	
	private java.util.List<Table> table;
	
	public Waiter( String name, String surname ) {
		super(name, surname);
	}

	public double computePay( )
	{
		if(experience == LevelOfExperience.LOW){
			return 200;
		}else if(experience == LevelOfExperience.MEDIUM){
			return 300;
		}else{
			return 400;
		}
	}
	
	@Override
	public double getCourseCost( ) {
		return COURSE_COST;
	}

	public void receiveOrder( )
	{
		
	}
	
	
	public void SendWaiterToTable( )
	{
		
	}
	
	
	public void associateWithTable( Table table )
	{
		
	}
	
	
}
