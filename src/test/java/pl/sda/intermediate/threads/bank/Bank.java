package pl.sda.intermediate.threads.bank;

import java.util.concurrent.atomic.AtomicInteger;


public class Bank {

    private static AtomicInteger balance = new AtomicInteger(1000);
    private static AtomicInteger counter = new AtomicInteger(0);

    public static /*synchronized*/ void deposit(int amount){ //zamiast synchronized na metodach mozna zrobic AtomicInteger na polach -> wydajniejsze
        balance.addAndGet(amount);
        counter.incrementAndGet();
        System.out.println(Thread.currentThread().getName() + ": current balance after deposit: " + balance) ;
    }

    public static /*synchronized*/ void withdraw(int amount){
        balance.addAndGet(-amount);

        System.out.println(Thread.currentThread().getName() + ": current balance after withdraw: " + balance) ;

    }

    public static int getBalance(){
        return balance.intValue();
    }

    public static int getCounter(){
        return counter.intValue();
    }




}
