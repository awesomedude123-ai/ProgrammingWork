
var phone;
var names;
var email;
var age;
var grade;
function Phone() {
    let num = document.getElementById("tbPhone").value;
    if (num == null || num == "") {
        alert("Phone input is empty. Please enter a Phone Number.");
        return false;
    } else if (num.length != 12) {
        alert("Invalid Input! Please enter a valid Phone Number Value.");
        return false;
    } else {
        phone = "";
        for (let i = 0; i < num.length; i++) {
            var character = num[i];
            var numbers = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
            if((i==3 || i==7) && (character=="-")){
                phone = phone + character;
            }else if(character in numbers){
                phone = phone + character;
            } else {
                alert("Invalid Input! Please enter a valid Phone Number Value.");
                phone = "";
                return false;
            }//end if else statement
        }

    }//end for loop
    return true;


}//end function

function Name() {
    let input = document.getElementById("tbName").value;
    let letters = /^[A-Za-z\s]*$/;
    if (input == null || input == "") {
        alert("Name input is empty. Please enter a Name.");
        return false;
    } else if (letters.test(input)) {
        names = input;
        return true;
    } else {
        alert("Invalid Input! Please enter a valid Name Value.");
        return false;
    }
}

function Email() {
    var input = document.getElementById("tbEmail").value;
    var letters = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (input == null || input == "") {
        alert("Email input is empty. Please enter a Email.");
        return false;
    } else if (input.match(letters)) {
        email = input;
        return true;
    } else {
        alert("Invalid Input! Please enter a valid Email.");
        return false;
    }
}

function Age() {
    let input = document.getElementById("tbAge").value;
    if (input == null || input == "") {
        alert("Age input is empty. Please enter a Age value.");
        return false;
    } else if (isNaN(input)) {
        alert("Invalid Age! Please enter a valid Age Value.");
        return false;
    } else {
        age = input;
        return true;
    }


}

function Grade() {
    let input = document.getElementById("tbGrade").value;
    if (input == null || input == "") {
        alert("Grade input in empty. Please enter a Grade value.");
        return false;
    } else if (isNaN(input)) {
        alert("Invalid Grade! Please enter a valid Grade Value.");
        return false;
    } else {
        grade = input;
        return true;
    }
}

function Submit() {
    let isName = Name();
    if (isName == true) {
        let isPhone = Phone();
        if (isPhone == true) {
            let isEmail = Email();
            if (isEmail == true) {
                let isAge = Age();
                if (isAge == true) {
                    let isGrade = Grade();
                    if (isGrade == true) {
                        let str = "Number=" + phone + "\nName=" + names + "\nEmail=" + email + "\nAge=" + age + "\nGrade=" + grade
                        if (confirm(str) == true) {
                            document.getElementById("phone").innerHTML = phone;
                            document.getElementById("name").innerHTML = names;
                            document.getElementById("email").innerHTML = email;
                            document.getElementById("age").innerHTML = age;
                            document.getElementById("grade").innerHTML = grade;
                        };
                    }
                }
            }
        }
    }
    document.getElementById("tbPhone").value = "";
    document.getElementById("tbName").value = "";
    document.getElementById("tbEmail").value = "";
    document.getElementById("tbAge").value = "";
    document.getElementById("tbGrade").value = "";
    document.getElementById("SubmitButton").disabled = true;

}

function Reset() {
    phone = "";
    names = "";
    email = "";
    age = "";
    grade = "";
    document.getElementById("phone").innerHTML = "...";
    document.getElementById("name").innerHTML = "...";
    document.getElementById("email").innerHTML = "...";
    document.getElementById("age").innerHTML = "...";
    document.getElementById("grade").innerHTML = "...";
    document.getElementById("tbPhone").value = "";
    document.getElementById("tbName").value = "";
    document.getElementById("tbEmail").value = "";
    document.getElementById("tbAge").value = "";
    document.getElementById("tbGrade").value = "";

    document.getElementById("SubmitButton").disabled = true;
    document.getElementById("ResetButton").disabled = true;
}