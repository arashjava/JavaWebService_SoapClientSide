package arash.tech.training.ws.client;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import tech.arash.employee.Employee;
import tech.arash.employee.EmployeePortType;
import tech.arash.employee.EmployeeWsService;
import tech.arash.employee.GetAllEmployeesRequest;
import tech.arash.employee.GetAllEmployeesResponse;

public class EmployeeWSClient {

	public static void main(String[] args) throws MalformedURLException {
		EmployeeWsService service = new EmployeeWsService(
				new URL("http://localhost:8080/employeews/EmployeeWsService?wsdl"));
		EmployeePortType employeePort = service.getEmployeeWsPort();
		
		GetAllEmployeesRequest request= new GetAllEmployeesRequest();
		request.setEmployeeId(BigInteger.valueOf(1));
		GetAllEmployeesResponse response = employeePort.getAllEmployees(request);
		
		List<Employee> employees = response.getEmployee();
		for (Employee e: employees) {
			System.out.println(e.getName());
		}
	}

}
