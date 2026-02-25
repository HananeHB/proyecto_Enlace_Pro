let formParaBorrar1 = null;

function abrirConfirmacion(form, nombre) {
    formParaBorrar1 = form;
    document.getElementById('nombre-confirm').innerText = nombre;
    const modal = document.getElementById('overlay-confirm');
    modal.classList.replace('hidden', 'flex');
}

function cerrarConfirmacion() {
    const modal = document.getElementById('overlay-confirm');
    modal.classList.replace('flex', 'hidden');
    formParaBorrar1 = null;
}

document.getElementById('btn-confirmar-borrado').onclick = function () {
    if (formParaBorrar1) formParaBorrar1.submit();
};

function prepararEdicionIdioma(btn) {
    document.getElementById('edit-id').value = btn.getAttribute('data-id');
    document.getElementById('edit-nombre').value = btn.getAttribute('data-nombre');
    const modal = document.getElementById('edit-idioma-modal');
    modal.classList.replace('hidden', 'flex');
}

function cerrarEditModalIdioma() {
    const modal = document.getElementById('edit-idioma-modal');
    modal.classList.replace('flex', 'hidden');
}

window.addEventListener('click', function (e) {
    if (e.target.id === 'overlay-confirm') cerrarConfirmacion();
    if (e.target.id === 'edit-idioma-modal') cerrarEditModalIdioma();
});

(function () {
    const formEdicion = document.getElementById('editIdiomaForm');
    const btnBorrar = document.getElementById('btn-confirmar-borrado');

    if (formEdicion) {
        formEdicion.addEventListener('submit', () => {
            localStorage.setItem('idioma_feedback', 'editado');
        });
    }

    if (btnBorrar) {
        btnBorrar.addEventListener('click', () => {
            localStorage.setItem('idioma_feedback', 'borrado');
        });
    }

    window.addEventListener('load', () => {
        const feedback = localStorage.getItem('idioma_feedback');
        if (feedback) {
            const toastId = (feedback === 'editado') ? 'toast-idioma-edit' : 'toast-idioma-delete';
            const toast = document.getElementById(toastId);

            if (toast) {
                toast.classList.add('show');
                setTimeout(() => { toast.classList.remove('show'); }, 3000);
            }
            localStorage.removeItem('idioma_feedback');
        }
    });
})();