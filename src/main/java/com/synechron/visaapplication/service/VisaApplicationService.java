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
        KieSession session =  kieContainer.newKieSession("PassportValidation");

        List<Passport> passportList = ApplicationRepository.getPassports();
        passportList.forEach(session::insert);
        session.fireAllRules();

        session.dispose();
        passportList.forEach(passport -> {System.out.println("Passport: "+passport + " valid: "+passport.getValidation());});

        System.out.println("========================================");
        passportList.forEach(passport -> System.out.println(passport.getCause()));
    }

}
