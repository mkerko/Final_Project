package by.epam.training.dao;

import by.epam.training.domain.Room;

/**
 * Created by Михаил on 19.06.2016.
 */
public interface RoomDAO {
    Room getRoomInfo(String roomID) throws DAOException;
}
