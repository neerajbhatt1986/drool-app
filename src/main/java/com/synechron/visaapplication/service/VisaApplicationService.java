package com.synechron.visaapplication.service;

import com.synechron.visaapplication.domain.*;
import com.synechron.visaapplication.repository.ApplicationRepository;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.Agenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class VisaApplicationService {

    public void validatePassport() {
        KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
        KieSession session =  kieContainer.newKieSession("PassportValidation");

        List<Passport> passportList = ApplicationRepository.getPassports();
        passportList.forEach(session::insert);
        List<VisaApplication> visaApplications = ApplicationRepository.getVisaApplications();
        visaApplications.forEach(session::insert);

        Agenda agenda = session.getAgenda();
        agenda.getAgendaGroup("issue-visa").setFocus();
        agenda.getAgendaGroup("valid-visa-application").setFocus();
        agenda.getAgendaGroup("invalid-visa-application").setFocus();
        agenda.getAgendaGroup("valid-passport").setFocus();
        agenda.getAgendaGroup("invalid-passport").setFocus();
        session.fireAllRules();

        session.dispose();

        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        /*passportList.forEach(passport -> {System.out.println("Passport: "+passport + " valid: "+passport.getValidation());});

        visaApplications.forEach(visaApplication -> {
            System.out.println("Visa Application : "+visaApplication+" stats is "+visaApplication.getValidation());
        });*/


        System.out.println("Invalid visa Applicaiton");
       session.getObjects(o -> o.getClass() == InvalidVisaApplication.class).forEach(System.out::println);
        System.out.println("Valid visa Applicaiton");
        session.getObjects(o -> o.getClass() == ValidVisaApplication.class).forEach(System.out::println);
        System.out.println("Valid Passprot");
       session.getObjects(o -> o.getClass() == ValidPassport.class).forEach(System.out::println);
        System.out.println("Invalid Passprot");
       session.getObjects(o -> o.getClass() == InvalidPassport.class).forEach(System.out::println);
        System.out.println("Visa from the session");
       session.getObjects(o -> o.getClass() == Visa.class).forEach(System.out::println);

    }

}
