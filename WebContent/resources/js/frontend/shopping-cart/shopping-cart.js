/**
 * 
 */

const addToCart = (bookId) => {
	const form = document.createElement("form");
	form.method = "POST";
	form.action = `shopping-cart?id=${ bookId }`
	document.body.appendChild(form);
	form.submit();
	document.body.removeChild(form);	
}

const removeBook = (bookId) => {
	const form = document.createElement("form");
	form.method = "POST";
	form.action = `shopping-cart/remove?id=${ bookId }`;
	document.body.appendChild(form);
	form.submit();
	document.body.removeChild(form);	
}

const updateCart = (bookId) => {
	const quantity = document.getElementById("quantity-input").value;
	const form = document.createElement("form");
	form.method = "POST";
	form.action = `shopping-cart/update?id=${ bookId }&quantity=${ quantity }`
	document.body.appendChild(form);
	form.submit();
	document.body.removeChild(form);	
}


const placeOrder = (e) => {
	e.preventDefault();
	const form = document.createElement("form");
	form.method = "POST";
	form.action = `shopping-cart/place-order`
	document.body.appendChild(form);
	form.submit();
	document.body.removeChild(form);	
}

const clearCart = () => {
	const form = document.createElement("form");
	form.method = "POST";
	form.action = `shopping-cart/clear`
	document.body.appendChild(form);
	form.submit();
	document.body.removeChild(form);	
}

function capitalizeFirstLetter(string) {
	return string.charAt(0).toUpperCase() + string.slice(1);
}


const validateInformation = () => {
	let nameInputArray = [
		"recipientName",
		"recipientPhone",
		"address",
		"city",
		"country",
		"zipCode"
	];
	
	for (let i = 0; i < nameInputArray.length; i++) {
		let inputText = document.getElementById(nameInputArray[i]);

		if (inputText.value.length === 0) {
			alert(capitalizeFirstLetter(nameInputArray[i]) + " is required !!!");
			inputText.focus();
			return false;
		}
	}
	return true;
}