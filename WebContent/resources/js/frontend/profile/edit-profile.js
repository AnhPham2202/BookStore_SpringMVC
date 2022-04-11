/**
 * 
 */
let nameInputArray = [
	"email",
	"fullName",
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

const enableEdit = () => {
	nameInputArray.forEach((el) => {
		let inputText = document.getElementById(el);
		inputText.readOnly = false;
		inputText.hidden = false;
		inputText.style.border = "1px solid"
	})
	
	let confirmWrapper = document.getElementById("confirmWrapper");
	confirmWrapper.style.display = "block";
	
	let confirmPassword = document.getElementById("confirmPassword");
	confirmPassword.hidden = false;
	
	let btnWrapper = document.getElementById("button-wrapper");
	btnWrapper.style.display = "block";
	
	let passwordWrapper = document.getElementById("passwordWrapper");
	passwordWrapper.style.display = "block";
}

function capitalizeFirstLetter(string) {
	return string.charAt(0).toUpperCase() + string.slice(1);
}
