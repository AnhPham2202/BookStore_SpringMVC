const deleteBook = (id) => {
	if (confirm("Do you want delete this book?")) {
		let deleteForm = document.createElement("form");
		deleteForm.action= `delete-book/${ id }`;
		deleteForm.method = "POST";
		document.body.appendChild(deleteForm);
		deleteForm.submit();
		document.body.removeChild(deleteForm);
	}
}