package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    Repository repo = new Repository();

    Ticket ticket1 = new Ticket(1, 800, "MOW", "IST", 330); //москва-стамбул
    Ticket ticket2 = new Ticket(2, 10_800, "IST", "MOW", 300); //стамбул-москва
    Ticket ticket3 = new Ticket(3, 10_050, "MOW", "BAK", 180); //москва-баку
    Ticket ticket4 = new Ticket(4, 10_400, "MOW", "IST", 350); //москва-стамбул
    Ticket ticket5 = new Ticket(5, 10_700, "MSK", "IST", 340); //москва-стамбул
    Ticket ticket6 = new Ticket(6, 5_600, "AER", "LED", 200); //сочи-питер
    Ticket ticket7 = new Ticket(7, 5_400, "UFA", "OMS", 480); //уфа-омск

    @Test
    public void shouldAddTicket() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddTicketNull() {
        Ticket[] expected = {};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.removeById(ticket3.getId());

        Ticket[] expected = {ticket1, ticket2, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
