<%@ page import="java.util.Map" %>
<html>
<head>
<title>Add People</title>
</head>
<%
	String pid="", name="",anyo="",direccion="",email="",task="",typetask="",date="",description="";
	String cabeceraError="<span style=\"color:red;\"> ";
	String colaError="</span>";
	String pidError="", nameError="",anyoError="",direccionError="",emailError="",taskError="",typeError="",dateError="",descriptionError="";
	
	pid=request.getParameter("pid");
	if(pid==null) pid="";
	name=request.getParameter("name");
	if(name==null) name="";
	email=request.getParameter("email");
	if(email==null) email="";
	task=request.getParameter("task");
	if(task==null) task="";
	typetask=request.getParameter("typetask");
	if(typetask==null) typetask="";
	date=request.getParameter("date");
	if(date==null) date="";
	description=request.getParameter("description");
	if(description==null) description="";
	
	Map<String, String> errors=(Map<String,String>) request.getAttribute("errors");
	if(errors!=null){
		if (errors.containsKey("pid"))pidError=cabeceraError+errors.get("pid")+colaError;
		if (errors.containsKey("name"))nameError=cabeceraError+errors.get("name")+colaError;
		if (errors.containsKey("email"))emailError=cabeceraError+errors.get("email")+colaError;	
		if (errors.containsKey("task"))taskError=cabeceraError+errors.get("task")+colaError;	
		if (errors.containsKey("typetask"))typeError=cabeceraError+errors.get("typetask")+colaError;
		if (errors.containsKey("date"))dateError=cabeceraError+errors.get("date")+colaError;	
		if (errors.containsKey("description"))descriptionError=cabeceraError+errors.get("description")+colaError;	
	}
%>
<body>
	<h1>Add person</h1>
	<form method="post" action="AddPerson">
		<p>Person ID:<input type="text" name="pid" value="<%=pid%>"/><%=pidError%></p>
		<p>Name:<input type="text" name="name" value="<%=name%>"/><%=nameError%></p>
		<p>E-mail (blank for none):<input type="email" name="email" value="<%=email%>"/><%=emailError%></p>
		<p>Task (leave blank to finish):<input type="text" name="task" value="<%=task%>"/><%=taskError%></p>
		<h3>Fill data only if exists a task</h3>	
		<p>Is this a personal,home or work task?:<input type="text" name="typetask" value="<%=typetask%>"/><%=typeError%></p>	
		<p>Has the task a finish date? (leave blank if it isnt) :<input type="text" name="date" value="<%=date%>"/><%=dateError%></p>
		<p>Insert a little description of the task:<input type="textarea" name="description" value="<%=description%>"/><%=descriptionError%></p>
		<p align="center"><input type="submit" value="Registrar"/>
		<input type="reset"/></p>
	</form>
</body>
</html>