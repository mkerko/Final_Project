package by.epam.training.controller;


import by.epam.training.controller.command.ICommand;
import by.epam.training.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class ControllerHelper {
	enum CommandName{
		LOGIN, LOGOUT, REGISTER, EN, RU, BOOK, GETRESERVATIONS,DELETERESERVATION,
		GETALLRESERVATIONS,APPROVERESERVATION, GETALLUSERS,BANUSER, ADDFUNDS, GETFUNDS,GETROOMINFO;
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
		commands.put(CommandName.GETROOMINFO, new GetRoomInfoCommand());
	}
	
	
	public ICommand getCommand(String commandName){
		CommandName name = CommandName.valueOf(commandName.toUpperCase());
		return commands.get(name);
	}
	
	

}
