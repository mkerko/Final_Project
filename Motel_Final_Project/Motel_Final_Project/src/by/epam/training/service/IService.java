package by.epam.training.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IService {
	void doService(HttpServletRequest request, HttpServletResponse response) throws ServiceException;
}
