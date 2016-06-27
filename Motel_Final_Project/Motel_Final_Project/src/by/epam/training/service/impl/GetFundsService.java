package by.epam.training.service.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.DAOFactory;
import by.epam.training.dao.UserDAO;
import by.epam.training.service.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Михаил on 19.06.2016.
 */
public class GetFundsService{
    private static final GetFundsService instance = new GetFundsService();

    private static final String USER_ID="userID";
    private static final String ATTR_FUNDS="funds";
    private static final String ERROR_MESSAGE="No money on the account.";

    public static GetFundsService getInstance(){
        return instance;
    }

    public HashMap<String, Object> doService(HashMap<String,String> parameters) throws ServiceException {
        try {
            System.out.println("====================[ GET FUNDS ]=========================");
            // read info from request
            String userID = parameters.get(USER_ID);
            DAOFactory daoFactory = DAOFactory.getDAOFactory();
            UserDAO userDAO = daoFactory.getUserDAO();
            HashMap<String, Object> toResponse = new HashMap<>();
            String funds = userDAO.getCashAccount(userID);


            if (!funds.isEmpty()) {
                System.out.println("User has reservations.");
                toResponse.put(ATTR_FUNDS, funds);
                //request.setAttribute(ATTR_FUNDS, funds);
                //request.getRequestDispatcher("/WEB-INF/jsp/cabinet.jsp").forward(request, response);

            } else {
                System.out.println(ERROR_MESSAGE);
                throw new ServiceException(ERROR_MESSAGE);
            }
            return toResponse;
        }
        catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


}
