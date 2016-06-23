package by.epam.training.service.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.RoomDAO;
import by.epam.training.dao.UserDAO;
import by.epam.training.domain.Room;
import by.epam.training.service.IService;
import by.epam.training.service.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Михаил on 20.06.2016.
 */
public class GetRoomInfoService implements IService {
    private static final GetRoomInfoService instance = new GetRoomInfoService();

    private static final String ROOM_ID="roomID";
    private static final String ATTR_ROOM="room";
    private static final String ERROR_MESSAGE="No room info in DB.";

    public static GetRoomInfoService getInstance(){
        return instance;
    }

    @Override
    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            System.out.println("====================[ GET ROOM INFO ]=========================");
            // read info from request
            String roomID = request.getParameter(ROOM_ID);
            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            RoomDAO roomDAO = daoFactory.getRoomDAO();

            Room room = roomDAO.getRoomInfo(roomID);


            if (!(room == null)) {
                System.out.println("Room is not null.");
                request.setAttribute(ATTR_ROOM, room);
                request.getRequestDispatcher("/WEB-INF/jsp/room1.jsp").forward(request, response);
            } else {
                System.out.println(ERROR_MESSAGE);
                throw new ServiceException(ERROR_MESSAGE);
            }
        }
//		catch (NoSuchAlgorithmException e) {
//			throw new ServiceException(e);
//		}
        catch (DAOException e) {
            throw new ServiceException(e);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
