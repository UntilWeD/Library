const tabButtons = document.querySelectorAll(".tab-buttons button");
const tabContents = document.querySelectorAll(".tab-content");

tabButtons.forEach(button => {
  button.addEventListener("click", () => {
    // 버튼 active 토글
    tabButtons.forEach(btn => btn.classList.remove("active"));
    button.classList.add("active");

    //탭 콘텐츠 표시/숨김
    const targetId = button.getAttribute("data-tab");
    tabContents.forEach(content => {
      content.style.display = (content.id === targetId) ? "block" : "none";
    });
  });
});

const popup = document.getElementById('layerPopup');
const openBtn = document.getElementById('popupOpen');
const closeBtn = document.getElementById('popupClose');

openBtn.addEventListener('click', (e) => {
  e.preventDefault(); // 링크 이동방지
  popup.style.display = 'flex'; // block도 가능하지만 flex로 가운데 정렬한다.
});

closeBtn.addEventListener('click', () => {
  popup.style.display = 'none';
})