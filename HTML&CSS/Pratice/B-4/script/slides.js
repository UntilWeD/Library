const slides = document.querySelector("#slides");
const totalSolides = document.querySelectorAll("#slides > a").length;

let current = 0;

function updateSlidePosition(){
  slides.style.transform = `translateX(-${current * 100}%)`;
}

setInterval(() => {
  current = (current < totalSolides -1) ? current + 1 : 0;
  updateSlidePosition(); 
}, 3000);