package com.synechron.visaapplication;

import com.synechron.visaapplication.service.TaxiFareCalculatorService;
import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Ignore
public class TaxiFareCalculatorServiceTest {

  /*  @Autowired
    TaxiFareCalculatorService taxiFareCalculatorService;
    @Test
    public void whenNightSurchargeFalseAndDistLessThan10_thenFixWithoutNightSurcharge() {
        TaxiRide taxiRide = new TaxiRide();
        taxiRide.setNightSurcharge(false);
        taxiRide.setDistanceInMile(9L);
        Fare rideFare = new Fare();
        Long totalCharge = taxiFareCalculatorService.calculateFare(taxiRide, rideFare);

        Assertions.assertThat(Long.valueOf(70)).isEqualTo(totalCharge);
        System.out.println(totalCharge);
    }*/
}
