package by.epam.training.dao.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.UserDAO;
import by.epam.training.dao.impl.connectionpool.impl.ConnectionPoolImpl;
import by.epam.training.dao.impl.connectionpool.ConnectionPoolException;
import by.epam.training.domain.Reservation;
import by.epam.training.domain.User;

import by.epam.training.service.ServiceException;
import com.mysql.jdbc.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;



public class SQLUserDAO implements UserDAO {

	private static final SQLUserDAO sqlUserDAO = new SQLUserDAO();

	private static final String LOGIN_PASSWORD_CHECK_SQL= "SELECT * FROM USERS WHERE Login=? AND Password=?";
	private static final String BAN_USER_SQL = "UPDATE users SET Is_banned='1' WHERE Login=?";
	private static final String GET_FUNDS_SQL = "SELECT * FROM user_info WHERE User_id=?";
	private static final String GET_USER_INFO_SQL = "SELECT * FROM user_info WHERE User_id<>?";
	private static final String ADD_FUNDS_SQL = "UPDATE user_info SET Cash_account=? WHERE User_id=?";
	private static final String GET_ALL_USERS_SQL = "SELECT * FROM users WHERE User_id<>?";
	private static final String CREATE_USER_SQL= "INSERT INTO users (Login, Password, Role) VALUES(?, ?, ?)";
	private static final String CREATE_USER_INFO_SQL= "INSERT INTO user_info (First_name, Last_name, Passport_series, Passport_numb, Age) VALUES(?, ?, ?, ?, ?)";

	public static SQLUserDAO getInstance(){
		return sqlUserDAO;
	}

	@Override
	public boolean checkUser(String login, String password) throws DAOException {
		System.out.println("====================CHECK USER=========================");
		System.out.println("You call check user.");

		Connection connection = null;
		boolean status = false;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try{
			connection = ConnectionPoolImpl.getInstance().takeConnection();
			System.out.println("Connection is created.");

			statement = connection.prepareStatement(LOGIN_PASSWORD_CHECK_SQL);
			System.out.println("Statement is OK.");
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
			//return connection into connection pool
			try {
				ConnectionPoolImpl.getInstance().returnConnection(connection);
			} catch (ConnectionPoolException e) {
				throw new DAOException(e);//
			}
		}
		System.out.println("=============================================");
		return status;
	}



	@Override
	public User getUser(String login, String password, String role) throws DAOException {
		System.out.println("====================GET USER=========================");
		System.out.println("Call getUser.");
		User user = new User(getID(login, password), login, password, role);
		System.out.println("=============================================");
		return user;
	}

	@Override
	public Long getID(String login, String password) throws DAOException {
		System.out.println("======================GET ID=======================");
		System.out.println("You call getID.");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Long id = null;
		try{

			connection = ConnectionPoolImpl.getInstance().takeConnection();
			System.out.println("Connection is created.");

			statement = connection.prepareStatement(LOGIN_PASSWORD_CHECK_SQL);
			System.out.println("Statement is OK.");
			statement.setString(1, login);
			statement.setString(2, password);

			resultSet = statement.executeQuery();
			if( resultSet.next()){
				id = resultSet.getLong("user_ID");
			}

			if (resultSet != null) {
				resultSet.close();
			} else {
				System.err.println("Error reading from db.");
			}

			if (statement != null) {
				statement.close();
			} else {
				System.err.println("Statement is not created.");
			}

			/*if (connection != null) {
				connection.close();
				System.out.println("Connection is closed.");
			} else {
				//logging ERROR
				System.err.println("Connection is not closed.");
			}*/

		} catch(SQLException e){
			throw new DAOException(e);
		} catch (ConnectionPoolException e) {
			System.err.println(e.getMessage());
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
		return id;
	}

	@Override
	public boolean createUser(Map<String, String > parameters) throws DAOException{
		System.out.println("====================CREATE USER=========================");
		System.out.println("You call createUser.");
		Connection connection = null;
		PreparedStatement statement = null;
		int countRows;
		try{
			connection = ConnectionPoolImpl.getInstance().takeConnection();
			System.out.println("Connection is created.");

			//create user
			statement = connection.prepareStatement(CREATE_USER_SQL);
			System.out.println("Statement is OK.");
			statement.setString(1, parameters.get("login"));
			statement.setString(2, parameters.get("password"));
			statement.setString(3, parameters.get("role"));
			countRows = statement.executeUpdate();


			if (statement != null) {
				statement.close();
			} else {
				System.err.println("Statement is not created.");
			}

			/*if (connection != null) {
				connection.close();
				System.out.println("Connection is closed.");
			} else {
				//logging ERROR
				System.err.println("Connection is not closed.");
			}*/

			//create user
			statement = connection.prepareStatement(CREATE_USER_INFO_SQL);
			System.out.println("Statement is OK.");
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
			System.out.println("User is registered.");
			System.out.println("=============================================");
			return true;
		} else {
			System.out.println("User is not registered.");
			System.out.println("=============================================");
			return false;
		}

	}

	@Override
	public String getRole(String login, String password) throws DAOException {
		System.out.println("======================GET ROLE=======================");
		System.out.println("You call getRole.");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String role = null;
		try{

			connection = ConnectionPoolImpl.getInstance().takeConnection();
			System.out.println("Connection is created.");

			statement = connection.prepareStatement(LOGIN_PASSWORD_CHECK_SQL);
			System.out.println("Statement is OK.");
			statement.setString(1, login);
			statement.setString(2, password);

			resultSet = statement.executeQuery();
			if( resultSet.next()){
				role = resultSet.getString("role");
			}

			if (resultSet != null) {
				resultSet.close();
			} else {
				System.err.println("Error reading from db.");
			}

			if (statement != null) {
				statement.close();
			} else {
				System.err.println("Statement is not created.");
			}

			/*if (connection != null) {
				connection.close();
				System.out.println("Connection is closed.");
			} else {
				//logging ERROR
				System.err.println("Connection is not closed.");
			}*/

		} catch(SQLException e){
			throw new DAOException(e);
		} catch (ConnectionPoolException e) {
			System.err.println(e.getMessage());
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
		return role;
	}

	@Override
	public ArrayList<User> getAllUsers(String userID) throws DAOException {
		System.out.println("====================GET ALL RESERVATION=========================");
		System.out.println("You call get all reservation.");

		ArrayList<User> users = new ArrayList<>();
		Connection connection = null;
		boolean status = false;
		PreparedStatement statement = null;
		PreparedStatement statement2 = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		try{
			connection = ConnectionPoolImpl.getInstance().takeConnection();
			System.out.println("Connection is created.");

			statement2 = connection.prepareStatement(GET_USER_INFO_SQL);
			statement2.setString(1, String.valueOf(userID));

			statement = connection.prepareStatement(GET_ALL_USERS_SQL);
			statement.setString(1, String.valueOf(userID));
			System.out.println("Statement is OK.");

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
//
			if (resultSet != null) {
				resultSet.close();
			} else {
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
		return users;
	}

	@Override
	public boolean banUser(String userID) throws DAOException {
		System.out.println("====================BAN USER=========================");
		System.out.println("You call banUser.");
		Connection connection = null;
		PreparedStatement statement = null;
		int countRows;
		try{
			connection = ConnectionPoolImpl.getInstance().takeConnection();
			System.out.println("Connection is created.");

			//create user
			statement = connection.prepareStatement(BAN_USER_SQL);
			System.out.println("Statement is OK.");
			statement.setString(1, String.valueOf(userID));
			countRows = statement.executeUpdate();

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
		if( countRows > 0){
			System.out.println("User banned successfully.");
			System.out.println("=============================================");
			return true;
		} else {
			System.out.println("User hsn't been banned.");
			System.out.println("=============================================");
			return false;
		}
	}

	@Override
	public boolean addFunds(String userID, String toAdd) throws DAOException {
		System.out.println("====================ADD FUNDS=========================");
		System.out.println("You call addFunds.");
		Connection connection = null;
		PreparedStatement statement = null;
		int countRows;
		Long willBeOnAccount =null;
		try{
			willBeOnAccount = Long.parseLong(toAdd) +  Long.parseLong(getCashAccount(userID));
			connection = ConnectionPoolImpl.getInstance().takeConnection();
			System.out.println("Connection is created.");

			statement = connection.prepareStatement(ADD_FUNDS_SQL);
			System.out.println("Statement is OK.");
			statement.setString(1, String.valueOf(willBeOnAccount));
			statement.setString(2, String.valueOf(userID));
			countRows = statement.executeUpdate();

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
		if( countRows > 0){
			System.out.println("Money added successfully.");
			System.out.println("=============================================");
			return true;
		} else {
			System.out.println("Money hsn't been added.");
			System.out.println("=============================================");
			return false;
		}
	}

	@Override
	public String getCashAccount(String userID) throws DAOException {
		System.out.println("======================GET CASH=======================");
		System.out.println("You call getCashAccount.");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String cash = null;
		try{
			connection = ConnectionPoolImpl.getInstance().takeConnection();
			System.out.println("Connection is created.");

			statement = connection.prepareStatement(GET_FUNDS_SQL);
			System.out.println("Statement is OK.");
			statement.setString(1, userID);

			resultSet = statement.executeQuery();
			if( resultSet.next()){
				cash =  resultSet.getString("Cash_account");
				System.out.println("CASH ! CASH "+cash);
			}
			System.out.println("You have " + cash + " USD on your account.");
			if (resultSet != null) {
				resultSet.close();
			} else {
				System.err.println("Error reading from db.");
			}

			if (statement != null) {
				statement.close();
			} else {
				System.err.println("Statement is not created.");
			}

			/*if (connection != null) {
				connection.close();
				System.out.println("Connection is closed.");
			} else {
				//logging ERROR
				System.err.println("Connection is not closed.");
			}*/

		} catch(SQLException e){
			throw new DAOException(e);
		} catch (ConnectionPoolException e) {
			System.err.println(e.getMessage());
			throw new DAOException(e);
		}  finally{
			//return connection into connection pool
			try {
				ConnectionPoolImpl.getInstance().returnConnection(connection);
			} catch (ConnectionPoolException e) {
				throw new DAOException(e);
			}
		}
		System.out.println("=============================================");
		return cash;

	}

	@Override
	public User getUserInfo(String userID) throws DAOException {
		return null;
	}
}