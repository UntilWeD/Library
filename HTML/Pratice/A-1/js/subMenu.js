const mainMenus = document.querySelectorAll("nav > ul > li");

mainMenus.forEach(mainMenu => {
  const subMenu = mainMenu.querySelector(".subMenu");

  mainMenu.addEventListener("mouseenter", () => {
    if(subMenu){
      subMenu.style.display = "flex";
      subMenu.style.opacity = "1";
    }
  });

  mainMenu.addEventListener("mouseleave", () => {
    if(subMenu){
      subMenu.style.opacity = "0";
      setTimeout(() => {
        subMenu.style.display= "none";
      }, 300);// transition과 동일 시간
    }
  });

});