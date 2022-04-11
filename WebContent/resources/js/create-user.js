const validateFromInput = () => {
	let email = document.getElementById('email');
	let fullName = document.getElementById('fullName');
	let password = document.getElementById('password');

	if (email.value.length === 0) {
		alert("Email is required !!!");
		email.focus();
		return false;	
	}
	
	if (fullName.value.length === 0) {
		alert("Full name is required !!!");
		fullName.focus();
		return false;	
	}
	
	if (password.value.length === 0) {
		alert("Password is required !!!");
		password.focus();
		return false;	
	}
	
	return true;
}