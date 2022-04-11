/**
 * 
 */

const onSearch = (event) => {
	event.preventDefault()
	const value = document.getElementById("searchInput").value;
	
	let form = document.createElement("form");
	form.action = `frontend/search?keyword=${value}`;
	form.method = 'POST';
	document.body.appendChild(form);
	console.log(form.method)
	form.submit();
	document.body.removeChild(form);

	
}

const onSearchSubmit = (e) => {
	const form = e.target
	const value = document.getElementById("searchInput").value;
	
	form.action = `frontend/search?keyword=${value}`;
	form.submit();

}