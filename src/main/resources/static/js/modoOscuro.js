function toggleTheme() {
    const body = document.getElementById('mainBody');
    const icon = document.getElementById('themeIcon');
    body.classList.toggle('light-mode');
    const isLight = body.classList.contains('light-mode');
    icon.innerText = isLight ? 'dark_mode' : 'light_mode';
    if (chartInstance) updateChartTheme(isLight);
}