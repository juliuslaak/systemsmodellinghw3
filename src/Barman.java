public class Barman extends Employee
{
	private final int COURSE_COST = 1200;

	public Barman( String name, String surname ) {
		super(name, surname);
	}

	public double computePay( )
	{
		if(experience == LevelOfExperience.LOW){
			return 300;
		}else if(experience == LevelOfExperience.MEDIUM){
			return 400;
		}else{
			return 500;
		}
	}

	@Override
	public double getCourseCost( ) {
		return COURSE_COST;
	}
	

	public Beverage makeABeverage( )
	{
		return null;
	}
	
	
	public Order forwardBeverageOrder( )
	{
		return null;
	}
	
	
}
