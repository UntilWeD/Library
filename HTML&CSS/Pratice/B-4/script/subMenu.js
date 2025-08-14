const menu = document.querySelector('#mainMenu');
const subMenu = document.querySelector('.subMenu');

function showSubMenu() {
  subMenu.classList.add('visible');
  subMenu.style.display = 'flex';
}
function hideSubMenu() {
  subMenu.classList.remove('visible');
  subMenu.style.display = 'none';
}

menu.addEventListener('mouseenter', showSubMenu);
menu.addEventListener('mouseleave', hideSubMenu);
subMenu.addEventListener('mouseenter', showSubMenu);
subMenu.addEventListener('mouseleave', hideSubMenu);
