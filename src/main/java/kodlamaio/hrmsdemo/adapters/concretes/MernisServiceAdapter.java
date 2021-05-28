package kodlamaio.hrmsdemo.adapters.concretes;

import kodlamaio.hrmsdemo.adapters.abstracts.IdentityCheckService;
import kodlamaio.hrmsdemo.entities.concretes.Candidate;
import kodlamaio.hrmsdemo.mernisservice.NKHKPSPublicSoap;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
@Service
public class MernisServiceAdapter implements IdentityCheckService<Candidate> {
    @Override
    public boolean validate(Candidate candidate) throws Exception {
        NKHKPSPublicSoap publicSoap = new NKHKPSPublicSoap();

        try {
            boolean check = publicSoap.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentificationNumber()), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate().toLocalDate().getYear());
            return check;
        } catch (NumberFormatException | RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }
}
