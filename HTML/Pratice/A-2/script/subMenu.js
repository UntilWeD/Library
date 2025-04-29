const popup = document.getElementById("layerPopup");
const openPopup = document.getElementById("popupOpen");
const closePopup = document.getElementById("popupClose");

openPopup.addEventListener('click', (e) => {
  e.preventDefault(); // 링크 이동 방지?
  popup.style.display = "flex";
});

closePopup.addEventListener('click', (e) => {
  popup.style.display = "none";
});

// 바깥 클릭시 꺼짐
popup.addEventListener('click', (e) => {
  if (e.target === popup) {
    popup.style.display = "none";
  }
});