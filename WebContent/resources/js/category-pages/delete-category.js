const deleteCategory = (id) => {
	if (confirm(`"Do you want delete the catogory with id ${id}?`)) {
	const deleteForm = document.createElement("form");
	deleteForm.action = `delete-category/${id}`;
	deleteForm.method = "POST";
	document.body.appendChild(deleteForm);
	deleteForm.submit();
	document.body.removeChild(deleteForm);		
	}
}