package com.github.mkotra.algorithms;

class Message {

    private String message;

    public synchronized void waitForMessage() {
        try {
            System.out.println(Thread.currentThread().getName() + " waiting for the message...");
            wait();
            System.out.println(Thread.currentThread().getName() + " got the message: " + message);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void sendMessage(String msg) {
        this.message = msg;
        System.out.println(Thread.currentThread().getName() + " sending message...");
        notifyAll();
    }
}

public class Notify {
    public static void main(String[] args) {
        Message message = new Message();

        Thread waiter1 = new Thread(message::waitForMessage, "Waiter-1");
        waiter1.start();

        Thread waiter2 = new Thread(message::waitForMessage, "Waiter-2");
        waiter2.start();

        // Sleep to ensure waiter starts waiting before notifier sends a message
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Thread that sends a message and notifies the waiter
        Thread notifier = new Thread(() -> message.sendMessage("Hello, World!"), "Notifier");
        notifier.start();
    }
}
