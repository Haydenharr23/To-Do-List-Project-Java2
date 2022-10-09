import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.ListDetails;
import model.Task;
import model.User;

/**
 * Hayden Harris - CIS175 
 * DMACC FALL 2022
 * Oct 6, 2022
 */
public class ListDetailsTester {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		User cameron = new User("Cameron");
		
		//ShopperHelper sh = new ShopperHelper();
		
		//sh.insertShopper(cameron);
		
		Task shampoo = new Task("Groceries", "Monday");
		Task brush = new Task("Target Visit", "Monday");
		
		List<Task> cameronsItems = new ArrayList<Task>();
		cameronsItems.add(shampoo);
		cameronsItems.add(brush);
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListDetails cameronList = new ListDetails("Cameron's List", LocalDate.now(), cameron);
		cameronList.setListOfItems(cameronsItems);
		
		ldh.insertNewListDetails(cameronList);
		
		List<ListDetails> allLists = ldh.getLists();
		
		for(ListDetails a : allLists) {
			System.out.println(a.toString());
		}
	}
}
