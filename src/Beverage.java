public class Beverage extends MenuItem
{
    private final static double LOW_INGREDIENT_COST = 1;
    private final static double HIGH_INGREDIENT_COST = 3;
    
	public static double lowQualityPrice = LOW_INGREDIENT_COST;
    public static double highQualityPrice = HIGH_INGREDIENT_COST;
	private double volume;
	
	public Beverage( String name, double volume ) {
		super(name);
		this.volume = volume;
	}

	@Override
	public double calculateIngredientCost( ) {
		if(qualityLevel.equals(QualityLevel.HIGH)){
			return HIGH_INGREDIENT_COST;
		}else{
			return LOW_INGREDIENT_COST;
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

		
}