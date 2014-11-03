
public class Dish extends MenuItem
{
    private static final double LOW_INGREDIENT_COST = 3;
    private static final double HIGH_INGREDIENT_COST = 10;
    
    public static double lowQualityPrice = LOW_INGREDIENT_COST;
    public static double highQualityPrice = HIGH_INGREDIENT_COST;
	private Integer calorieCount;

	public Dish( String name, Integer calorieCount ) {
		super(name);
		this.calorieCount = calorieCount;
		
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

	public Integer getCalorieCount( ) {
		return calorieCount;
	}

	public void setCalorieCount( Integer calorieCount ) {
		this.calorieCount = calorieCount;
	}
	
}
