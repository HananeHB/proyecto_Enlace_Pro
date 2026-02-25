// --- Estado Global ---
let currentView = 'week';
let events = [
    { id: 1, title: 'Reunión Docentes', day: 1, start: 9, end: 10, color: 'blue' },
    { id: 2, title: 'Revisión Pagos', day: 2, start: 10, end: 11.5, color: 'purple' },
    { id: 3, title: 'Entrevista Alumno', day: 4, start: 9.5, end: 11, color: 'green' }
];

let labels = {};

function initLabels() {
    const textContainer = document.getElementById('js-texts');
    if (textContainer) {
        labels = {
            week: textContainer.getAttribute('data-label-week') || 'Semana',
            month: textContainer.getAttribute('data-label-month') || 'Día del Mes',
            lunes: textContainer.getAttribute('data-lunes') || 'Lunes',
            martes: textContainer.getAttribute('data-martes') || 'Martes',
            miercoles: textContainer.getAttribute('data-miercoles') || 'Miércoles',
            jueves: textContainer.getAttribute('data-jueves') || 'Jueves',
            viernes: textContainer.getAttribute('data-viernes') || 'Viernes',
            sabado: textContainer.getAttribute('data-sabado') || 'Sábado',
            domingo: textContainer.getAttribute('data-domingo') || 'Domingo'
        };
    } else {
        labels = {
            week: 'Semana', month: 'Día del Mes',
            lunes: 'Lun', martes: 'Mar', miercoles: 'Mie', jueves: 'Jue',
            viernes: 'Vie', sabado: 'Sab', domingo: 'Dom'
        };
    }
}

// --- Utilidades ---
function formatTime(decimalHour) {
    const h = Math.floor(decimalHour);
    const m = Math.round((decimalHour - h) * 60);
    return `${h.toString().padStart(2, '0')}:${m.toString().padStart(2, '0')}`;
}

// --- UI / Interactividad ---
function toggleLangMenu(event) {
    event.stopPropagation();
    const menu = document.getElementById('langMenu');
    if (menu) menu.classList.toggle('hidden');
}

function toggleTheme() {
    const body = document.getElementById('mainBody');
    const icon = document.getElementById('themeIcon');
    if (!body || !icon) return;

    const isLight = body.classList.toggle('light-mode');
    localStorage.setItem('theme', isLight ? 'light' : 'dark');
    icon.innerText = isLight ? 'dark_mode' : 'light_mode';
    renderCalendar();
}

function toggleModal(show) {
    const modal = document.getElementById('task-modal');
    if (show) {
        modal.classList.replace('hidden', 'flex');
        if (window.setViewInputs) setViewInputs();
    } else {
        modal.classList.replace('flex', 'hidden');
    }
}


function setView(view) {
    currentView = view;

    const btnWeek = document.getElementById('btn-week');
    const btnMonth = document.getElementById('btn-month');

    if (btnWeek && btnMonth) {
        if (view === 'week') {
            btnWeek.classList.add('active');
            btnMonth.classList.remove('active');
        } else {
            btnWeek.classList.remove('active');
            btnMonth.classList.add('active');
        }
    }

    renderCalendar();
}

function setViewInputs() {
    const container = document.getElementById('day-input-container');
    if (!container) return;

    if (currentView === 'month') {
        container.innerHTML = `
            <label class="form-label">${labels.month}</label>
            <input type="number" id="t-day" value="1" min="1" max="31" class="form-input">`;
    } else {
        container.innerHTML = `
            <label class="form-label">${labels.week}</label>
            <select id="t-day" class="form-input">
                <option value="1">${labels.lunes}</option>
                <option value="2">${labels.martes}</option>
                <option value="3">${labels.miercoles}</option>
                <option value="4">${labels.jueves}</option>
                <option value="5">${labels.viernes}</option>
                <option value="6">${labels.sabado}</option>
                <option value="7">${labels.domingo}</option>
            </select>`;
    }
}

function saveTask() {
    const titleObj = document.getElementById('t-title');
    const dayObj = document.getElementById('t-day');
    const startObj = document.getElementById('t-start');
    const endObj = document.getElementById('t-end');
    const colorObj = document.getElementById('t-color');

    if (!titleObj || !dayObj || !titleObj.value) return;

    events.push({
        id: Date.now(),
        title: titleObj.value,
        day: parseInt(dayObj.value),
        start: parseFloat(startObj.value),
        end: parseFloat(endObj.value),
        color: colorObj.value
    });

    toggleModal(false);
    renderCalendar();
}

// --- Renderizado Principal ---
function renderCalendar() {
    initLabels();
    const container = document.getElementById('calendar-content');
    if (!container) return;

    const daysShort = [
        labels.lunes.substring(0, 3),
        labels.martes.substring(0, 3),
        labels.miercoles.substring(0, 3),
        labels.jueves.substring(0, 3),
        labels.viernes.substring(0, 3),
        labels.sabado.substring(0, 3),
        labels.domingo.substring(0, 3)
    ];

    if (currentView === 'week') {
        let html = `<div class="grid grid-cols-[60px_repeat(7,1fr)] text-[11px]">
                    <div class="calendar-header-cell border-none opacity-50">Hora</div>
                    ${daysShort.map(d => `<div class="calendar-header-cell font-bold">${d}</div>`).join('')}
                    <div class="flex flex-col time-column">
                        ${[8, 9, 10, 11, 12, 13, 14, 15].map(h => `<div class="time-label" style="height:45px; line-height:45px;">${h}:00</div>`).join('')}
                    </div>`;

        for (let d = 1; d <= 7; d++) {
            html += `<div class="day-column" style="min-height:360px;">`;
            events.filter(e => e.day === d).forEach(ev => {
                const top = (ev.start - 8) * 45;
                const height = (ev.end - ev.start) * 45;
                html += `<div class="event event-${ev.color}" style="top: ${top}px; height: ${height}px; margin: 1px;">
                            <div class="font-bold truncate text-[10px]">${ev.title}</div>
                            <div class="text-[8px] opacity-70">${formatTime(ev.start)}</div>
                        </div>`;
            });
            html += `</div>`;
        }
        html += `</div>`;
        container.innerHTML = html;
    } else {
        let html = `<div class="grid grid-cols-7 gap-1 w-full">`;
        daysShort.forEach(d => html += `<div class="calendar-header-cell mb-1 text-[10px] py-1 opacity-60">${d}</div>`);

        for (let i = 1; i <= 31; i++) {
            let evs = events.filter(e => e.day === i).map(e => `
                        <div class="mini-event event-${e.color} p-0.5 mb-0.5 rounded text-[9px] leading-tight">
                            <div class="truncate font-medium">${e.title}</div>
                        </div>`).join('');
            html += `<div class="month-cell min-h-[70px] p-1 border border-white/5 bg-white/5 rounded-lg">
                        <span class="day-num text-[10px] font-bold opacity-30">${i}</span>
                        <div class="mt-1">${evs}</div>
                     </div>`;
        }
        html += `</div>`;
        container.innerHTML = html;
    }
}

// --- Control de Eventos al Cargar ---
function startApp() {
    renderCalendar();
}

if (document.readyState === "loading") {
    document.addEventListener("DOMContentLoaded", startApp);
} else {
    startApp();
}

window.onclick = function (event) {
    if (!event.target.closest('#langButton')) {
        const menu = document.getElementById('langMenu');
        if (menu) menu.classList.add('hidden');
    }
}