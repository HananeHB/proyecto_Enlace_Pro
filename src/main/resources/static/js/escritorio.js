let chartInstance = null;

function updateChartTheme(isLight) {
    const textColor = isLight ? '#0f172a' : 'rgba(255, 255, 255, 0.6)';
    const gridColor = isLight ? 'rgba(0, 15, 155, 0.05)' : 'rgba(255, 255, 255, 0.05)';
    if (chartInstance) {
        chartInstance.options.scales.x.ticks.color = textColor;
        chartInstance.options.scales.y.ticks.color = textColor;
        chartInstance.options.scales.y.grid.color = gridColor;
        chartInstance.update();
    }
}

document.addEventListener("DOMContentLoaded", () => {
    const { alumnos, idiomas, totalTareas } = window.dashboardData;
    const ctx = document.getElementById("chartIdiomas").getContext("2d");

    document.getElementById("stat-alumnos").innerText = Array.isArray(alumnos) ? alumnos.length : 0;
    document.getElementById("stat-idiomas").innerText = Array.isArray(idiomas) ? idiomas.length : 0;
    document.getElementById("stat-tareas").innerText = totalTareas || 0;

    const labels = Array.isArray(idiomas) ? idiomas.map(i => i.nombre) : [];
    const dataCounts = Array.isArray(idiomas) ? idiomas.map(idioma =>
        Array.isArray(alumnos) ? alumnos.filter(a => a.idiomaId === idioma.id).length : 0
    ) : [];

    const createGradients = (count) => {
        const colors = [['#4d59ff', '#000f9b'], ['#ff4d4d', '#eb0000'], ['#c766ff', '#a000eb']];
        return Array.from({ length: count }, (_, i) => {
            const pair = colors[i % colors.length];
            const grad = ctx.createLinearGradient(0, 0, 0, 400);
            grad.addColorStop(0, pair[0]);
            grad.addColorStop(1, pair[1]);
            return grad;
        });
    };

    const barGradients = createGradients(labels.length);

    chartInstance = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                label: 'Alumnos',
                data: dataCounts,
                backgroundColor: barGradients,
                borderRadius: 12,
                borderSkipped: false,
                borderColor: 'rgba(255, 255, 255, 0.2)',
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            plugins: {
                legend: { display: false },
                tooltip: {
                    backgroundColor: 'rgba(8, 11, 22, 0.95)',
                    padding: 12,
                    cornerRadius: 12,
                    titleFont: { weight: 'bold' },
                    backdropFilter: 'blur(4px)'
                }
            },
            scales: {
                y: {
                    beginAtZero: true,
                    grid: { color: 'rgba(255, 255, 255, 0.05)', drawBorder: false },
                    ticks: { precision: 0 }
                },
                x: { grid: { display: false } }
            }
        }
    });

    const tareasHoy = [
        { title: "Reunión de coordinación", start: "09", end: "10", color: "#4d59ff" },
        { title: "Revisión administrativa", start: "11", end: "12", color: "#c766ff" }
    ];

    const listaTareas = document.getElementById("today-events-list");
    listaTareas.innerHTML = tareasHoy.map(e => `
        <div class="task-card flex items-center gap-4 p-4 rounded-2xl transition-all duration-100 mb-3 border border-white/5 hover:-translate-y-1 shadow-sm">
            <div class="w-2.5 h-2.5 rounded-full" style="background-color: ${e.color}; box-shadow: 0 0 12px ${e.color}cc;"></div>
            <div class="flex-1 overflow-hidden">
                <p class="text-sm font-semibold truncate">${e.title}</p>
                <p class="text-[11px] opacity-60">${e.start}:00 - ${e.end}:00</p>
            </div>
        </div>
    `).join('');

    updateChartTheme(document.getElementById('mainBody').classList.contains('light-mode'));
});