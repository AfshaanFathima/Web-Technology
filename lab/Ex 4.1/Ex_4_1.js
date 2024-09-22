function validateForm() {
    const parentName = document.getElementById("parentName").value;
    const childName = document.getElementById("childName").value;
    const email = document.getElementById("email").value;
    const phone = document.getElementById("phone").value;
    const childAge = document.getElementById("childAge").value;
    const program = document.getElementById("program").value;

    // Check if phone number is valid
    if (phone.length !== 10 || isNaN(phone)) {
        alert("Please enter a valid 10-digit phone number.");
        return false;
    }

    // Check if age is 1 or above
    if (childAge <=1 ) {
        alert("Child's age must be 1 or above");
        return false;
    }

    // Check if a program is selected
    if (program === "") {
        alert("Please select a program.");
        return false;
    }

    // If all validations pass
    alert("Form submitted successfully!");
    return true;
}
