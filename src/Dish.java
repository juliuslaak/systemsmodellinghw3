public class Dish extends MenuItem
{
    
	public static double lowQualityPrice;
    public static double highQualityPrice;
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
	public double getPrice() {
		if(qualityLevel.equals(QualityLevel.LOW)){
			return lowQualityPrice;
		}else{
			return highQualityPrice;
		}
	}
}
