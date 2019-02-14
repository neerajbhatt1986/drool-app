package com.synechron.visaapplication;

import com.synechron.visaapplication.service.VisaApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisaApplicationServiceTest {

    @Autowired
    VisaApplicationService visaApplicationService;


    @Test
    public void validatingPassport(){
        visaApplicationService.validatePassport();
    }
}
