
package bigws.todows;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bigws.todows package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RemoveTaskResponse_QNAME = new QName("http://todows.bigws/", "removeTaskResponse");
    private final static QName _ListTasks_QNAME = new QName("http://todows.bigws/", "listTasks");
    private final static QName _AddTaskResponse_QNAME = new QName("http://todows.bigws/", "addTaskResponse");
    private final static QName _AddTask_QNAME = new QName("http://todows.bigws/", "addTask");
    private final static QName _ListTasksResponse_QNAME = new QName("http://todows.bigws/", "listTasksResponse");
    private final static QName _RemoveTask_QNAME = new QName("http://todows.bigws/", "removeTask");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bigws.todows
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RemoveTaskResponse }
     * 
     */
    public RemoveTaskResponse createRemoveTaskResponse() {
        return new RemoveTaskResponse();
    }

    /**
     * Create an instance of {@link AddTaskResponse }
     * 
     */
    public AddTaskResponse createAddTaskResponse() {
        return new AddTaskResponse();
    }

    /**
     * Create an instance of {@link ListTasks }
     * 
     */
    public ListTasks createListTasks() {
        return new ListTasks();
    }

    /**
     * Create an instance of {@link ListTasksResponse }
     * 
     */
    public ListTasksResponse createListTasksResponse() {
        return new ListTasksResponse();
    }

    /**
     * Create an instance of {@link AddTask }
     * 
     */
    public AddTask createAddTask() {
        return new AddTask();
    }

    /**
     * Create an instance of {@link RemoveTask }
     * 
     */
    public RemoveTask createRemoveTask() {
        return new RemoveTask();
    }

    /**
     * Create an instance of {@link ToDoList }
     * 
     */
    public ToDoList createToDoList() {
        return new ToDoList();
    }

    /**
     * Create an instance of {@link ToDoTask }
     * 
     */
    public ToDoTask createToDoTask() {
        return new ToDoTask();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://todows.bigws/", name = "removeTaskResponse")
    public JAXBElement<RemoveTaskResponse> createRemoveTaskResponse(RemoveTaskResponse value) {
        return new JAXBElement<RemoveTaskResponse>(_RemoveTaskResponse_QNAME, RemoveTaskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListTasks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://todows.bigws/", name = "listTasks")
    public JAXBElement<ListTasks> createListTasks(ListTasks value) {
        return new JAXBElement<ListTasks>(_ListTasks_QNAME, ListTasks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://todows.bigws/", name = "addTaskResponse")
    public JAXBElement<AddTaskResponse> createAddTaskResponse(AddTaskResponse value) {
        return new JAXBElement<AddTaskResponse>(_AddTaskResponse_QNAME, AddTaskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://todows.bigws/", name = "addTask")
    public JAXBElement<AddTask> createAddTask(AddTask value) {
        return new JAXBElement<AddTask>(_AddTask_QNAME, AddTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListTasksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://todows.bigws/", name = "listTasksResponse")
    public JAXBElement<ListTasksResponse> createListTasksResponse(ListTasksResponse value) {
        return new JAXBElement<ListTasksResponse>(_ListTasksResponse_QNAME, ListTasksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://todows.bigws/", name = "removeTask")
    public JAXBElement<RemoveTask> createRemoveTask(RemoveTask value) {
        return new JAXBElement<RemoveTask>(_RemoveTask_QNAME, RemoveTask.class, null, value);
    }

}
