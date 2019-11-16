package pl.sda.intermediate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ArrayListVsHashSet {

    List<Long> list = createList();
    Set<Long> set = createSet();

    @RepeatedTest(1000)
    @Disabled
    void arrayList() {
        System.out.println(list.contains(9_999_999L));
    }

    private List<Long> createList() {
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            list.add((long) i);
        }
        return list;
    }

    @RepeatedTest(1000)
    @Disabled
    void hashSet() {
        System.out.println(set.contains(9_999_999L));
    }

    private Set<Long> createSet() {
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < 10_000_000; i++) {
            set.add((long) i);
        }
        return set;
    }

    @Test
    @Disabled
    void removeAll() {
        System.out.println("Teraz sety");
        List<Long> list = createList();
        Set<Long> set = createSet();
        list.removeAll(set);

        System.out.println("Teraz listy");
        List<Long> list1 = createList();
        List<Long> list2 = createList();
        list1.removeAll(list2);
    }
}
