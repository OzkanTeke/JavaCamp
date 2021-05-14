
public class StarbucksCustomerManager extends BaseCustomerManager {

	private ICustomerCheckService _customerCheckService;

	public StarbucksCustomerManager(ICustomerCheckService _customerCheckService) {
		this._customerCheckService = _customerCheckService;
	}

	@Override
	public void save(Customer customer) {

		if (_customerCheckService.CheckIfPerson(customer)) {
			System.out.println("Saved to db " + customer.firstname);
		} else {
			System.out.println("Not a valid person");
		}

	}

}
