(function () {
    document.addEventListener('DOMContentLoaded', function () {
        const langBtn = document.getElementById('langBtn');
        const langMenu = document.getElementById('languageMenu');

        if (langBtn && langMenu) {

            langBtn.addEventListener('click', function (e) {
                e.stopPropagation();
                langMenu.classList.toggle('hidden');
            });

            window.addEventListener('click', function (e) {
                if (!langMenu.contains(e.target) && !langBtn.contains(e.target)) {
                    langMenu.classList.add('hidden');
                }
            });
        }
    });
})();

// Función para cambiar idioma (Thymeleaf URL)
function setLanguage(lang) {
    const url = new URL(window.location.href);
    url.searchParams.set('lang', lang);
    window.location.href = url.toString();
}