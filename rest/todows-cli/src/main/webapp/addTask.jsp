<%@ page import="java.util.Map" %>
<html>
<head>
<title>Add Task</title>
</head>
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
%>
<body>
	<h1>Add Task</h1>
	<form method="post" action="addTask">
		<p>Name:<input type="text" name="task" value="<%=task%>"/><%=taskError%></p>
		<p>Task's priority:<input type="text" name="priotask" value="<%=priotask%>"/><%=prioError%></p>	
		<p>Has the task a finish date? (leave blank if it isnt) :<input type="text" name="date" value="<%=date%>"/><%=dateError%></p>
		<p>Insert a little description of the task:<input type="textarea" name="description" value="<%=description%>"/><%=descriptionError%></p>
		<p align="center"><input type="submit" value="Submit"/>
		<input type="reset" value="Reset"/></p>
	</form>
</body>
</html>