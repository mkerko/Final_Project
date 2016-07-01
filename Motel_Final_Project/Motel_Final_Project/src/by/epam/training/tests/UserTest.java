package by.epam.training.tests;

/**
 * Created by Михаил on 29.06.2016.
 */

import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.ReservationDAO;
import by.epam.training.dao.UserDAO;
import by.epam.training.domain.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
/**
 * Class {@code UserTest} is the class, that tests methods from the ReservationDAO interface.
 * @author Mikhail Kerko
 */
public class UserTest {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String ROLE = "moderator";
    private static final String FNAME = "name";
    private static final String LNAME = "surname";
    private static final String PSERIES = "MP";
    private static final String PNUMBER = "1233211";
    private static final String AGE = "21";
    private static final String PARAMETR_LOGIN="login";
    private static final String PARAMETR_PASSWORD="password";
    private static final String PARAMETR_ROLE="role";
    private static final String PARAMETR_FNAME="First_name";
    private static final String PARAMETR_LNAME="Last_name";
    private static final String PARAMETR_PSERIES="Passport_series";
    private static final String PARAMETR_PNUMBER="Passport_numb";
    private static final String PARAMETR_AGE="Age";

    @Before
    public void setUp() throws Exception {

    }
    /**
     * <p>Creates new user. Than puts it into the table in the data base. Finally, checks are that two (firstly created and
     * last taken from the table) equal.</p>
     * @throws Exception  if an error occurs
     */
    @Test
    public void addReservation() throws Exception {
        User user = new User();
        user.setLogin(LOGIN);
        user.setPassword(PASSWORD);
        user.setRole(ROLE);
        user.setAge(AGE);
        user.setPassportNumber(PNUMBER);
        user.setPassportSeries(PSERIES);
        user.setFirstName(FNAME);
        user.setLastName(LNAME);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put(PARAMETR_LOGIN, LOGIN);
        map.put(PARAMETR_PASSWORD, PASSWORD);
        map.put(PARAMETR_ROLE, ROLE);
        map.put(PARAMETR_FNAME, FNAME);
        map.put(PARAMETR_LNAME, LNAME);
        map.put(PARAMETR_PSERIES, PSERIES);
        map.put(PARAMETR_PNUMBER, PNUMBER);
        map.put(PARAMETR_AGE, AGE);
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        UserDAO userDAO = daoFactory.getUserDAO();
        userDAO.createUser(map);
        User newUser = userDAO.getLastUser();
        Assert.assertEquals("Add reservation failed: Last Name mismatch",
                user.getLastName(), newUser.getLastName());
    }
    /**
     * <p>Deletes last created reservation.</p>
     * @throws Exception  if an error occurs
     */
    @After
    public void tearDown() throws Exception {
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        UserDAO userDAO = daoFactory.getUserDAO();
        userDAO.deleteLastUser();
    }
}
