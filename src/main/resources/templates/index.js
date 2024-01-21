const TASK_API = "http://localhost:8080/api/v1/task";

let taskMap = [];

function buildPage(){
    axios.defaults.headers.common["Access-Control-Allow-Origin"] = "*";
    buildTaskList().then((html) => {
        $("#table").html(html);
    });
}

async function buildTaskList() {

    taskMap = [];
    const response = await axios.get(TASK_API);
    const list = response.data;

    console.log(list);

    let html = `<table class="table" style="width: 50%; margin-left: 25%; min-width: 800px" xmlns="http://www.w3.org/1999/html">
        <thead style="border-bottom: black 1em">
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Priority</th>
                <th scope="col">Done</th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
    `;

    for (let task of list) {
        taskMap[task.id] = task;
        let tableClass = getPriorityColorClass(task.priority);
        html += `<tr class="${tableClass}">
                <td id="${task.id}">
                    <span>${task.name}</span>
                    <button type="button" class="btn btn-outline-primary" style="float: right" 
                            onclick="switchToEditMode('${task.id}')">
                        <i class="fa-solid fa-pen-to-square"></i>
                    </button>
                </td>        
                <td>
                    <select class="form-select" aria-label="Default select example" onchange="updatePriority('${task.id}', this)">
                        ${buildPriorityOptions(task.priority)}
                    </select>            
                </td>        
                <td>
                    <input class="form-check-input" 
                        type="checkbox" ${task.done ? "checked" : ""} 
                        onclick="updateTaskStatus('${task.id}')">
                </td>
                <td>
                    <button type="button" class="btn btn-outline-primary fa-solid fa-trash-can"
                        onclick="deleteTask('${task.id}')">
                    </button>
                </td>
            </tr>        
        `;
    }

    html += "</tbody></table>";

    html += `<div style="width: 50%; margin-left: 25%; min-width: 800px">
        <button type="button" class="btn btn-primary" 
            style="width: 100%"
            onclick="createTask()">Add Task</button>
    </div>`;

    return html;
}

function switchToEditMode(id) {
    const task = taskMap[id];
    const html = `
        <div class="input-group mb-3">
            <input type="text" class="form-control" value="${task.name}"/>
            <button type="button" class="btn btn-outline-primary fa-solid fa-check" style="float: right" 
                onclick="save('${id}')" />
            <button type="button" class="btn btn-outline-primary fa-solid fa-rotate-left" style="float: right" 
                onclick="undo('${id}')"/>
        </div>
    `;
    const elementId = "#" + id;
    $(elementId).html(html);
}

function save(id) {
    const task = taskMap[id];
    const elementId = "#" + id;
    task.name = $(elementId + " input").val();
    updateTask(task);

    const html = `
        <span>${task.name}</span>
        <button type="button" class="btn btn-outline-primary" style="float: right" 
                onclick="switchToEditMode('${task.id}')">
            <i class="fa-solid fa-pen-to-square"></i>
        </button>
    `;

    $(elementId).html(html);
}

function undo(id) {
    const task = taskMap[id];
    const html = `
        <span>${task.name}</span>
        <button type="button" class="btn btn-outline-primary" style="float: right" 
                onclick="switchToEditMode('${task.id}')">
            <i class="fa-solid fa-pen-to-square"></i>
        </button>
    `;
    const elementId = "#" + id;
    $(elementId).html(html);
}

function buildPriorityOptions(taskPriority) {
    let html = "";
    const priorities = ["URGENT", "NORMAL", "LOW"];
    for (let priority of priorities) {
        html += `<option value="${priority}" ${taskPriority === priority ? "selected" : ""}>${priority.toLowerCase()}</option>`;
    }
    return html;
}

function updatePriority(id, selection) {
    const elementId = "#" + id;
    const oldValue = taskMap[id].priority;
    const newValue = selection.value;
    $(elementId).parent().removeClass(getPriorityColorClass(oldValue));
    $(elementId).parent().addClass(getPriorityColorClass(newValue));

    let task = taskMap[id];
    task.priority = newValue;
    updateTask(task);
}

function getPriorityColorClass(priority) {
    switch (priority) {
        case "URGENT":
            return "table-danger";
        case "NORMAL":
            return "table-info";
        default:
            return "table-light";
    }
}

function updateTask(task) {
    axios.put(`${TASK_API}/${task.id}`, task)
        .then(response => {
            taskMap[task.id] = task;
        });
}

function updateTaskStatus(id) {
    const task = taskMap[id];
    task.done = !task.done;
    updateTask(task);
}

function createTask(){
    const defaultTask = {
        priority: "NORMAL",
        name: "New Task",
        done: false
    }
    axios.post(TASK_API, defaultTask)
        .then(response => {
            buildPage();
        })
    ;
}

function deleteTask(id){
    axios.delete(`${TASK_API}/${id}`)
        .then(response => {
            buildPage();
        });
}