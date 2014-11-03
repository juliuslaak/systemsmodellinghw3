public class Beverage extends MenuItem
{
	public static double lowQualityPrice;
    public static double highQualityPrice;
	private double volume;
	
	public Beverage( String name, double volume ) {
		super(name);
		this.volume = volume;
	}

	@Override
	public double calculateIngredientCost( ) {
		if(qualityLevel.equals(QualityLevel.HIGH)){
			return 3;
		}else{
			return 1;
		}
	}
		
	@Override
	public double getPrice( ) {
		if(qualityLevel.equals(QualityLevel.LOW)){
			return lowQualityPrice;
		}else{
			return highQualityPrice;
		}
	}
	

	@Override
	public void setLowQualityPrice( double price )
	{
		
	}
	
	
	@Override
	public void setHighQualityPrice( double price )
	{
		
	}
	
	
}
