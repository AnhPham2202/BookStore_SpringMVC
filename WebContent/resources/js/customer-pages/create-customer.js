/**
 * 
 */
let nameInputArray = [
	"email",
	"fullName",
	"password",
	"confirmPassword",
	"phone",
	"address",
	"city",
	"country",
	"zipCode"
];

const validateFormInput = () => {
	for (let i = 0; i < nameInputArray.length; i++) {
		let inputText = document.getElementById(nameInputArray[i]);

		if (inputText.value.length === 0) {
			alert(capitalizeFirstLetter(nameInputArray[i]) + " is required !!!");
			inputText.focus();
			return false;
		}

	}

	if (document.getElementById("password").value !== document.getElementById("confirmPassword").value) {
		alert(capitalizeFirstLetter("Please enter the correct password"));
		document.getElementById("confirmPassword").focus();
		return false;
	}

	return true;
}

function capitalizeFirstLetter(string) {
	return string.charAt(0).toUpperCase() + string.slice(1);
}
