const deleteUser = (id) => {
	if (confirm("Do you want delete this user?")) {
		let deleteForm = document.createElement("form");
		deleteForm.action= `delete_user/${ id }`;
		deleteForm.method = "POST";
		document.body.appendChild(deleteForm);
		deleteForm.submit();
		document.body.removeChild(deleteForm);
	}
}