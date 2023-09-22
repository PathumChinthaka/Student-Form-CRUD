import { Student } from "../Model/Student.js";

export class StudentController {

  constructor() {
    $('#Add-btn').on('click', () => {
      this.saveStudent();
    });
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
        $("#name").val(),
        $("#city").val(),
        $("#email").val(),
        $("#level").val()
      )
    );

    console.log(studentObj);

    $.ajax({
      url: "http://localhost:8080/student/api/hi",
      type: "GET",
      data: "",
      dataType: "",
      headers: {
          // "Content-Type": "application/json"
      },
      success: (response) => {
          console.log(response);
      },
      error: (message) => {
          console.log(message);
      }
  });
  }
}

new StudentController();
