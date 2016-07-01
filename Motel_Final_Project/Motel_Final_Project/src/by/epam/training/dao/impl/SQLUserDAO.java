package by.epam.training.dao.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.UserDAO;
import by.epam.training.dao.impl.connectionpool.impl.ConnectionPoolImpl;
import by.epam.training.dao.impl.connectionpool.ConnectionPoolException;
import by.epam.training.domain.Reservation;
import by.epam.training.domain.User;

import by.epam.training.service.ServiceException;
import com.mysql.jdbc.Connection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;

/**
 * Class {@code DAOFactory} is the class, that implements methods to connect
 * to the information of reservations in the data base.
 * @author Mikhail Kerko
 */
public class SQLUserDAO implements UserDAO {

	private final static Logger logger = Logger.getRootLogger();
	private static final SQLUserDAO sqlUserDAO = new SQLUserDAO();
	private static final String LOGIN_PASSWORD_CHECK_SQL= "SELECT * FROM USERS WHERE Login=? AND Password=?";
	private static final String BAN_USER_SQL = "UPDATE users SET Is_banned='1' WHERE Login=?";
	private static final String GET_FUNDS_SQL = "SELECT * FROM user_info WHERE User_id=?";
	private static final String GET_USER_INFO_SQL = "SELECT * FROM user_info WHERE User_id<>?";
	private static final String ADD_FUNDS_SQL = "UPDATE user_info SET Cash_account=? WHERE User_id=?";
	private static final String GET_ALL_USERS_SQL = "SELECT * FROM users WHERE User_id<>?";
	private static final String CREATE_USER_SQL= "INSERT INTO users (Login, Password, Role) VALUES(?, ?, ?)";
	private static final String CREATE_USER_INFO_SQL = "INSERT INTO user_info (First_name, Last_name, Passport_series, Passport_numb, Age) VALUES(?, ?, ?, ?, ?)";
	private static final String GET_LAST_USER_INFO_SQL = "SELECT * FROM user_info ORDER BY User_id DESC LIMIT 1";
	private static final String GET_LAST_USER_SQL =  "SELECT * FROM users ORDER BY User_id DESC LIMIT 1";
	private static final String DELETE_LAST_USER_SQL = "DELETE FROM users ORDER BY User_id DESC LIMIT 1";
	private static final String DELETE_LAST_USER_INFO_SQL = "DELETE FROM user_info ORDER BY User_id DESC LIMIT 1";
	private static final String IS_BANNED_CHECK_SQL = "SELECT * FROM users WHERE User_id=?";
	public static SQLUserDAO getInstance(){
		return sqlUserDAO;
	}
	/**
	 * <p>Checks if the user exists i the data base.</p>
	 * @param login is the users login.
	 * @param password is the users password.
	 * @return {@code true} if this user exists; {@code false} otherwise.
	 */
	@Override
	public boolean checkUser(String login, String password) throws DAOException {
		logger.info("====================CHECK USER=========================");
		logger.info("You call check user.");

		Connection connection = null;
		boolean status = false;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try{
			connection = ConnectionPoolImpl.getInstance().takeConnection();
			logger.info("Connection is created.");

			statement = connection.prepareStatement(LOGIN_PASSWORD_CHECK_SQL);
			logger.info("Statement is OK.");
			statement.setString(1, login);
			statement.setString(2, password);

			resultSet = statement.executeQuery();

			if( resultSet.next() ){
				status = true;
			}
	} catch(SQLException e){
			throw new DAOException(e);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} finally{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				ConnectionPoolImpl.getInstance().returnConnection(connection);
			} catch (ConnectionPoolException e) {
				throw new DAOException(e);//
			}
		}
		logger.info("=============================================");
		return status;
	}
	/**
	 * <p>Gets ID of the existing user.</p>
	 * @param login is the users login.
	 * @param password is the users password.
	 * @param role is the users role in the system.
	 * @return {@code ID} of the user.
	 */
	@Override
	public User getUser(String login, String password, String role) throws DAOException {
		logger.info("====================GET USER=========================");
		logger.info("Call getUser.");
		User user = new User(getID(login, password), login, password, role, getIsBanned(String.valueOf(getID(login, password))));
		logger.info("=============================================");
		return user;
	}
	/**
	 * <p>Checks, is user banned otr not.</p>
	 * @param userID is the users identifying number.
	 * @return {@code true} if this user is banned; {@code false} otherwise.
	 */
	@Override
	public boolean getIsBanned(String userID) throws DAOException{
		logger.info("======================GET IS BANNED=======================");
		logger.info("You call getIsBanned.");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		boolean isBanned = false;
		try{

			connection = ConnectionPoolImpl.getInstance().takeConnection();
			logger.info("Connection is created.");

			statement = connection.prepareStatement(IS_BANNED_CHECK_SQL);
			logger.info("Statement is OK.");
			statement.setString(1, userID);

			resultSet = statement.executeQuery();
			if( resultSet.next()){
				if (resultSet.getLong("Is_banned") == 1){
					isBanned = true;
				} else {
					isBanned = false;
				}
			}
			logger.info("IS BANNED = " + isBanned);

			if (resultSet == null) {
				logger.warn("Error reading from db.");
			}

			if (statement != null) {
				statement.close();
			} else {
				logger.warn("Statement is not created.");
			}

		} catch(SQLException e){
			throw new DAOException(e);
		} catch (ConnectionPoolException e) {
			logger.warn(e.getMessage());
			throw new DAOException(e);
		} finally{
			//return connection into connection pool
			try {
				ConnectionPoolImpl.getInstance().returnConnection(connection);
			} catch (ConnectionPoolException e) {
				throw new DAOException(e);
			}
		}
		logger.info("=============================================");
		return isBanned;
	}
	/**
	 * <p>Gets ID of the user, using next parameters.</p>
	 * @param login is the users login.
	 * @param password is the users password.
	 * @return {@code Long} is userID.
	 */
	@Override
	public Long getID(String login, String password) throws DAOException {
		logger.info("======================GET ID=======================");
		logger.info("You call getID.");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Long id = null;
		try{

			connection = ConnectionPoolImpl.getInstance().takeConnection();
			logger.info("Connection is created.");

			statement = connection.prepareStatement(LOGIN_PASSWORD_CHECK_SQL);
			logger.info("Statement is OK.");
			statement.setString(1, login);
			statement.setString(2, password);

			resultSet = statement.executeQuery();
			if( resultSet.next()){
				id = resultSet.getLong("user_ID");
			}

			if (resultSet == null) {
				logger.warn("Error reading from db.");
			}

			if (statement != null) {
				statement.close();
			} else {
				logger.warn("Statement is not created.");
			}

		} catch(SQLException e){
			throw new DAOException(e);
		} catch (ConnectionPoolException e) {
			logger.warn(e.getMessage());
			throw new DAOException(e);
		} finally{
			//return connection into connection pool
			try {
				ConnectionPoolImpl.getInstance().returnConnection(connection);
			} catch (ConnectionPoolException e) {
				throw new DAOException(e);
			}
		}
		logger.info("=============================================");
		return id;
	}
	/**
	 * <p>Creates new user in the data base.</p>
	 * @param parameters is a map with all user parameters needed to be included in the data base.
	 * @return {@code true} if user created successfully; {@code false} otherwise.
	 */
	@Override
	public boolean createUser(Map<String, String > parameters) throws DAOException{
		logger.info("====================CREATE USER=========================");
		logger.info("You call createUser.");
		Connection connection = null;
		PreparedStatement statement = null;
		int countRows;
		try{
			connection = ConnectionPoolImpl.getInstance().takeConnection();
			logger.info("Connection is created.");

			//create user
			statement = connection.prepareStatement(CREATE_USER_SQL);
			logger.info("Statement is OK.");
			statement.setString(1, parameters.get("login"));
			statement.setString(2, parameters.get("password"));
			statement.setString(3, parameters.get("role"));
			countRows = statement.executeUpdate();


			if (statement != null) {
				statement.close();
			} else {
				logger.warn("Statement is not created.");
			}

			statement = connection.prepareStatement(CREATE_USER_INFO_SQL);
			logger.info("Statement is OK.");
			statement.setString(1, parameters.get("First_name"));
			statement.setString(2, parameters.get("Last_name"));
			statement.setString(3, parameters.get("Passport_series"));
			statement.setString(4, parameters.get("Passport_numb"));
			statement.setString(5, parameters.get("Age"));

			countRows = statement.executeUpdate();

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

		if( countRows > 0){
			logger.info("User is registered.");
			logger.info("=============================================");
			return true;
		} else {
			logger.info("User is not registered.");
			logger.info("=============================================");
			return false;
		}

	}
	/**
	 * <p>Gets role of the user, using next parameters.</p>
	 * @param login is the users login.
	 * @param password is the users password.
	 * @return {@code String} is users role int the system.
	 */
	@Override
	public String getRole(String login, String password) throws DAOException {
		logger.info("======================GET ROLE=======================");
		logger.info("You call getRole.");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String role = null;
		try{

			connection = ConnectionPoolImpl.getInstance().takeConnection();
			logger.info("Connection is created.");

			statement = connection.prepareStatement(LOGIN_PASSWORD_CHECK_SQL);
			logger.info("Statement is OK.");
			statement.setString(1, login);
			statement.setString(2, password);

			resultSet = statement.executeQuery();
			if( resultSet.next()){
				role = resultSet.getString("role");
			}

			if (resultSet == null) {
				logger.warn("Error reading from db.");
			}

			if (statement != null) {
				statement.close();
			} else {
				logger.warn("Statement is not created.");
			}


		} catch(SQLException e){
			throw new DAOException(e);
		} catch (ConnectionPoolException e) {
			logger.warn(e.getMessage());
			throw new DAOException(e);
		} finally{
			//return connection into connection pool
			try {
				ConnectionPoolImpl.getInstance().returnConnection(connection);
			} catch (ConnectionPoolException e) {
				throw new DAOException(e);
			}
		}
		logger.info("=============================================");
		return role;
	}
	/**
	 * <p>Gets all users, except user, called that function./p>
	 * @param userID is identifying number of the user, whom information, we don't need.
	 * @return {@code ArrayList} is a list of user of the system.
	 */
	@Override
	public ArrayList<User> getAllUsers(String userID) throws DAOException {
		logger.info("====================GET ALL USERS=========================");
		logger.info("You call getAllUsers.");

		ArrayList<User> users = new ArrayList<>();
		Connection connection = null;
		boolean status = false;
		PreparedStatement statement = null;
		PreparedStatement statement2 = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		try{
			connection = ConnectionPoolImpl.getInstance().takeConnection();
			logger.info("Connection is created.");

			statement2 = connection.prepareStatement(GET_USER_INFO_SQL);
			statement2.setString(1, String.valueOf(userID));

			statement = connection.prepareStatement(GET_ALL_USERS_SQL);
			statement.setString(1, String.valueOf(userID));
			logger.info("Statement is OK.");

			resultSet = statement.executeQuery();
			resultSet2 = statement2.executeQuery();

//
			while (resultSet.next() && resultSet2.next()) {
				User user = new User(getID(resultSet.getString("Login"), resultSet.getString("Password")),
						resultSet.getString("Login"), resultSet.getString("Password"), resultSet.getString("Role"), resultSet.getBoolean("Is_banned"),
						resultSet2.getString("First_name"), resultSet2.getString("Last_name"), resultSet2.getString("Passport_series"),
						resultSet2.getString("Passport_numb"), resultSet2.getString("Age"), resultSet2.getString("Cash_account"));
				users.add(user);
			}
			if (resultSet != null) {
				logger.warn("Error reading from db.");
			}

			if (statement != null) {
				statement.close();
			} else {
				logger.warn("Statement is not created.");
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
		logger.info("=============================================");
		return users;
	}
	/**
	 * <p>Bans user, using its ID.</p>
	 * @param userID is the id of the user to be banned.
	 * @return {@code true} if user banned successfully; {@code false} otherwise.
	 */
	@Override
	public boolean banUser(String userID) throws DAOException {
		logger.info("====================BAN USER=========================");
		logger.info("You call banUser.");
		Connection connection = null;
		PreparedStatement statement = null;
		int countRows;
		try{
			connection = ConnectionPoolImpl.getInstance().takeConnection();
			logger.info("Connection is created.");

			//create user
			statement = connection.prepareStatement(BAN_USER_SQL);
			logger.info("Statement is OK.");
			statement.setString(1, String.valueOf(userID));
			countRows = statement.executeUpdate();

			if (statement != null) {
				statement.close();
			} else {
				logger.warn("Statement is not created.");
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
		if( countRows > 0){
			logger.info("User banned successfully.");
			logger.info("=============================================");
			return true;
		} else {
			logger.info("User hsn't been banned.");
			logger.info("=============================================");
			return false;
		}
	}
	/**
	 * <p>Adds funds, using next parameters.</p>
	 * @param userID is the id of the user.
	 * @param toAdd is how much we are to add on users account.
	 * @return {@code true} if funds added successfully; {@code false} otherwise.
	 */
	@Override
	public boolean addFunds(String userID, String toAdd) throws DAOException {
		logger.info("====================ADD FUNDS=========================");
		logger.info("You call addFunds.");
		Connection connection = null;
		PreparedStatement statement = null;
		int countRows;
		Long willBeOnAccount =null;
		try{
			willBeOnAccount = Long.parseLong(toAdd) +  Long.parseLong(getCashAccount(userID));
			connection = ConnectionPoolImpl.getInstance().takeConnection();
			logger.info("Connection is created.");

			statement = connection.prepareStatement(ADD_FUNDS_SQL);
			logger.info("Statement is OK.");
			statement.setString(1, String.valueOf(willBeOnAccount));
			statement.setString(2, String.valueOf(userID));
			countRows = statement.executeUpdate();

			if (statement != null) {
				statement.close();
			} else {
				logger.warn("Statement is not created.");
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
		if( countRows > 0){
			logger.info("Money added successfully.");
			logger.info("=============================================");
			return true;
		} else {
			logger.info("Money hsn't been added.");
			logger.info("=============================================");
			return false;
		}
	}
	/**
	 * <p>Gets cash amount of the user, using next parameters.</p>
	 * @param userID is the users ID.
	 * @return {@code String} is users role int the system.
	 */
	@Override
	public String getCashAccount(String userID) throws DAOException {
		logger.info("======================GET CASH=======================");
		logger.info("You call getCashAccount.");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String cash = null;
		try{
			connection = ConnectionPoolImpl.getInstance().takeConnection();
			logger.info("Connection is created.");

			statement = connection.prepareStatement(GET_FUNDS_SQL);
			logger.info("Statement is OK.");
			statement.setString(1, userID);

			resultSet = statement.executeQuery();
			if( resultSet.next()){
				cash =  resultSet.getString("Cash_account");
			}
			logger.info("You have " + cash + " USD on your account.");

			if (resultSet == null) {
				logger.warn("Error reading from db.");
			}

			if (statement != null) {
				statement.close();
			} else {
				logger.warn("Statement is not created.");
			}


		} catch(SQLException e){
			throw new DAOException(e);
		} catch (ConnectionPoolException e) {
			logger.warn(e.getMessage());
			throw new DAOException(e);
		}  finally{
			//return connection into connection pool
			try {
				ConnectionPoolImpl.getInstance().returnConnection(connection);
			} catch (ConnectionPoolException e) {
				throw new DAOException(e);
			}
		}
		logger.info("=============================================");
		return cash;

	}
	/**
	 * <p>Gets last user from the data base.</p>
	 * @return {@code User} is last user in the table.
	 */
	@Override
	public User getLastUser() throws DAOException {
		logger.info("====================GET LAST USERS=========================");
		logger.info("You call getLastUser.");

		Connection connection = null;
		boolean status = false;
		PreparedStatement statement = null;
		PreparedStatement statement2 = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		User user = null;
		try{
			connection = ConnectionPoolImpl.getInstance().takeConnection();
			logger.info("Connection is created.");

			statement2 = connection.prepareStatement(GET_LAST_USER_INFO_SQL);
			statement = connection.prepareStatement(GET_LAST_USER_SQL);
			logger.info("Statement is OK.");

			resultSet = statement.executeQuery();
			resultSet2 = statement2.executeQuery();

			if (resultSet.next() && resultSet2.next()) {
				 user = new User(getID(resultSet.getString("Login"), resultSet.getString("Password")),
						resultSet.getString("Login"), resultSet.getString("Password"), resultSet.getString("Role"), resultSet.getBoolean("Is_banned"),
						resultSet2.getString("First_name"), resultSet2.getString("Last_name"), resultSet2.getString("Passport_series"),
						resultSet2.getString("Passport_numb"), resultSet2.getString("Age"), resultSet2.getString("Cash_account"));
			}
			if (resultSet != null) {
				logger.warn("Error reading from db.");
			}

			if (statement != null) {
				statement.close();
			} else {
				logger.warn("Statement is not created.");
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
		logger.info("=============================================");
		return user;
	}
	/**
	 * <p>Deletes last user from the data base.</p>
	 * @return {@code true} if user deleted successfully; {@code false} otherwise.
	 */
	@Override
	public void deleteLastUser() throws DAOException {
		logger.info("====================DELETE LAST USER=========================");
		logger.info("You call deleteLastUser.");
		Connection connection = null;
		PreparedStatement statement = null;
		PreparedStatement statement2 = null;
		int countRows;
		int countRows2;
		try{
			connection = ConnectionPoolImpl.getInstance().takeConnection();
			logger.info("Connection is created.");

			//create user
			statement = connection.prepareStatement(DELETE_LAST_USER_SQL);
			statement2 = connection.prepareStatement(DELETE_LAST_USER_INFO_SQL);
			logger.info("Statement is OK.");
			countRows = statement.executeUpdate();
			countRows2 = statement2.executeUpdate();

			if (statement != null) {
				statement.close();
			} else {
				logger.warn("Statement is not created.");
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
		if( countRows > 0 && countRows2 > 0){
			logger.info("User deleted successfully.");
			logger.info("=============================================");
		} else {
			logger.info("User hsn't been deleted.");
			logger.info("=============================================");
		}
	}
}