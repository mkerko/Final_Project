package by.epam.training.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Interface {@code ICommand} has the only one method for the set of "Command" layer classes.
 * @author Mikhail Kerko
 */
public interface  ICommand {
	/**
	 * Indicates whether some parameter is null.
	 * <p>
	 * @param request is the request, taken form the jsp form.
	 * @param response is the response for needed for {@code getRequestDispatcher} method
	 * @return {@code String} wgich is the name of the next page.
	 */
	String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException;
}
