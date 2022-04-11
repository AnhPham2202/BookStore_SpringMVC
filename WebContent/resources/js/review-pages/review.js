/**
 * 
 */

const removeReview = (id) => {
	if (confirm(`"Do you want delete the review with id ${id}?`)) {
	const deleteForm = document.createElement("form");
	deleteForm.action = `remove-review?id=${id}`;
	deleteForm.method = "POST";
	document.body.appendChild(deleteForm);
	deleteForm.submit();
	document.body.removeChild(deleteForm);		
	}
}