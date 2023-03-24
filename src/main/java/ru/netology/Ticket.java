package ru.netology;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String from;
    private String to;
    private int timeInMinutes;

    public Ticket(int id, int price, String from, String to, int timeInMinutes) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.timeInMinutes = timeInMinutes;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getTimeInMinutes() {
        return timeInMinutes;
    }

    @Override
    public int compareTo(Ticket o) {
        return price - o.price;
    }
}
