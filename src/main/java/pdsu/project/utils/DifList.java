package pdsu.project.utils;

import java.util.ArrayList;
import java.util.List;

public class DifList {
	public static <T> List<T> compare(ArrayList<T> t1, ArrayList<T>  t2){    
		List<T> list2 = new ArrayList<T>(); 
		for (T t : t2) {
			if (!t1.contains(t)) { 
				list2.add(t);     
				}    
			}    
		return list2;
		}
}
