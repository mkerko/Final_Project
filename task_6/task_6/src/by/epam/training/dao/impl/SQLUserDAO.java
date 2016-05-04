package by.epam.training.dao.impl;

import by.epam.training.dao.DAOException;
import by.epam.training.dao.UserDAO;
import by.epam.training.dao.impl.connectionpool.impl.ConnectionPoolImpl;
import by.epam.training.dao.impl.connectionpool.ConnectionPoolException;
import by.epam.training.domain.User;

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.util.Map;


public class SQLUserDAO implements UserDAO {

	private static final SQLUserDAO sqlUserDAO = new SQLUserDAO();

	private static final String LOGIN_PASSWORD_CHECK_SQL= "SELECT * FROM USERS WHERE Login=? AND Password=?";
	private static final String CREATE_USER_SQL= "INSERT INTO users (Login, Password) VALUES(?, ?)";
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

			//íå çàêðûâàòü connection
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
		return status;
	}

	@Override
	public User getUser(String login, String password) throws DAOException {
		System.out.println("====================GET USER=========================");
		System.out.println("Call getUser.");
		User user = new User(getID(login, password), login, password);
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

	//ëó÷øå îòïðàâèòü MAP
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

			//create abiturient
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
}