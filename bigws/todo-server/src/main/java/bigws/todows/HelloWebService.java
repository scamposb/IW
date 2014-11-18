package bigws.todows;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWebService {
	
	@WebMethod()
	public String sayHello(String name) {
		return "Hello "+name +"!";
	}
}
