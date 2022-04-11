/**
 * 
 */

let nameInputArray = [
	"email",
	"password",
];


const validateFormInput = () => {
	
	for (let i=0; i<nameInputArray.length; i++) {
		let inputText = document.getElementById(nameInputArray[i]);
		
		
		if (inputText.value.length === 0) {
			alert(capitalizeFirstLetter(nameInputArray[i]) + " is required !!!");
			inputText.focus();
			return false;
		}

	}
	return true;
}

function capitalizeFirstLetter(string) {
	return string.charAt(0).toUpperCase() + string.slice(1);
}