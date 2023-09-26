import { Student } from "../Model/Student.js";

export class StudentController {

  constructor() {
    $('#Add-btn').on('click', () => {
      this.saveStudent();
      this.clearInputFields();
    });
    $('#update-btn').on('click', () => {
      this.updateStudent();
      this.clearInputFields();
    });

    $('#delete-btn').on('click', () => {
      this.deleteStudent();
      this.clearInputFields();
    });
    this.getSelectedRow();
    this.getStudentData();
  }

  dataValidation() {
    var sid = new RegExp("/^(S)[0-9]{1,3}$/")
    var name = new RegExp("^[a-zA-Z]+(([a-zA-Z ])?[a-zA-Z]*)*$");
    var address = new RegExp(
      "^([a-zA-Z\u0080-\u024F]+(?:. |-| |'))*[a-zA-Z\u0080-\u024F]*$"
    );
    var email = new RegExp(
      "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-]+)(\\.[a-zA-Z]{2,5}){1,2}$"
    );
    return !sid.test($("#sid").val())
      ? false
      : !name.test($("#name").val())
        ? false
        : !address.test($("#city").val())
          ? false
          : !email.test($("#email").val())
            ? false
            : true;
  }

  studentObject() {
    const student = JSON.stringify(
      new Student(
        $("#sid").val(),
        $("#name").val(),
        $("#city").val(),
        $("#email").val(),
        $("#level").val()
      )
    );
    return student;
  }

  saveStudent() {

    let studentObj = this.studentObject();

    $.ajax({
      url: "http://localhost:8082/student/api/save",
      type: "POST",
      data: studentObj,
      dataType: "json",
      headers: {
        "Content-Type": "application/json"
      },
      success: (response) => {
        console.log("hellow");
        this.getStudentData();
      },
      error: (message) => {
        console.log(message);
      }
    });
  }

  getStudentData() {

    $.ajax({
      url: "http://localhost:8082/student/api/get",
      type: "GET",
      dataType: "json",
      headers: {
        "Content-Type": "application/json"
      },
      success: (response) => {
        console.log(response);
        this.loadStudentData(response);
      },
      error: (message) => {
        console.log(message);
      }
    });

  }

  updateStudent() {

    let studentObj = this.studentObject();

    $.ajax({
      url: "http://localhost:8082/student/api/update",
      type: "PUT",
      data: studentObj,
      dataType: "json",
      headers: {
        "Content-Type": "application/json"
      },
      success: (response) => {
        response.code === 200 ? this.getStudentData() : console.log('not ok');
      },
      error: (message) => {
        console.log(message);
      }
    });
  }


  deleteStudent() {

    let studentObj = this.studentObject();

    $.ajax({
      url: "http://localhost:8082/student/api/delete",
      type: "DELETE",
      data: studentObj,
      dataType: "json",
      headers: {
        "Content-Type": "application/json"
      },
      success: (response) => {
        confirm('delete this data ?');
        response.code === 200 ? this.getStudentData() : console.log('not ok');
      },
      error: (message) => {
        console.log(message);
      }
    });
  }

  loadStudentData(dataArray) {

    $('#student-tbl #student_Tbody tr td').remove();

    dataArray.map((value) => {
      let row = "<tr>" +
        "<td>" + value.sid + "</td>" +
        "<td>" + value.name + "</td>" +
        "<td>" + value.city + "</td>" +
        "<td>" + value.email + "</td>" +
        "<td>" + value.level + "</td>" +
        "</tr>";

      $('#student-tbl #student_Tbody').append(row);
    });
  }

  getSelectedRow() {
    $('#student_Tbody').on('click', 'tr', (event) => {
      $('#sid').val($(event.target).closest('tr').find('td').eq(0).text());
      $('#name').val($(event.target).closest('tr').find('td').eq(1).text());
      $('#city').val($(event.target).closest('tr').find('td').eq(2).text());
      $('#email').val($(event.target).closest('tr').find('td').eq(3).text());
      $('#level').val($(event.target).closest('tr').find('td').eq(4).text());
    });
  }

  clearInputFields() {
    $("#sid").val("");
    $("#name").val("");
    $("#city").val("");
    $("#email").val("");
    $("#level").val("");
  }
}

new StudentController();