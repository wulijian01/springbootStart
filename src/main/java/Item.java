import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@EqualsAndHashCode
public class Item {

	private String opco;
	private String cusNo;
	
	public int hashCode() {
        return 1;
    }
	
	public boolean equals(Object o) {
		
		return true;
	}
	
	public static void main(String[] args) {
		
		Item item = new Item();
		Item item1 = new Item();
		
		item.setCusNo("12");
		
		item.setOpco("23");
		
        item1.setCusNo("12");
		
		item1.setOpco("24");
		
		System.out.println(item.equals(item1));
		
		System.out.println(item.toString() +"------------" + item1.toString());
		
	}
	
}
