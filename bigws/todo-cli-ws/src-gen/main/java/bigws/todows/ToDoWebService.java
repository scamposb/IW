
package bigws.todows;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ToDoWebService", targetNamespace = "http://todows.bigws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ToDoWebService {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listTasks", targetNamespace = "http://todows.bigws/", className = "bigws.todows.ListTasks")
    @ResponseWrapper(localName = "listTasksResponse", targetNamespace = "http://todows.bigws/", className = "bigws.todows.ListTasksResponse")
    public String listTasks();

    /**
     * 
     * @param title
     * @param description
     * @param priority
     * @param date
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addTask", targetNamespace = "http://todows.bigws/", className = "bigws.todows.AddTask")
    @ResponseWrapper(localName = "addTaskResponse", targetNamespace = "http://todows.bigws/", className = "bigws.todows.AddTaskResponse")
    public String addTask(
        @WebParam(name = "title", targetNamespace = "")
        String title,
        @WebParam(name = "priority", targetNamespace = "")
        Integer priority,
        @WebParam(name = "date", targetNamespace = "")
        String date,
        @WebParam(name = "description", targetNamespace = "")
        String description);

    /**
     * 
     * @param title
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "removeTask", targetNamespace = "http://todows.bigws/", className = "bigws.todows.RemoveTask")
    @ResponseWrapper(localName = "removeTaskResponse", targetNamespace = "http://todows.bigws/", className = "bigws.todows.RemoveTaskResponse")
    public String removeTask(
        @WebParam(name = "title", targetNamespace = "")
        String title);

}