const API_URL = "http://localhost:8080/students";

// Load students when page opens
window.onload = function () {
    loadStudents();
};

// Load all students
function loadStudents() {
    fetch(API_URL)
        .then(response => response.json())
        .then(data => {

            const table = document.getElementById("studentTable");
            table.innerHTML = "";

            data.forEach(student => {

                table.innerHTML += `
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.age}</td>
                        <td>${student.department}</td>
                        <td>
                            <button onclick="deleteStudent(${student.id})">
                                Delete
                            </button>
                        </td>
                    </tr>
                `;
            });

        });
}

// Add Student
function addStudent() {

    const student = {
        id: document.getElementById("id").value,
        name: document.getElementById("name").value,
        age: document.getElementById("age").value,
        department: document.getElementById("department").value
    };

    fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(student)
    })
    .then(response => response.text())
    .then(message => {

        alert(message);

        document.getElementById("id").value = "";
        document.getElementById("name").value = "";
        document.getElementById("age").value = "";
        document.getElementById("department").value = "";

        loadStudents();

    });

}

// Delete Student
function deleteStudent(id) {

    fetch(API_URL + "/" + id, {
        method: "DELETE"
    })
    .then(response => response.text())
    .then(message => {

        alert(message);
        loadStudents();

    });

}