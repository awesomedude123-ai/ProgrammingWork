package Seller;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class cartFilter implements Comparator<sellerItem>{
	static sellerItem item1=new sellerItem();
	static List<sellerItem> cool=Arrays.asList(
			new sellerItem(),
			new sellerItem(),
			new sellerItem(),
			new sellerItem(),
			new sellerItem(),
			new sellerItem(),
			new sellerItem(),
			new sellerItem(),
			new sellerItem(),
			new sellerItem()
			);
	static Collection<sellerItem> cart=Arrays.asList(
			new sellerItem(),
			new sellerItem(),
			new sellerItem(),
			new sellerItem(),
			new sellerItem(),
			new sellerItem(),
			new sellerItem(),
			new sellerItem(),
			new sellerItem(),
			new sellerItem()
			);
	public static void main(String[] args) {
		operation1(cool);
	}

	
	public static void operation1(List<sellerItem> c) {
		Map<String, List<sellerItem>> fill=c.stream().collect(Collectors.groupingBy(sellerItem :: getShopId));
		System.out.println(fill);
		long a=c.stream().count();
		System.out.println(a);
	}//end method


	@Override
	public int compare(sellerItem o1, sellerItem o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}//end class
//Container
