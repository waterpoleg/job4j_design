package ru.job4j.tdd;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.ood.tdd.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CinemaTest {

    @Ignore
    @Test
    public void whenBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    @Test
    public void whenFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenSoldOut() {
        Account account = new AccountCinema();
        Account anotherAccount = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        cinema.buy(account, 1, 1, date);
        cinema.buy(anotherAccount, 1, 1, date);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenInvalidDate() {
        Calendar movieDate = Calendar.getInstance();
        movieDate.set(2010, 10, 10, 23, 00);
        Cinema cinema = new Cinema3D();
        Account account = new AccountCinema();
        cinema.buy(account, 1, 1, movieDate);
    }
}
