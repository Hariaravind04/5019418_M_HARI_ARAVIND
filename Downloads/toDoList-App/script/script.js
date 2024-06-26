document.addEventListener('DOMContentLoaded', function() {
    const taskInput=document.getElementById('task-input');
    const taskTime=document.getElementById('task-time');
    const taskList=document.getElementById('task-list');

    window.addTask=function() {
        const taskText=taskInput.value.trim();
        const time=taskTime.value;

        if(taskText && time){
            const taskItem=document.createElement('li');

            const taskInfo=document.createElement('div');
            taskInfo.classList.add('task-info');
            taskInfo.innerHTML=`<strong>Task:</strong> ${taskText}<br> <strong>Time:</strong> ${time}`;
            
            const removeButton = document.createElement('span');
            removeButton.textContent = '☒';
            removeButton.classList.add('remove-task');
            removeButton.onclick = function() {
                taskItem.remove();
            };
            taskItem.appendChild(taskInfo);
            taskItem.appendChild(removeButton);
            taskList.appendChild(taskItem);

            taskInput.value = '';
            taskTime.value = '';
        } else {
            alert('Please enter all the details (task and time).');
        }
    };
});
