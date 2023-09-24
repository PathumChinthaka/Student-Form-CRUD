import { Student } from "../Model/Student.js";

export class StudentController {

  constructor() {
    $('#Add-btn').on('click', () => {
      this.saveStudent();
      this.clearInputFields();
    });

    this.getStudentData();
  }

  dataValidation() {
    var name = new RegExp("^[a-zA-Z]+(([a-zA-Z ])?[a-zA-Z]*)*$");
    var address = new RegExp(
      "^([a-zA-Z\u0080-\u024F]+(?:. |-| |'))*[a-zA-Z\u0080-\u024F]*$"
    );
    var email = new RegExp(
      "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-]+)(\\.[a-zA-Z]{2,5}){1,2}$"
    );
    return !name.test($("#name").val())
      ? false
      : !address.test($("#city").val())
        ? false
        : !email.test($("#email").val())
          ? false
          : true;
  }

  saveStudent() {

    const studentObj = JSON.stringify(
      new Student(
        $("#sid").val(),
        $("#name").val(),
        $("#city").val(),
        $("#email").val(),
        $("#level").val()
      )
    );

    console.log(studentObj);

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

  clearInputFields(){
    $("#sid").val("");
    $("#name").val("");
    $("#city").val("");
    $("#email").val("");
    $("#level").val("");
  }
}

new StudentController();