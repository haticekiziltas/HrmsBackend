package kodlamaio.hrmsdemo.dataAccess.abstracts;

import kodlamaio.hrmsdemo.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer> {

    List<Candidate> findAllByEmailAdress(String email);

    boolean existsByIdentificationNumber(String Tc);

}
