/**
 * 
 */
package compareDataTypes;

/**
 * @author Jason Hutson
 *
 */
public interface DataType {

	boolean addElement(String newValue);
	
	boolean removeElement (String value);
	
	boolean findElement (String query);
	
	int getSize();
	
	String getType();
	
}
