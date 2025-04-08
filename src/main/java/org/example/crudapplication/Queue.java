package org.example.crudapplication;

public class Queue {
    private Node front, rear;

    private class Node {
        Appointment data;
        Node next;

        Node(Appointment data) {
            this.data = data;
        }
    }

    public void enqueue(Appointment appointment) {
        Node node = new Node(appointment);
        if (rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    public Appointment dequeue() {
        if (front == null) return null;
        Appointment data = front.data;
        front = front.next;
        if (front == null) rear = null;
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
