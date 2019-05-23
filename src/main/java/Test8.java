import java.util.ArrayList;
import java.util.List;


public class Test8 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>() {
			{
				add(1);
				add(5);
				add(3);
				add(9);
				add(12);
			}
		};
		
//		int sum = list.stream().mapToInt(Integer::intValue).max().getAsInt();
//		System.out.println(sum);

//		List<Integer> collect = list.stream().sorted((t1,t2)-> -(t1-t2)
//			
//		).collect(Collectors.toList());
//		
//		System.out.println(Arrays.toString(collect.toArray()));

//		Optional<Integer> reduce = list.stream().reduce(Integer :: sum);

//		Optional<List<Integer>> li = Optional.ofNullable(list);
//		List<Integer> orElse = li.orElseGet(()->new ArrayList<Integer>());
//		System.out.println(orElse.toString());

//		long[] number= {1L,2L,3L,4L,5L,6L,7L,8L,9L,10L,11L};
//		Fork fork = new Fork(number);
//		Long compute = fork.compute();
//		System.out.println(compute);

		/**
		 * map test
		 */
//		Item item = new Item();
//		item.setCusNo("12");item.setOpco("21");
//		Item item1 = new Item();
//		item1.setCusNo("22");item1.setOpco("21");
//		List<Item> list2 = new ArrayList<Item>() {{
//			add(item);
//			add(item1);
//		}};
//		
//		Map<String, String> collect = list2.stream().collect(Collectors.toMap(Item::getOpco, Item::getCusNo, (x, y) -> x +","+ y));
//		
//		Map<String, String> collect2 = list2.stream().collect(Collectors.groupingBy(Item::getOpco,Collectors.mapping(Item::getCusNo,Collectors.joining(","))));	
//		System.out.println(collect.values());	
	}

//	@SuppressWarnings("finally")
//	private static Object get1() {
//		String a = "12";
//
//		try {
//			return a;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				a = "23";
//				System.exit(0);
//				return a;
//				
//			} finally {
//				a="34";
//				return a;
//			}
//		}
////		return a;
//
//	}
}
