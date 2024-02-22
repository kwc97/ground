'use strict'; 

const loginBtn = document.querySelector('.login');
const closeBtn = document.querySelector('.button-close');
const modal = document.querySelector('.model-login');
const overlay = document.querySelector('#overlay');

if (loginBtn) {
    loginBtn.addEventListener('click', showModal);
}

if (closeBtn) {
    closeBtn.addEventListener('click', closeModal);
}

function showModal() {
    if (modal && overlay) {
        overlay.style.display = 'block';
        modal.classList.remove('hidden');
        modal.classList.add('visible');
    } else {
        console.error("Modal or overlay element not found.");
    }
}

function closeModal() {
    if (modal && overlay) {
        overlay.style.display = 'none';
        modal.classList.add('hidden');
        modal.classList.remove('visible');
        window.location.href = '/login/login';
    } else {
        console.error("Modal or overlay element not found.");
    }
}