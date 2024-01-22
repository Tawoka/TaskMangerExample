const TASK_API = "http://localhost:8080/api/v1/task";

let taskMap = [];

function buildPage(){
    axios.defaults.headers.common["Access-Control-Allow-Origin"] = "*";
    buildTaskList().then((html) => {
        $("#table").html(html);
    });
}

function buildTableContent(list) {
    let html = "";
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
    return html;
}

function initializeTableWithHeader() {
    return `<table class="table" style="width: 50%; margin-left: 25%; min-width: 800px" xmlns="http://www.w3.org/1999/html">
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
}

function finalizeTable() {
    return "</tbody></table>";
}

function addTaskCreationButton() {
    return `<div style="width: 50%; margin-left: 25%; min-width: 800px">
        <button type="button" class="btn btn-primary" 
            style="width: 100%"
            onclick="createTask()">Add Task</button>
    </div>`;
}

async function buildTaskList() {
    const list = await initializeData();
    let html = initializeTableWithHeader();
    html += buildTableContent(list, html);
    html += finalizeTable();
    html += addTaskCreationButton();
    return html;
}

function buildNameInputField(task, id) {
    return `
        <div class="input-group mb-3">
            <input type="text" class="form-control" value="${task.name}"/>
            <button type="button" class="btn btn-outline-primary fa-solid fa-check" style="float: right" 
                onclick="save('${id}')" />
            <button type="button" class="btn btn-outline-primary fa-solid fa-rotate-left" style="float: right" 
                onclick="undo('${id}')"/>
        </div>
    `;
}

function switchToEditMode(id) {
    const task = taskMap[id];
    const html = buildNameInputField(task, id);
    const elementId = "#" + id;
    $(elementId).html(html);
}

function buildNameDisplayField(task) {
    return `
        <span>${task.name}</span>
        <button type="button" class="btn btn-outline-primary" style="float: right" 
                onclick="switchToEditMode('${task.id}')">
            <i class="fa-solid fa-pen-to-square"></i>
        </button>
    `;
}

function readValueFromInputField(elementId) {
    return $(elementId + " input").val();
}

function save(id) {
    const task = taskMap[id];
    const elementId = "#" + id;
    task.name = readValueFromInputField(elementId);
    updateTask(task);
    const html = buildNameDisplayField(task);
    $(elementId).html(html);
}

function undo(id) {
    const task = taskMap[id];
    const html = buildNameDisplayField(task);
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

function updatePriority(id, selection) {
    const elementId = "#" + id;
    const oldValue = taskMap[id].priority;
    const newValue = selection.value;
    let task = taskMap[id];
    task.priority = newValue;
    updateTask(task);
    $(elementId).parent().removeClass(getPriorityColorClass(oldValue));
    $(elementId).parent().addClass(getPriorityColorClass(newValue));
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

async function initializeData() {
    taskMap = [];
    const response = await axios.get(TASK_API);
    return response.data;
}

function updateTask(task) {
    axios.put(`${TASK_API}/${task.id}`, task)
        .then(response => {
            taskMap[task.id] = task;
        });
}

function deleteTask(id){
    axios.delete(`${TASK_API}/${id}`)
        .then(response => {
            buildPage();
        });
}
