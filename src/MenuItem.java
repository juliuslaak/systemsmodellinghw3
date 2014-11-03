
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
	
	public abstract Integer calculateIngredientCost( );
	public abstract Integer getPrice( );
	
	
	public void setQualityLevel( QualityLevel qualityLevel ) {
		this.qualityLevel = qualityLevel;
	}	
	
}
