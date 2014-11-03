import com.sun.xml.internal.org.jvnet.fastinfoset.stax.LowLevelFastInfosetStreamWriter;

public class Dish extends MenuItem
{
    private final static double LOW_INGREDIENT_COST = 3;
    private final static double HIGH_INGREDIENT_COST = 10;
    
    public static double lowQualityPrice = LOW_INGREDIENT_COST;
    public static double highQualityPrice = HIGH_INGREDIENT_COST;
	private int calorieCount;
	
	public Dish( String name, int calorieCount ) {
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
}
