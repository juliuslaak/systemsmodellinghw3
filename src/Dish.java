
public class Dish extends MenuItem
{
    private static final Integer LOW_INGREDIENT_COST = 3;
    private static final Integer HIGH_INGREDIENT_COST = 10;
    
    public static Integer lowQualityPrice = LOW_INGREDIENT_COST;
    public static Integer highQualityPrice = HIGH_INGREDIENT_COST;
	private Integer calorieCount;

	public Dish( String name, Integer calorieCount ) {
		super(name);
		this.calorieCount = calorieCount;
		
	}
	
	@Override
	public Integer calculateIngredientCost( ) {
		if(qualityLevel.equals(QualityLevel.HIGH)){
			return HIGH_INGREDIENT_COST;
		}else{
			return LOW_INGREDIENT_COST;
		}
	}

	@Override
	public Integer getPrice( ) {
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
