package productcrudapp.Exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import productcrudapp.Logging.ProductLogger;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value= Exception.class)
	public String exceptionHandler(HttpServletRequest request, Exception ex)
	{   
		ProductLogger.ErrMsg("Error while processing request"+request.getRequestURI(),ex);
		
		return "Exception";
		
	}
}
