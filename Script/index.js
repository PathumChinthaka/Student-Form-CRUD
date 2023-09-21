import { Student } from "../Model/Student.js";

export class StudentController{

  constructor(){
    $('#Add-btn').click(function (e) { 

    });
  }

  dataValidation() {
      var name = new RegExp('^[a-zA-Z]+(([a-zA-Z ])?[a-zA-Z]*)*$');
      var address = new RegExp('^([a-zA-Z\u0080-\u024F]+(?:. |-| |\'))*[a-zA-Z\u0080-\u024F]*$');
      var email = new RegExp('^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-]+)(\\.[a-zA-Z]{2,5}){1,2}$');
      return !(name.test($('#name').val())) ? false : !address.test($('#city').val()) ? false : !email.test($('#email').val()) ? false : true;
  }

  saveStudent(){

     const studentObj=JSON.stringify(new Student(
        $('#name').val(),
        $('#city').val(),
        $('#email').val(),
        $('#level').val()
      ));

      $.ajax({
        type: "GET",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        url: "url",
        data:studentObj,
        success: function (response) {
          console.log(response);
        },
        error:(message)=>{
          console.log(message);
        }
      });

  }

}

new StudentController();
