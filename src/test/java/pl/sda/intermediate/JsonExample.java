package pl.sda.intermediate;


import com.google.gson.Gson;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import pl.sda.intermediate.customers.Customer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonExample {


    @Test
    public void serializeJson() {
        List<OtherObject> otherObjectList = new ArrayList<>();
        OtherObject otherObject = new OtherObject();
        otherObject.setId(1);
        otherObject.setText("txt");
        otherObjectList.add(otherObject);

        Map<Integer, String> someMap = new HashMap<>();
        someMap.put(3, "coś");

        SomeObject someObject = new SomeObject();
        someObject.setAge(10);
        someObject.setItTrue(true);
        someObject.setList(otherObjectList);
        someObject.setMap(someMap);
        someObject.setName("Jason");
        someObject.setSalary(BigDecimal.valueOf(250.3));

        Gson gson = new Gson();
        String toJson = gson.toJson(someObject);
        System.out.println(toJson);

        SomeObject object = gson.fromJson(toJson, SomeObject.class);
        System.out.println(object);

    }

    @Setter
    private class SomeObject {
        private String name;
        private int age;
        private BigDecimal salary;
        private List<OtherObject> list;
        private Map<Integer, String> map;
        private boolean isItTrue;
    }

    @Setter
    private class OtherObject {
        private int id;
        private String text;

    }

    private class RatesWrapper {

        private String table;
        private String no;
        private String effectiveDate;
        private List<Rate> rates;
    }

    private class Rate {
        private String currency;
        private String code;
        private BigDecimal mid;
    }

}

