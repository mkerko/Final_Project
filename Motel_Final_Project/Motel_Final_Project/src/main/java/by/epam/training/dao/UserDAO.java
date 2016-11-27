package by.epam.training.dao;


import by.epam.training.domain.User;

import java.util.ArrayList;
import java.util.Map;
/**
 * Interface {@code ReservationDAO} is the class, that contains methods to deal with information of the users
 * in the data base.
 * @author Mikhail Kerko
 */
public interface UserDAO {
	boolean checkUser(String login, String password) throws DAOException;
	User getUser(String login, String password, String role) throws DAOException;
	boolean createUser(Map<String, String> parameters) throws DAOException;
	String getRole(String login, String password) throws  DAOException;
	ArrayList<User> getAllUsers(String userID) throws DAOException;
	Long getID(String login, String password) throws DAOException;
	boolean banUser(String userID) throws  DAOException;
	boolean unBanUser(String userID) throws  DAOException;
	boolean addFunds(String userID, String toAdd) throws DAOException;
	String getCashAccount(String userID) throws  DAOException;
	User getLastUser() throws DAOException;
	void deleteLastUser() throws DAOException;
	boolean getIsBanned(String userID) throws DAOException;
}
