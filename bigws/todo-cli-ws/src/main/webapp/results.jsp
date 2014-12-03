<%@ page import="bigws.todows.*" %>
<%@ page import="java.util.List" %>
<html>
	<head>
		<title>Here are your results</title>
		<%!
		private String showList(ToDoList toDolist){
			StringBuilder sb = new StringBuilder();
			List<ToDoTask> list = toDolist.getToDoList();
			ToDoTask elem = null;
			for (int i=0; i<list.size(); i++){
				elem = list.get(i);
				sb.append("<ul>"
				+"<li>Task: "+elem.getTitle()+"</li>"
				+"<li>Priority: "+elem.getPriority()+"</li>"
				+"<li>Date: "+elem.getDate()+"</li>"
				+"<li>Description: "+elem.getDescription()+"</li>"
				+"</ul>");
			}
			return sb.toString();
		}
		%>
	</head>
	<body>
		<%	String action = (String)request.getAttribute("action");
		String message = "";
		ToDoWebServiceService todowss = new ToDoWebServiceService();
		ToDoWebService todows = todowss.getToDoWebServicePort();
		switch(action){
			case "/addTask":
			int priotask = 0;
			try{
				priotask = Integer.parseInt((String)request.getAttribute("priotask"));
			}catch(Exception ex){}		
			boolean success = todows.addTask((String)request.getAttribute("task"), priotask,
			(String)request.getAttribute("date"), (String)request.getAttribute("description"));
			if(success) message = "Success!";
			else message = "Failed";
			break;
			
			case "/removeTask":
				success = todows.removeTask((String)request.getAttribute("title"));
				if(success) message = "Success!";
				else message = "Failed";
			break;
			case "/listTasks":
				ToDoList tlist= todows.listTasks();
				message = "";
			%>
			<h1>Listado</h1><%=showList(tlist)%>
			<%
			break;
			default:
				break;
		}
		%>
		<h2><%=message %></h2>
		<p><form method="link" action="./index.jsp"> <input type="submit" value="Volver al inicio"> </form></p>
	</body>
</html>