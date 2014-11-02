/**
 * @(#) MenuItem.java
 */
public abstract class MenuItem
{
	protected String name;
	protected QualityLevel qualityLevel;

	
	public MenuItem( String name ){
		this.name = name;
		qualityLevel = QualityLevel.LOW;
	}
	
	public abstract double calculateIngredientCost( );
	public abstract double getPrice();
	
	
	public void setQualityLevel( QualityLevel qualityLevel ) {
		this.qualityLevel = qualityLevel;
	}
	
}
