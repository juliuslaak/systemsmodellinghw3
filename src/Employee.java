public abstract class Employee
{
	private String name;
	private String surname;
	LevelOfExperience experience;
	
	public Employee(String name, String surname) {
		this.name = name;
		this.surname = surname;
		experience = LevelOfExperience.LOW;
	}
	
	public abstract double computePay();
	public abstract double getCourseCost();
	
	
	public void raiseEmployeeExperience() {
		if(experience == LevelOfExperience.LOW){
			experience = LevelOfExperience.MEDIUM;
		}else if(experience == LevelOfExperience.MEDIUM){
			experience = LevelOfExperience.HIGH;
		}
	}
	

}
