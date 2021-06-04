package kodlamaio.hrmsdemo.core.utilities.helpers;

import kodlamaio.hrmsdemo.entities.concretes.*;

import java.util.List;

public interface CvHelperService {
    public void setAllCvId(List<Education> edu, List<Language> lang, List<Talent> talent, List<JobExperience> exp, Cv cv);
}
