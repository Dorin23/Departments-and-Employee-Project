function addDepartment() {
    var departmentName = $('#departmentName').val();
    var departmentData = {
        name: departmentName
    };

    sendRequest("POST", "create-department", departmentData, addDepartmentSuccessHandler, errorHandler);
}

function addDepartmentSuccessHandler(respData) {
    alert("Department added successfully: " + JSON.stringify(respData));
    // Optional: Clear the input after successful addition
    $('#departmentName').val('');
}
