package by.epam.training.dao.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.RoomDAO;
import by.epam.training.dao.impl.connectionpool.ConnectionPoolException;
import by.epam.training.dao.impl.connectionpool.impl.ConnectionPoolImpl;
import by.epam.training.domain.Reservation;
import by.epam.training.domain.Room;
import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Михаил on 19.06.2016.
 */
public class SQLRoomDAO implements RoomDAO {

    private static final SQLRoomDAO sqlRoomDAO = new SQLRoomDAO();

    private static final String GET_FUNDS_SQL = "SELECT * FROM room_info WHERE Room_id=?";

    public static SQLRoomDAO getInstance() {
        return sqlRoomDAO;
    }

    @Override
    public Room getRoomInfo(String roomID) throws DAOException {
        System.out.println("====================GET ROOM BY ROOM ID=========================");
        System.out.println("You call getRoomInfo.");

        Connection connection = null;
        boolean status = false;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Room room = null;
        try{

            connection = ConnectionPoolImpl.getInstance().takeConnection();
            System.out.println("Connection is created.");

            statement = connection.prepareStatement(GET_FUNDS_SQL);
            System.out.println("Statement is OK.");
            statement.setString(1, String.valueOf(roomID));

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                room = new Room(resultSet.getLong("Room_id"), resultSet.getString("Day_price"), resultSet.getString("Numb_of_couchettes"),
                        resultSet.getString("Description"), resultSet.getString("Number"));
            }
            if (resultSet == null) {
                System.err.println("Error reading from db.");
            }

            if (statement != null) {
                statement.close();
            } else {
                System.err.println("Statement is not created.");
            }




        } catch(SQLException e){
            throw new DAOException(e);
        } catch (ConnectionPoolException e) {
            throw new DAOException(e);
        } finally{
            //return connection into connection pool
            try {
                ConnectionPoolImpl.getInstance().returnConnection(connection);
            } catch (ConnectionPoolException e) {
                throw new DAOException(e);
            }
        }
        System.out.println("=============================================");
        return room;
    }
}