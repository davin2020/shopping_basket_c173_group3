/**
 * 
 */

function addToCartShake() {
	let cart = document.getElementById("cart-icon");
	cart.classList.add("shake");
	setTimeout(function() {
		cart.classList.remove("shake");
	}, 700);
}