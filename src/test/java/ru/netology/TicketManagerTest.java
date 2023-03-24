package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {
    Repository repo = new Repository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 800, "MOW", "SBP", 60); //москва-санкт-питерург
    Ticket ticket2 = new Ticket(2, 200, "SBP", "MOW", 50); //санкт-питерург-москва
    Ticket ticket3 = new Ticket(3, 1_050, "MOW", "SMR", 20); //москва-самара
    Ticket ticket4 = new Ticket(4, 400, "MOW", "SBP", 70); //москва-санкт-питерург
    Ticket ticket5 = new Ticket(5, 700, "MOW", "SBP", 65); //москва-санкт-питерург
    Ticket ticket6 = new Ticket(6, 1_600, "SMR", "SBP", 45); //самара-санкт-питерург
    Ticket ticket7 = new Ticket(7, 1_200, "NIN", "SMR", 70); //нижний-самара
    Ticket ticket8 = new Ticket(8, 2_000, "MOW", "GOJ", 60); //москва-нижний
    Ticket ticket9 = new Ticket(9, 350, "MOW", "SBP", 60); //москва-санкт-питерург
    Ticket ticket10 = new Ticket(10, 800, "NIN", "SMR", 65); //нижний-самара
    Ticket ticket11 = new Ticket(11, 100, "MOW", "GOJ", 65); // москва-нижний новгород
    Ticket ticket12 = new Ticket(12, 400, "NIN", "SBP", 80); //нижний-санкт-питерург
    Ticket ticket13 = new Ticket(13, 350, "MOW", "SBP", 60); //москва-санкт-питерург

    @Test // Проверка отсортированых билетов от Москвы до Санкт-Петрербурга
    public void testSortTicket() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        manager.add(ticket12);
        manager.add(ticket13);

        Ticket[] expected = {ticket9, ticket13, ticket4, ticket5, ticket1};
        Ticket[] actual = manager.findAll("MOW", "SBP");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверка отсортированых билетов от от Москвы до Санкт-Петрербурга (если массив отсортирован по увеличению цены)
    public void testSortTrueTicket() {
        manager.add(ticket11);
        manager.add(ticket2);
        manager.add(ticket9);
        manager.add(ticket13);
        manager.add(ticket4);
        manager.add(ticket12);
        manager.add(ticket5);
        manager.add(ticket1);
        manager.add(ticket10);
        manager.add(ticket3);
        manager.add(ticket7);
        manager.add(ticket6);
        manager.add(ticket8);

        Ticket[] expected = {ticket9, ticket13, ticket4, ticket5, ticket1};
        Ticket[] actual = manager.findAll("MOW", "SBP");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверка отсортированых билетов от Москвы до Санкт-Петрербурга (если массив отсортирован по уменьшению цены)
    public void testSortFalseTicket() {
        manager.add(ticket8);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket3);
        manager.add(ticket10);
        manager.add(ticket1);
        manager.add(ticket5);
        manager.add(ticket12);
        manager.add(ticket4);
        manager.add(ticket13);
        manager.add(ticket9);
        manager.add(ticket2);
        manager.add(ticket11);

        Ticket[] expected = {ticket13, ticket9, ticket4, ticket5, ticket1};
        Ticket[] actual = manager.findAll("MOW", "SBP");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверка отсортированых билетов от Москвы до Санкт-Петрербурга по цене
    public void testTicketNull() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        manager.add(ticket12);
        manager.add(ticket13);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("PNZ", "SBP");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверка отсортированых билетов от от Москвы до Санкт-Петрербурга по цене
    public void testTicketOne() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        manager.add(ticket12);
        manager.add(ticket13);

        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.findAll("SBP", "MOW");
        Assertions.assertArrayEquals(expected, actual);
    }
}
