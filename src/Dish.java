public class Dish extends MenuItem
{
    
	private static double lowQualityPrice;
    private static double highQualityPrice;
	private int calorieCount;
	
	public Dish( String name, int calorieCount ) {
		super(name);
		this.calorieCount = calorieCount;
	}
	
	@Override
	public double calculateIngredientCost( ) {
		if(qualityLevel.equals(QualityLevel.HIGH)){
			return 10;
		}else{
			return 3;
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
