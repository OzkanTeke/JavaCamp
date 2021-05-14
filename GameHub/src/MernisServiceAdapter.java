import java.rmi.RemoteException;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements GamerCheckService{

	@Override
	public boolean CheckIfRealPerson(Gamer gamer) {
		
		KPSPublicSoap client = new KPSPublicSoapProxy();
		try {
			return client.TCKimlikNoDogrula(Long.parseLong(gamer.nalionalityId), gamer.firstName.toUpperCase(), 
					gamer.lastName.toUpperCase(), gamer.birthYear);
		} catch (RemoteException e) {
			return false;
		}
	}

}
