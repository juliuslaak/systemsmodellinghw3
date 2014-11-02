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
	public abstract void setLowQualityPrice( double price );
	public abstract void setHighQualityPrice( double price );
	
	public void setQualityLevel( QualityLevel qualityLevel ) {
		this.qualityLevel = qualityLevel;
	}
	
}
