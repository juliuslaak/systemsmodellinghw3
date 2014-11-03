public class Beverage extends MenuItem
{
    private static final double LOW_INGREDIENT_COST = 1;
    private static final double HIGH_INGREDIENT_COST = 3;
    
	public static double lowQualityPrice = LOW_INGREDIENT_COST;
    public static double highQualityPrice = HIGH_INGREDIENT_COST;
	private Integer volume;
	
	public Integer getVolume( ) {
		return volume;
	}

	public void setVolume( Integer volume ) {
		this.volume = volume;
	}

	public Beverage( String name, Integer volume ) {
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