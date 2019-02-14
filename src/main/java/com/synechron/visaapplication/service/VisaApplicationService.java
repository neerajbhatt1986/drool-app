package com.synechron.visaapplication.service;

import com.synechron.visaapplication.domain.Passport;
import com.synechron.visaapplication.repository.ApplicationRepository;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisaApplicationService {

    public void validatePassport() {
        KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
        StatelessKieSession session =  kieContainer.newStatelessKieSession("PassportValidation");

        List<Passport> passportList = ApplicationRepository.getPassports();
        session.execute(passportList);
        passportList.forEach(passport -> {System.out.println("Passport: "+passport + " valid: "+passport.getValidation());});
    }

}
