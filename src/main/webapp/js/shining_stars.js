const windowWidth = screen.width;
const windowHeight = screen.height;

function getRandomValue(max) {
    return Math.floor(Math.random() * max);
}

function createStar() {
    const x = getRandomValue(windowWidth);
    const y = getRandomValue(windowHeight);

    const style = ['style1', 'style2', 'style3'];
    const opacity = ['opacity1', 'opacity2', 'opacity3'];
    const twinkle = ['twinkle1', 'twinkle1', 'twinkle1', 'twinkle2', 'twinkle2', 'twinkle3', 'twinkle4'];

    const _s = getRandomValue(3);
    const _o = getRandomValue(3);
    const _t = getRandomValue(7);

    const className = 'star ' + style[_s] + ' ' + opacity[_o] + ' ' + twinkle[_t];

    const starElement = document.createElement('div');
    starElement.className = className;
    starElement.style.top = y + 'px';
    starElement.style.left = x + 'px';

    document.body.appendChild(starElement);
}

// Create 100 stars
for (let i = 0; i < 100; i++) {
    createStar();
}

 // login_model.js 코드 추가
 const openBtn = document.querySelector('.join');
 const closeBtn = document.querySelector('.button-close');
 const modal = document.querySelector('.model-login');
 
 if (openBtn) {
     openBtn.addEventListener('click', showModal);
 }
 
 if (closeBtn) {
     closeBtn.addEventListener('click', closeModal);
 }
 
 function showModal() {
     if (modal) {
         modal.classList.remove('hidden');
         modal.classList.add('visible');
     }
 }
 
 function closeModal() {
     if (modal) {
         modal.classList.add('hidden');
         modal.classList.remove('visible');
     }
    }