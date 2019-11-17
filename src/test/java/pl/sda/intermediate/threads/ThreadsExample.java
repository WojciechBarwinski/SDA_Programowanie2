package pl.sda.intermediate.threads;

import org.junit.jupiter.api.Test;

public class ThreadsExample {

    @Test
    void runnableBasics() {
        Runnable ourRunnable = new OurRunnable(); //praca do wykonania

        Runnable anonymousRunnable = new Runnable() { //implementacja klasy anonimowej
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " klasa anonimowa");
            }
        };

        Runnable lambdaRunnable = ()-> System.out.println(Thread.currentThread().getName() + " lambda Runnable");


        ourRunnable.run(); //wykonanie prracy w wątku main

        Thread t1 = new Thread(ourRunnable); //nowy pracownik z przekazaną pracą do wykonania
        Thread t2 = new Thread(anonymousRunnable);
        Thread t3 = new Thread(lambdaRunnable);

        //t1.run(); // to spowoduje uruchomienie pracyw AKTUALNYM wątku (w tym przypadku main)
        t1.start();
        t2.start();
        t3.start();
    }
}
