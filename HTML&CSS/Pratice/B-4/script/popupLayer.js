const firstNotice = document.querySelector('#notice li:first-child');
const popup = document.getElementById('popupLayer');
const closeBtn = document.querySelector('.btn');

firstNotice.addEventListener('click', () => {
  popup.classList.add('active');
});

closeBtn.addEventListener('click', () => {
  popup.classList.remove('active');
});