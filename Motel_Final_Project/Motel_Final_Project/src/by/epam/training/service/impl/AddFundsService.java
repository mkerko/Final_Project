package by.epam.training.service.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.UserDAO;
import by.epam.training.service.IService;
import by.epam.training.service.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Михаил on 18.06.2016.
 */
public class AddFundsService implements IService {
    private static final AddFundsService instance = new AddFundsService();

    private static final String USER_ID="userID";
    private static final String TO_ADD="toAdd";
    private static final String ERROR_MESSAGE="User can't add funds";

    public static AddFundsService getInstance(){
        return instance;
    }

    @Override
    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        try {
            System.out.println("====================[ BAN USER ]=========================");
            // read info from request
            String userID = request.getParameter(USER_ID);
            String toAdd = request.getParameter(TO_ADD);
            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            UserDAO userDAO = daoFactory.getUserDAO();

            boolean addFunds = userDAO.addFunds(userID, toAdd);


            if (addFunds) {
                System.out.println("User " + userID + " added " + toAdd + "USD");
                request.getRequestDispatcher("/WEB-INF/jsp/cabinet.jsp").forward(request, response);


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

