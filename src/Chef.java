public class Chef extends Employee
{
	public final int COURSE_COST = 1200;
	@SuppressWarnings("unused")
	private int taxCode;

	public Chef( String name, String surname, int taxCode ) {
		super(name, surname);
		this.taxCode = taxCode;
	}
	
	@Override
	public double computePay( ) {
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
		
}
