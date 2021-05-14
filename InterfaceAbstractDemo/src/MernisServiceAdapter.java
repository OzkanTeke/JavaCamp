import java.rmi.RemoteException;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements ICustomerCheckService{

	@Override
	public boolean CheckIfPerson(Customer customer) {
		
		KPSPublicSoap client = new KPSPublicSoapProxy();
		try {
			return client.TCKimlikNoDogrula(Long.parseLong(customer.nationalityId), customer.firstname.toUpperCase(), customer.lastname.toUpperCase(), customer.dateOfBirth);
		} catch (RemoteException e) {
			return false;
		}
	}

}
