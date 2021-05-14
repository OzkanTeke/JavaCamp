
public class Main {

	public static void main(String[] args) {
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
		Customer customer1 = new Customer(1, "Engin", "Demiroð", 1985, "28861499108");
		
		Customer customer2 = new Customer(1, "Özkan", "Teke", 1993, "61141789624");

		customerManager.save(customer1);
		customerManager.save(customer2);
		
		System.out.println();

	}

}
