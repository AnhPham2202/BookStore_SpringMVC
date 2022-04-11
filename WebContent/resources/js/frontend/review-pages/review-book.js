/**
 * 
 */
const star1 = document.getElementById("star1")
const star2 = document.getElementById("star2")
const star3 = document.getElementById("star3")
const star4 = document.getElementById("star4")
const star5 = document.getElementById("star5")

const updateRating = () => {
	const ratingValue = document.querySelectorAll(".checked").length;
	document.getElementById("rating").value = ratingValue;
	console.log(ratingValue, document.getElementById("rating").value )
}

star1.addEventListener("click", (e) => {
	e.preventDefault();
	star1.classList.add("checked")
	star2.classList.remove("checked")
	star3.classList.remove("checked")
	star4.classList.remove("checked")
	star5.classList.remove("checked")
	updateRating();
})

star2.addEventListener("click", (e) => {
	e.preventDefault();
	star1.classList.add("checked")
	star2.classList.add("checked")
	star3.classList.remove("checked")
	star4.classList.remove("checked")
	star5.classList.remove("checked")
		updateRating();

})

star3.addEventListener("click", (e) => {
	e.preventDefault();
	star1.classList.add("checked")
	star2.classList.add("checked")
	star3.classList.add("checked")
	star4.classList.remove("checked")
	star5.classList.remove("checked")
		updateRating();

})


star4.addEventListener("click", (e) => {
	e.preventDefault();
	star1.classList.add("checked")
	star2.classList.add("checked")
	star3.classList.add("checked")
	star4.classList.add("checked")
	star5.classList.remove("checked")
		updateRating();

})

star5.addEventListener("click", (e) => {
	e.preventDefault();
	star1.classList.add("checked")
	star2.classList.add("checked")
	star3.classList.add("checked")
	star4.classList.add("checked")
	star5.classList.add("checked")
		updateRating();

})

