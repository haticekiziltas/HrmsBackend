package kodlamaio.hrmsdemo.core.utilities.helpers;

import kodlamaio.hrmsdemo.dataAccess.abstracts.EducationDao;
import kodlamaio.hrmsdemo.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrmsdemo.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrmsdemo.dataAccess.abstracts.TalentDao;
import kodlamaio.hrmsdemo.entities.concretes.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvHelper implements CvHelperService {
    private EducationDao educationDao;

    private TalentDao talentDao;

    private LanguageDao languageDao;

    private JobExperienceDao jobExperienceDao;

    public CvHelper(EducationDao educationDao, TalentDao talentDao, LanguageDao languageDao,
                    JobExperienceDao jobExperienceDao) {
        super();
        this.educationDao = educationDao;
        this.talentDao = talentDao;
        this.languageDao = languageDao;
        this.jobExperienceDao = jobExperienceDao;
    }


    public void setAllCvId(List<Education> edu, List<Language> lang, List<Talent> talent, List<JobExperience> exp, Cv cv) {
        setCvEId(edu, cv);
        setCvLId(lang, cv);
        setCvTId(talent, cv);
        setCvJId(exp, cv);
    }

    private void setCvEId(List<Education> mapResume, Cv cvv) {
        if (mapResume == null) {

        } else {
            for (Education data : mapResume) {
                data.setCv(cvv);
                this.educationDao.save(data);
            }
        }


    }

    private void setCvLId(List<Language> mapResume, Cv cvv) {
        if (mapResume == null) {

        } else {

            for (Language data : mapResume) {
                data.setCv(cvv);
                this.languageDao.save(data);
            }
        }
    }


    private void setCvTId(List<Talent> mapResume, Cv cvv) {
        if (mapResume == null) {

        } else {

            for (Talent data : mapResume) {
                data.setCv(cvv);
                this.talentDao.save(data);
            }
        }
    }

    private void setCvJId(List<JobExperience> mapResume, Cv cvv) {
        if (mapResume == null) {

        } else {

            for (JobExperience data : mapResume) {
                data.setCv(cvv);
                this.jobExperienceDao.save(data);
            }
        }

    }
}