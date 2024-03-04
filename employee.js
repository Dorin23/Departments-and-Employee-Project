function errorHandler(jqXHR, textStatus, errorThrown) {
    console.error("AJAX error: ", textStatus, 'Details: ', errorThrown, 'Response: ', jqXHR.responseText);
    alert("Request failed: " + textStatus + ", " + errorThrown + ", " + jqXHR.responseText);
}
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
function displayEmployee(data) {
    var employeeList = $('#employeeList');
    employeeList.empty(); // Clear the list before adding new entries
    data.forEach(function(employee) {
        employeeList.append('<li>' + employee.name + '</li>'); 
    });
}
function showEmployee() {
    sendRequest("GET", "e", null, displayEmployee, errorHandler);
}
function addEmployee() {
    var employeeId = $('#employeeId').val();
    var employeeName = $('#employeeName').val().trim();
    var employeeEmail = $('#employeeEmail').val().trim();
    var departmentEmployeeId = $('#departmentEmployeeId').val();
    var departmentDescription = $('#departmentDescription').val().trim();
 
   
    departmentEmployeeId = parseInt(departmentEmployeeId, 10);
    if (isNaN(departmentEmployeeId)) {
        alert("Department ID must be a number.");
        return;
    }


    employeeId = parseInt(employeeId, 10);
    if (isNaN(employeeId)) {
        alert("Employee ID must be a number.");
        return;
    }

    var employeeData = {
        id: employeeId, 
        name: employeeName,
        email: employeeEmail,
        department: {
            id: departmentEmployeeId, 
            description: departmentDescription
        }
    };

    // Trimitere cerere AJAX
    sendRequest("POST", "create-employee", employeeData, function(data) {
        alert("Employee added successfully: " + JSON.stringify(data));
        // Resetare câmpuri
        $('#employeeId').val('');
        $('#employeeName').val('');
        $('#employeeEmail').val('');
        $('#departmentEmployeeId').val('');
        $('#departmentDescription').val('');
        showEmployee();
    }, errorHandler);
}
function deleteEmployee() {
    var employeeIdToDelete = $('#employeeIdToDelete').val();

    employeeIdToDelete = parseInt(employeeIdToDelete, 10);
    if (isNaN(employeeIdToDelete)) {
        alert("Employee ID must be a number.");
        return;
    }
    sendRequest("DELETE", "delete/" + employeeIdToDelete, null, function(data) {
        alert("Employee deleted successfully.");
        $('#employeeIdToDelete').val('');
        showEmployee();
    }, errorHandler);
}


$(document).ready(function() {
    $('#addEmployeeButton').on('click', addEmployee);
    console.log("Button clicked!");
    $('#showEmployeeButton').on('click', showEmployee);
    $('#deleteEmployeeButton').on('click', deleteEmployee);
});
