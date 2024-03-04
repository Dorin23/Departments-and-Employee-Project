// Function to handle AJAX errors
function errorHandler(jqXHR, textStatus, errorThrown) {
    console.error("AJAX error: ", textStatus, 'Details: ', errorThrown, 'Response: ', jqXHR.responseText);
    alert("Request failed: " + textStatus + ", " + errorThrown + ", " + jqXHR.responseText);
}

// Function to display departments in the frontend
function displayDepartments(data) {
    var departmentList = $('#departmentList');
    departmentList.empty(); 
    data.forEach(function(department) {
        departmentList.append('<li>' + department.description + '</li>'); 
    });
}

// Function to send AJAX requests
function sendRequest(type, resource, data, successHandler, errorHandler) {
    var baseUrl = "http://localhost:8083"; 
    var url = baseUrl + '/' + resource; 

    $.ajax({
        type: type,
        url: url,
        contentType: "application/json",
        data: type === "GET" ? null : JSON.stringify(data),
        dataType: "json",
        success: successHandler,
        error: errorHandler
    });
}

// Function to add a new department
function addDepartment() {
    var departmentName = $('#departmentName').val().trim();
    var departmentId = $('#departmentId').val().trim();

    if (!departmentName || !departmentId) {
        alert("Please enter both Department ID and Department Name.");
        return;
    }

    var departmentData = {
        id: departmentId,
        description: departmentName
       
    };

    sendRequest("POST", "create-department", departmentData, function(data) {
        alert("Department added successfully: " + JSON.stringify(data));
        $('#departmentName').val('');
        $('#departmentId').val('');
        showDepartments();
    }, errorHandler);
}

// Function to rename a department
function renameDepartment(departmentId, newDepartmentName) {
    if (!departmentId || !newDepartmentName.trim()) {
        alert("Please enter both Department ID and the new Department Name.");
        return;
    }

    var updatedDepartmentData = {
        id: departmentId,
        description: newDepartmentName.trim()
        
    };

    sendRequest("PUT", departmentId, updatedDepartmentData, function(data) {
        alert("Department renamed successfully: " + JSON.stringify(data));
        showDepartments();
    }, errorHandler);
}

// Function to display all departments
function showDepartments() {
    sendRequest("GET", "all-departments", null, displayDepartments, errorHandler);
}

// Document ready function to bind event handlers
$(document).ready(function() {
    $('#addDepartmentButton').on('click', addDepartment);
    $('#showDepartmentsButton').on('click', showDepartments);
    $('#renameDepartmentButton').on('click', function() {
        var departmentId = $('#departmentIdToUpdate').val().trim();
        var newDepartmentName = $('#newDepartmentName').val().trim();
        renameDepartment(departmentId, newDepartmentName);
    });
});

