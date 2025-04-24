const slidesContainer = document.getElementById("slides");
const totalSlides = document.querySelectorAll("#slides > a").length;
var prev = document.getElementById("prev");
var next = document.getElementById("next");

let current = 0;


function updateSlidePosition() {
  slidesContainer.style.transform = `translateX(-${current * 100}%)`;
}

prev.onclick = function () {
  current = (current > 0) ? current - 1 : totalSlides - 1;
  updateSlidePosition();
}

next.onclick = function () {
  current = (current < totalSlides - 1) ? current + 1 : 0;
  updateSlidePosition();
}

setInterval(() => {
  current = (current < totalSlides - 1) ? current + 1 : 0;
  updateSlidePosition();
}, 3000);