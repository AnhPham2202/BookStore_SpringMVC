let nameInputArray = [
	"title",
	"author",
	"isbn",
	"publish-date",
	"price",
	"description"
];


const validateFromInput = () => {
	let inputFile = document.getElementById("book-img");
	if (!inputFile.files[0]) {
		alert("Image is required !!!");
		return false;
	}
	
	for (let i=0; i<nameInputArray.length; i++) {
		let inputText = document.getElementById(nameInputArray[i]);
		
		if (nameInputArray[i] === "publish-date") {
			if(!isGoodDate(inputText.value)) {
				alert("Date is not MM/dd/yyyy format !!!");
				return false;
			}
		}
		
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

function isGoodDate(dt){
    var reGoodDate = /^((0?[1-9]|1[012])[- /.](0?[1-9]|[12][0-9]|3[01])[- /.](19|20)?[0-9]{2})*$/;
    return reGoodDate.test(dt);
}

function previewImg() {
	const inputFile = document.getElementById("book-img");
	const preview = document.getElementById("preview");
	const srcData = URL.createObjectURL(inputFile.files[0]);
	preview.src = srcData;
	preview.onload = URL.revokeObjectURL(inputFile.src);
}