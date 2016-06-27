package by.epam.training.service.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.UserDAO;
import by.epam.training.service.ServiceException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Михаил on 18.06.2016.
 */
public class AddFundsService{
    private static final AddFundsService instance = new AddFundsService();

    private static final String USER_ID="userID";
    private static final String TO_ADD="toAdd";
    private static final String ERROR_MESSAGE="User can't add funds";

    public static AddFundsService getInstance(){
        return instance;
    }

    public void doService(HashMap<String, String> parameters) throws ServiceException {
        try {
            System.out.println("====================[ BAN USER ]=========================");
            String userID = parameters.get(USER_ID);
            String toAdd = parameters.get(TO_ADD);
            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            UserDAO userDAO = daoFactory.getUserDAO();

            boolean addFunds = userDAO.addFunds(userID, toAdd);


            if (addFunds) {
                System.out.println("User " + userID + " added " + toAdd + "USD");
            } else {
                System.out.println(ERROR_MESSAGE);
                throw new ServiceException(ERROR_MESSAGE);
            }
        }
        catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


}

