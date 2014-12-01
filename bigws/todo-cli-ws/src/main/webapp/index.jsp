<%@ page import="java.util.Map" %>
<html>
	<head>
		<title>ToDo SOAP</title>
		<%
			String task="",priotask="",date="",description="";
			String cabeceraError="<span style=\"color:red;\"> ";
			String colaError="</span>";
			String taskError="",prioError="",dateError="",descriptionError="";
			
			if(task==null) task="";
			priotask=request.getParameter("priotask");
			if(priotask==null) priotask="";
			date=request.getParameter("date");
			if(date==null) date="";
			description=request.getParameter("description");
			if(description==null) description="";
			
			Map<String, String> errors=(Map<String,String>) request.getAttribute("errors");
			if(errors!=null){	
				if (errors.containsKey("task"))taskError=cabeceraError+errors.get("task")+colaError;	
				if (errors.containsKey("priotask"))prioError=cabeceraError+errors.get("priotask")+colaError;
				if (errors.containsKey("date"))dateError=cabeceraError+errors.get("date")+colaError;	
				if (errors.containsKey("description"))descriptionError=cabeceraError+errors.get("description")+colaError;	
			}
		
			String mostrarAdd = (String)request.getParameter("mostrarAdd");
			if(mostrarAdd == null) mostrarAdd = "false";
		%>
	</head>
	<body>
		<h1>Welcome to ToDo powered by SOAP!</h1><br>
		<h3>What do you want to do?</h3>
		<ul>
			<li><a href=./index.jsp?mostrarAdd="true">Add Task</a></li>
			<%
				if(mostrarAdd.equals("true")){
				%>
				<form method="post" action="addTask">
				<p>Name:<input type="text" name="task" value="<%=task%>"/><%=taskError%></p>
				<p>Task's priority:<input type="text" name="priotask" value="<%=priotask%>"/><%=prioError%></p>	
				<p>Has the task a finish date? (leave blank if it isnt) :<input type="text" name="date" value="<%=date%>"/><%=dateError%></p>
				<p>Insert a little description of the task:<input type="textarea" name="description" value="<%=description%>"/><%=descriptionError%></p>
				<p align="center"><input type="submit" value="Submit"/>
				<input type="reset" value="Reset"/></p>
				</form>
				
				
				
				<%
				
				}
				
			%>
			<li>
				<form method="get" action="listTasks">
					List Tasks <input type="submit" value="Submit"/>
				</form>
			</li>
			<p>
				<form method="get" action="removeTask">
					<li>Remove task<br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					Insert task name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" name="nameT"/> 
					<input type="submit" value="Submit"/></li>				
				</form>
			</p>
		</ul>
	</body>
</html>