package by.epam.training.dao;

import by.epam.training.dao.impl.SQLReservationDAO;
import by.epam.training.dao.impl.SQLRoomDAO;
import by.epam.training.dao.impl.SQLUserDAO;
/**
 * Class {@code DAOFactory} is the class, that contains methods to deal with information in the data base for three DAO
 * classes.
 * @author Mikhail Kerko
 */
public class DAOFactory {
    private static final DAOFactory daoFactory = new DAOFactory();
    public UserDAO getUserDAO(){
        return SQLUserDAO.getInstance();
    }
    public static DAOFactory getDAOFactory(){
        return daoFactory;
    }
    public ReservationDAO getReservationDAO(){
        return SQLReservationDAO.getInstance();
    }
    public RoomDAO getRoomDAO(){
        return SQLRoomDAO.getInstance();
    }

}
