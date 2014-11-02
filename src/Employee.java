public abstract class Employee
{
	private String name;
	private String surname;
	protected LevelOfExperience experience;
	

	public Employee( String name, String surname ) {
		this.name = name;
		this.surname = surname;
		experience = LevelOfExperience.LOW;
	}
	
	public abstract double computePay( );
	public abstract double getCourseCost( );
	
	
	public void raiseEmployeeExperience( ) {
		if(experience.equals(LevelOfExperience.LOW)){
			experience = LevelOfExperience.MEDIUM;
		}else if(experience.equals(LevelOfExperience.MEDIUM)){
			experience = LevelOfExperience.HIGH;
		}
	}
	
	public String getName( ) {
		return name;
	}

	public String getSurname( ) {
		return surname;
	}

	public LevelOfExperience getExperience( ) {
		return experience;
	}
	
	public int increaseWage( )
	{
		return 0;
	}
	
	
}
