/**
 * 
 */

const removeOrder = (orderId) => {
	if (confirm("Do you want delete this order?")) {
		let deleteForm = document.createElement("form");
		deleteForm.action= `delete-order?id=${ orderId }`;
		deleteForm.method = "POST";
		document.body.appendChild(deleteForm);
		deleteForm.submit();
		document.body.removeChild(deleteForm);
	}
}