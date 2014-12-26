$('#list').click(
	listTasks();
);
$('#subadd').click(
	addTasks();
);
$('#subaddU').click(
	updateTask();
);
$('#remove').click(
	removeTask();
);

function updateTask(){
	jQuery.ajax({
			type: 'PUT',
			url: "/toDo/"+$('#idU'),
			data: {"title":$('#titleU'),"priority":$('#priorityU'),"date":$('#dateU'),"description":$('#descriptionU')}, 
			dataType: "json",
			success : listTasks();
		});
}	

function listTasks(){
	jQuery.ajax({
		type: 'GET',
		url: "/toDo",
		dataType: "json",
		success : showTasks(tasks);
	});
}	

function removeTasks(){
	jQuery.ajax({
		type: 'DELETE',
		url: "/toDo/"+$('#idR'),
		dataType: "json",
		success : listTasks();
	});
}

function addTasks(){
	jQuery.ajax({
		type: 'POST',
		url: "/toDo",
		data: {"title":$('#title'),"priority":$('#priority'),"date":$('#date'),"description":$('#description')}, 
		dataType: "json",
		success : function () {
			$('#title').empty(); $('#priority').empty(); $('#date').empty(); $('#description').empty();
			listTasks();
		}
	});
}	
	
function showTasks(tasks){
	$('#taskList').empty();
	for(int i=0; i<tasks.length();i++){		
		$('#taskList').append(tasks[i]);
	}

}

}