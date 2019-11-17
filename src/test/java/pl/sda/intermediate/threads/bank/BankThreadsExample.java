package pl.sda.intermediate.threads.bank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BankThreadsExample {

    @Test
    void sequential() {

        for (int i = 0; i < 100; i++) {

            ClientActionRunnable clientActionRunnable = new ClientActionRunnable();
            clientActionRunnable.run();

        }
    }

    @Test
    void threads() {

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            threads.add(new Thread(new ClientActionRunnable())); //tutaj tworzymy pracowników i przekazujemy im pracę do wykonania
        }
        for (Thread thread : threads) {
            thread.start();            // tu mówimy pracownikowi, żeby zaczął działać
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Bilans na koniec akcji kredytowej: " + Bank.getBalance());
        System.out.println("Liczba operacji: " + Bank.getCounter());
    }
}
