<html>
	<head>
		<title>Action Done</title>
		<%@ page import="bigws.todows.*" %>
		<%@ page import="java.util.List" %>
	</head>
	<body>
		<%	String action = (String)request.getAttribute("action");
		
		String message = "";
		ToDoWebServiceService todowss = new ToDoWebServiceService();
		ToDoWebService todows = todowss.getToDoWSPort();
		
		switch(action){
		case "addTask":
			int priotask = 0;
			try{ 
				priotask = Integer.parseInt((String)request.getAttribute("priotask")); 
			}catch(Exception ex){}
			message = todows.addTask((String)request.getAttribute("task"), priotask,
			(String)request.getAttribute("date"), (String)request.getAttribute("description"));
			break;
		case "removeTask":
			message = ws.removeTask(Integer.parseInt((String)request.getAttribute("title")));
			break;
		case "list":
			ToDoList list= ws.listToDo();
			%>
			<%=getList(list)%>
			<%
			break;
		default:
			break;
		}		
		%>
		<h2><%=message %></h2>
	</body>
</html>