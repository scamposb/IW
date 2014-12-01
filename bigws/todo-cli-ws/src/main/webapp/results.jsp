<html>
	<head>
		<title>Here are your results</title>
		<%@ page import="bigws.todows.*" %>
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
			message = todows.addTask((String)request.getAttribute("task"), priotask,
			(String)request.getAttribute("date"), (String)request.getAttribute("description"));
			break;
		case "/removeTask":
			message = todows.removeTask((String)request.getAttribute("title"));
			break;
		case "/listTasks":
			String list= todows.listTasks();
			if(list==null || list.toString().equals("")) list="No hay elementos para listar";
			%>
			<h1>Listado</h1><br><%=list.toString()%>
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