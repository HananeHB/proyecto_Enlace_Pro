function toggleLanguageMenu() {
    const menu = document.getElementById('languageMenu');
    menu.classList.toggle('hidden');
}

function setLanguage(lang) {
    const url = new URL(window.location.href);
    url.searchParams.set('lang', lang);
    window.location.href = url.toString();
}

window.addEventListener('click', function (e) {
    const container = document.getElementById('languageDropdownContainer');
    const menu = document.getElementById('languageMenu');
    if (container && !container.contains(e.target)) {
        menu.classList.add('hidden');
    }
});