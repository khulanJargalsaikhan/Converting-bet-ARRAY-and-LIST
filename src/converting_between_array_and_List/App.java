package converting_between_array_and_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		//---------------------------
		//Turning ArrayList to Array
		//---------------------------
		
		List<String> list = new ArrayList<>();
		list.add("hawk");
		list.add("robin");
		Object[] objectArray = list.toArray();
		//the advantage of specifying a size of 0 for the parameter is that Java
		//will create a new array of the proper size for the return value.
		String[] stringArray = list.toArray(new String[0]);
		list.clear();
		System.out.println(objectArray.length);  //2
		System.out.println("objectArray: " + Arrays.toString(objectArray));
		System.out.println(stringArray.length);   //2
		System.out.println("stringArray: " + Arrays.toString(stringArray));
		//list.clear() doesn't affect either array
		//this shows that the array is a newly created object with no relationship 
		//to the original to the original List.
		System.out.println("list: " + list);
		
		
		
		//----------------------------------
		//Converting from an Array to a List
		//----------------------------------
		
		//OPTION 1: to create a List that is linked to the original array. 
		//It is fixed-size and when a change is made to one, it is available in the other.
		
		String[] array = { "hawk", "robin" };
		List<String> list1 = Arrays.asList(array);   //returns fixed size list
		System.out.println(list.size());  //2
		list1.set(1,"test");   //[hawk, test]
		array[0] = "new"; //[new,test]
		System.out.println(Arrays.toString(array)); //[new, test]
		System.out.println(list1);
		//throws exception bc we are not allowed to change the size of the list
		list1.remove(0);    //throws UnsupportedOperationException
		
		
		
		
		//OPTION 2: to create an immutable List.
		//cannot change the values or the size of the list. 
		//you can change the original array, but changes will not be reflected 
		//in the immutable List. 
		
		String[] array2 = { "hawk", "robin" };
		List<String> list2 = List.of(array2);  //returns immutable list
		System.out.println(list2.size()); //2
		array2[0] = "new";
		System.out.println(Arrays.toString(array2));  //[new, robin]
		System.out.println(list2); //[hawk, robin]
		
		//this is bc it is an immutable copy of the original array. 
		//this shows that changing a list value in an immutable list is not allowed.
		list2.set(1, "test"); //throws UnsupportedOperationException
		
		
		//-----------------------------
		//Using Varargs to Create a List  (this is a cool way)
		//------------------------------
		List<String> list3 = Arrays.asList("one", "two");
		List<String> list4 = List.of("one", "two");
		
		/*Note: both methods create fixed-size arrays.
		 * If you need to add or remove elements, you will need to create an ArrayList 
		 * using the constructor
		 */
		
		List<String> fixedSizeList = Arrays.asList("a", "b", "c");
		List<String> expandableList = new ArrayList<>(fixedSizeList);
		
		fixedSizeList.add("d"); //throws UnsupportedOperationException
		expandableList.add("d");
		
		System.out.println(expandableList);
		

	}

}
