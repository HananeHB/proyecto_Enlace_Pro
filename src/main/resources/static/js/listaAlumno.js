let formParaBorrar2 = null;

function abrirConfirmacion(form, nombre) {
    formParaBorrar2 = form;
    document.getElementById('nombre-confirm').innerText = nombre;
    const modal = document.getElementById('overlay-confirm');
    modal.classList.remove('hidden');
    modal.classList.add('flex');
}

function cerrarConfirmacion() {
    document.getElementById('overlay-confirm').classList.add('hidden');
    document.getElementById('overlay-confirm').classList.remove('flex');
    formParaBorrar2 = null;
}

document.getElementById('btn-confirmar-borrado').onclick = function () {
    if (formParaBorrar2) formParaBorrar2.submit();
};

function prepararEdicion(btn) {
    document.getElementById('edit-id').value = btn.getAttribute('data-id');
    document.getElementById('edit-nombre').value = btn.getAttribute('data-nombre');
    document.getElementById('edit-apellidos').value = btn.getAttribute('data-apellidos');
    document.getElementById('edit-email').value = btn.getAttribute('data-email');
    document.getElementById('edit-telefono').value = btn.getAttribute('data-telefono');
    document.getElementById('edit-idioma').value = btn.getAttribute('data-idioma');

    const modal = document.getElementById('edit-alumno-modal');
    modal.classList.remove('hidden');
    modal.classList.add('flex');
}

function cerrarEditModal() {
    document.getElementById('edit-alumno-modal').classList.add('hidden');
    document.getElementById('edit-alumno-modal').classList.remove('flex');
}

window.addEventListener('click', function (e) {
    if (e.target.id === 'overlay-confirm') cerrarConfirmacion();
    if (e.target.id === 'edit-alumno-modal') cerrarEditModal();
});

(function () {
    const formEdicion = document.getElementById('editAlumnoForm');
    const btnBorrar = document.getElementById('btn-confirmar-borrado');

    if (formEdicion) {
        formEdicion.addEventListener('submit', () => {
            localStorage.setItem('alumno_feedback', 'editado');
        });
    }

    if (btnBorrar) {
        btnBorrar.addEventListener('click', () => {
            localStorage.setItem('alumno_feedback', 'borrado');
        });
    }

    window.addEventListener('load', () => {
        const feedback = localStorage.getItem('alumno_feedback');

        if (feedback === 'editado') {
            const toast = document.getElementById('toast-edit');
            showToast(toast);
        } else if (feedback === 'borrado') {
            const toast = document.getElementById('toast-delete');
            showToast(toast);
        }

        localStorage.removeItem('alumno_feedback');
    });

    function showToast(el) {
        if (el) {
            el.classList.add('show');
            setTimeout(() => {
                el.classList.remove('show');
            }, 3000);
        }
    }
})();