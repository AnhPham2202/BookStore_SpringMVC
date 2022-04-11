/**
 * 
 */

const deleteCustomer = (id) => {
	if (confirm(`"Do you want delete the customer with id ${id}?`)) {
	const deleteForm = document.createElement("form");
	deleteForm.action = `delete-customer?id=${id}`;
	deleteForm.method = "POST";
	document.body.appendChild(deleteForm);
	deleteForm.submit();
	document.body.removeChild(deleteForm);		
	}
}