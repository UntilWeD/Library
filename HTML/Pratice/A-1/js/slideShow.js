const slides = document.querySelectorAll('.slide');
const prevBtn = document.getElementById('prevBtn');
const nextBtn = document.getElementById('nextBtn');

let currentIndex = 0;
let intervalId;

// 초기 슬라이드 활성화
function showSlide(index) {
  slides.forEach((slide, i) => {
    slide.classList.remove('active');
    // 접근성을 위해 aria-hidden도 설정할 수 있음
  });
  slides[index].classList.add('active');
}

// 이전 슬라이드
function showPrevSlide() {
  currentIndex = (currentIndex - 1 + slides.length) % slides.length;
  showSlide(currentIndex);
}

// 다음 슬라이드
function showNextSlide() {
  currentIndex = (currentIndex + 1) % slides.length;
  showSlide(currentIndex);
}

// 자동 슬라이드
function startAutoSlide() {
  intervalId = setInterval(showNextSlide, 3000);
}

// 슬라이드 멈춤
function stopAutoSlide() {
  clearInterval(intervalId);
}

// 버튼에 이벤트 연결
prevBtn.addEventListener('click', () => {
  stopAutoSlide();
  showPrevSlide();
  startAutoSlide();
});

nextBtn.addEventListener('click', () => {
  stopAutoSlide();
  showNextSlide();
  startAutoSlide();
});

// 첫 슬라이드 + 자동시작
showSlide(currentIndex);
startAutoSlide();
