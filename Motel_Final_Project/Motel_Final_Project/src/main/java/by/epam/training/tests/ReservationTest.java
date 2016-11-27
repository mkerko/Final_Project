package by.epam.training.tests;

import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.ReservationDAO;
import by.epam.training.domain.Reservation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Class {@code ReservationTest} is the class, that tests methods from the ReservationDAO interface.
 * @author Mikhail Kerko
 */
public class ReservationTest {

    @Before
    public void setUp() throws Exception {

    }
    /**
     * <p>Creates new reservation. Than puts it into the table in the data base. Finally, checks are that two (firstly created and
     * last taken from the table) equal.</p>
     * @throws Exception  if an error occurs
     */
    @Test
    public void addReservation() throws Exception {
        Reservation reservation = new Reservation();
        reservation.setStartDate("2016-06-06");
        reservation.setEndDate("2016-06-29");
        reservation.setGuestNumber("2");
        reservation.setIsApproved(false);
        reservation.setRoomID("2");
        reservation.setUserID("1");
        System.out.println(reservation.getStartDate());
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        ReservationDAO reservationDAO = daoFactory.getReservationDAO();
        reservationDAO.createReservation(reservation.getStartDate(), reservation.getEndDate(),reservation.getUserID(),reservation.getGuestNumber(),reservation.getRoomID());
        Reservation newReservation = reservationDAO.getLastReservation();
        Assert.assertEquals("Add reservation failed: Start Date mismatch",
                reservation.getStartDate(), newReservation.getStartDate());
        Assert.assertEquals("Add reservation failed: End Date mismatch",
                reservation.getEndDate(), newReservation.getEndDate());
        Assert.assertEquals("Add reservation failed: Guest Number mismatch",
                reservation.getGuestNumber(), newReservation.getGuestNumber());
        Assert.assertEquals("Add reservation failed: RoomID mismatch",
                reservation.getRoomID(), newReservation.getRoomID());
        Assert.assertEquals("Add reservation failed: UserID mismatch",
                reservation.getUserID(), newReservation.getUserID());
        Assert.assertEquals("Add reservation failed: Is Approved mismatch",
                reservation.getIsApproved(), newReservation.getIsApproved());

    }
    /**
     * <p>Deletes last created reservation.</p>
     * @throws Exception  if an error occurs
     */
    @After
    public void tearDown() throws Exception {
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        ReservationDAO reservationDAO = daoFactory.getReservationDAO();
        reservationDAO.deleteLastReservation();
    }

}
