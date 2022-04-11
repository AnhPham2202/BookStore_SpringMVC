const validateFormInput = () => {
	let name = document.getElementById('name');

	if (name.value.length === 0) {
		alert("Name is required !!!");
		name.focus();
		return false;	
	}

	return true;
}