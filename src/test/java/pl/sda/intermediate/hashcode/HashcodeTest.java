package pl.sda.intermediate.hashcode;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class HashcodeTest {

    @Test
    void constantHash() {

         CarConstantHashcode c1 = new CarConstantHashcode("Audi A7");
         CarConstantHashcode c2 = new CarConstantHashcode("Audi A7");
         CarConstantHashcode c3 = new CarConstantHashcode("Audi A7");
         CarConstantHashcode c4 = new CarConstantHashcode("Audi A7");
         CarConstantHashcode c5 = new CarConstantHashcode("Audi A7");
         CarConstantHashcode c6 = new CarConstantHashcode("Audi A7");


        Set<CarConstantHashcode> carSet = new HashSet<>();
        carSet.add(c1);
        carSet.add(c2);
        carSet.add(c3);
        carSet.add(c4);
        carSet.add(c5);
        carSet.add(c6);

        System.out.println(carSet.size());
    }

    @RepeatedTest(100)
    void randomHash() {

        CarRandomHashCode c1 = new CarRandomHashCode("Audi A7");
        CarRandomHashCode c2 = new CarRandomHashCode("Audi A7");
        CarRandomHashCode c3 = new CarRandomHashCode("Audi A7");
        CarRandomHashCode c4 = new CarRandomHashCode("Audi A7");
        CarRandomHashCode c5 = new CarRandomHashCode("Audi A7");
        CarRandomHashCode c6 = new CarRandomHashCode("Audi A7");


        Set<CarRandomHashCode> carSet = new HashSet<>();
        carSet.add(c1);
        carSet.add(c2);
        carSet.add(c3);
        carSet.add(c4);
        carSet.add(c5);
        carSet.add(c6);

        System.out.println(carSet.size());
    }

}
