package by.epam.training.dao.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.RoomDAO;
import by.epam.training.connectionpool.ConnectionPoolException;
import by.epam.training.connectionpool.impl.ConnectionPoolImpl;
import by.epam.training.domain.Room;
import com.mysql.jdbc.Connection;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class {@code SQLRoomDAO} is the class, that implements methods to connect
 * to the information of rooms in the data base.
 * @author Mikhail Kerko
 */
public class SQLRoomDAO implements RoomDAO {
    private static final SQLRoomDAO sqlRoomDAO = new SQLRoomDAO();
    private static final String GET_FUNDS_SQL = "SELECT * FROM room_info WHERE Room_id=?";
    public static SQLRoomDAO getInstance() {
        return sqlRoomDAO;
    }
    private final static Logger logger = Logger.getRootLogger();
    /**
     * <p>Takes information about room, using its ID.</p>
     * @param roomID is the ID of the room.
     * @return {@code Room} with parameters(information).
     */
    @Override
    public Room getRoomInfo(String roomID) throws DAOException {
        logger.info("====================GET ROOM BY ROOM ID=========================");
        logger.info("You call getRoomInfo.");

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet;
        Room room = null;
        try{

            connection = ConnectionPoolImpl.getInstance().takeConnection();
            logger.info("Connection is created.");

            statement = connection.prepareStatement(GET_FUNDS_SQL);
            logger.info("Statement is OK.");
            statement.setString(1, String.valueOf(roomID));

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                room = new Room(resultSet.getLong("Room_id"), resultSet.getString("Day_price"), resultSet.getString("Numb_of_couchettes"),
                        resultSet.getString("Description"), resultSet.getString("Number"));
            }




        } catch(SQLException | ConnectionPoolException e){
            throw new DAOException(e);
        } finally{
            SQLHelper.finalMethod(connection ,statement);
        }
        logger.info("=============================================");
        return room;
    }
}