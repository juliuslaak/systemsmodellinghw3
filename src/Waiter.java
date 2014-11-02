public class Waiter extends Employee
{
	public final int COURSE_COST = 800;
	public int nrOfTablesAssigned;
	
	public Waiter( String name, String surname ) {
		super(name, surname);
		this.nrOfTablesAssigned = 0;
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
	
}
