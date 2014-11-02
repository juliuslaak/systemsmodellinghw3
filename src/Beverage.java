public class Beverage extends MenuItem
{
	private static double lowQualityPrice;
    private static double highQualityPrice;
	public double volume;
	
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
	public void setLowQualityPrice(double price) {
		lowQualityPrice = price;
	}

	@Override
	public void setHighQualityPrice(double price) {
		highQualityPrice  = price; 
		
	}
	
}
