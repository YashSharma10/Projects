document.addEventListener("DOMContentLoaded", function () {
    let input = document.getElementById("input");
    let addTaskBtn = document.getElementById("addTask");
    let clearAllBtn = document.getElementById("clearAll");
    let taskList = document.getElementById("taskList");
    let totalTasksSpan = document.getElementById("totalTasks");
    let completedTasksSpan = document.getElementById("completedTasks");

    // Load tasks from local storage
    loadTasks();

    // Event listener for adding a task
    addTaskBtn.addEventListener("click", function () {
        addTask();
    });

    // Event listener for clearing all tasks
    clearAllBtn.addEventListener("click", function () {
        clearAllTasks();
    });

    // Event listener for completing or deleting a task
    taskList.addEventListener("click", function (event) {
        handleTaskAction(event);
    });

    // Function to add a new task
    function addTask() {
        let taskText = input.value.trim();
        if (taskText !== "") {
            let taskItem = document.createElement("li");
            taskItem.innerHTML = `
                <span>${taskText}</span>
                <button class="delete">Delete</button>
            `;
            taskList.appendChild(taskItem);
            input.value = "";
            updateTaskCount();
            saveTasks();
        }
    }

    // Function to clear all tasks
    function clearAllTasks() {
        taskList.innerHTML = "";
        updateTaskCount();
        saveTasks();
    }

    // Function to handle task completion or deletion
    function handleTaskAction(event) {
        let target = event.target;
        if (target.classList.contains("delete")) {
            // Delete task
            let taskItem = target.parentElement;
            taskItem.remove();
            updateTaskCount();
            saveTasks();
        } else {
            // Mark task as completed
            target.classList.toggle("completed");
            updateTaskCount();
            saveTasks();
        }
    }

    // Function to update the task count
    function updateTaskCount() {
        let totalTasks = taskList.children.length;
        let completedTasks = document.querySelectorAll(".completed").length;

        totalTasksSpan.textContent = totalTasks;
        completedTasksSpan.textContent = completedTasks;
    }

    // Function to save tasks to local storage
    function saveTasks() {
        localStorage.setItem("tasks", taskList.innerHTML);
    }

    // Function to load tasks from local storage
    function loadTasks() {
        let savedTasks = localStorage.getItem("tasks");
        if (savedTasks) {
            taskList.innerHTML = savedTasks;
            updateTaskCount();
        }
    }
});
