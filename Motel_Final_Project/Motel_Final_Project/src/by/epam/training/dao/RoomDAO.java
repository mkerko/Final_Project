package by.epam.training.dao;

import by.epam.training.domain.Room;

/**
 * Interface {@code ReservationDAO} is the class, that contains method to deal with information of the room
 * in the data base.
 * @author Mikhail Kerko
 */
public interface RoomDAO {
    Room getRoomInfo(String roomID) throws DAOException;
}
