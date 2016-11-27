package by.epam.training.controller;


import by.epam.training.command.CommandException;
import by.epam.training.command.ICommand;
import by.epam.training.command.impl.*;

import java.util.HashMap;
import java.util.Map;
/**
 * Class {@code ControllerHelper} is the class, that contains enumeration of all commands and the map, where key is a
 * name of the command, and object is new object of Command class, user wants to call.
 * @author Mikhail Kerko
 */
public class ControllerHelper {
	enum CommandName{
		LOGIN, LOGOUT, REGISTER, EN, RU, BOOK, GETRESERVATIONS,DELETERESERVATION,
		GETALLRESERVATIONS,APPROVERESERVATION, GETALLUSERS,BANUSER, ADDFUNDS, GETFUNDS,GETROOMINFO, UNBANUSER;
	}
	private Map<CommandName, ICommand> commands = new HashMap<>();
	
	public ControllerHelper(){
		commands.put(CommandName.LOGIN, new LoginCommand());
		commands.put(CommandName.LOGOUT, new LogoutCommand());
		commands.put(CommandName.REGISTER, new RegisterCommand());
		commands.put(CommandName.EN, new ChangeLocaleCommand());
		commands.put(CommandName.RU, new ChangeLocaleCommand());
		commands.put(CommandName.BOOK, new BookCommand());
		commands.put(CommandName.GETRESERVATIONS, new GetReservationsCommand());
		commands.put(CommandName.DELETERESERVATION, new DeleteReservationCommand());
		commands.put(CommandName.GETALLRESERVATIONS, new GetAllReservationsCommand());
		commands.put(CommandName.APPROVERESERVATION, new ApproveReservationCommand());
		commands.put(CommandName.GETALLUSERS, new GetAllUsersCommand());
		commands.put(CommandName.BANUSER, new BanUserCommand());
		commands.put(CommandName.ADDFUNDS, new AddFundsCommand());
		commands.put(CommandName.GETFUNDS, new GetFundsCommand());
		commands.put(CommandName.UNBANUSER, new UnBanUserCommand());
	}
	/**
	 * <p>Transforms command name to upper case.</p>
	 * @param commandName is a name of the command, taken from jsp.
	 * @return {@code String} contains the name of the command.
	 * @exception CommandException if some parameters are emty.
	 * @see javax.servlet.ServletException
	 * @see javax.servlet.http.HttpServletRequest
	 * @see javax.servlet.http.HttpServletResponse
	 * @see java.util.Enumeration
	 * @see java.util.HashMap
	 */
	public ICommand getCommand(String commandName){
		CommandName name = CommandName.valueOf(commandName.toUpperCase());
		return commands.get(name);
	}
	
	

}
