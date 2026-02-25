document.addEventListener("DOMContentLoaded", () => {
    const successModal = document.getElementById("successModal");
    if (successModal) {
        successModal.addEventListener("click", (e) => {
            if (e.target === successModal) closeSuccessModal();
        });

        document.addEventListener("keydown", (e) => {
            if (e.key === "Escape" && successModal.classList.contains("active")) {
                closeSuccessModal();
            }
        });
    }

    const confirmModal = document.getElementById("overlay-confirm");
    if (confirmModal) {
        confirmModal.addEventListener("click", (e) => {
            if (e.target === confirmModal) cerrarConfirmacion();
        });

        document.addEventListener("keydown", (e) => {
            if (e.key === "Escape" && confirmModal.classList.contains("active")) {
                cerrarConfirmacion();
            }
        });
    }

    const btnConfirmarBorrado = document.getElementById("btn-confirmar-borrado");
    if (btnConfirmarBorrado) {
        btnConfirmarBorrado.addEventListener("click", () => {
            if (formParaBorrar) {
                formParaBorrar.submit();
            }
        });
    }

    const editIdiomaModal = document.getElementById("edit-idioma-modal");
    if (editIdiomaModal) {
        editIdiomaModal.addEventListener("click", (e) => {
            if (e.target === editIdiomaModal) cerrarEditModalIdioma();
        });

        document.addEventListener("keydown", (e) => {
            if (e.key === "Escape" && editIdiomaModal.classList.contains("active")) {
                cerrarEditModalIdioma();
            }
        });
    }

    const editAlumnoModal = document.getElementById("edit-alumno-modal");
    if (editAlumnoModal) {
        editAlumnoModal.addEventListener("click", (e) => {
            if (e.target === editAlumnoModal) cerrarEditModal();
        });

        document.addEventListener("keydown", (e) => {
            if (e.key === "Escape" && editAlumnoModal.classList.contains("active")) {
                cerrarEditModal();
            }
        });
    }
});

/** --- LÓGICA DE FUNCIONES GLOBALES --- **/
var formParaBorrar = formParaBorrar || null;

function closeSuccessModal() {
    const modal = document.getElementById("successModal");
    if (modal) {
        modal.style.opacity = "0";
        setTimeout(() => {
            modal.classList.remove("active");
            modal.style.opacity = "";
        }, 300);
    }
}

function abrirConfirmacion(form, nombre) {
    formParaBorrar = form;
    const txtNombre = document.getElementById("nombre-confirm");
    if (txtNombre) txtNombre.innerText = nombre;

    const modal = document.getElementById("overlay-confirm");
    if (modal) {
        modal.style.display = "flex";
        setTimeout(() => {
            modal.classList.add("active");
            modal.style.opacity = "1";
        }, 10);
    }
}

function cerrarConfirmacion() {
    const modal = document.getElementById("overlay-confirm");
    if (modal) {
        modal.style.opacity = "0";
        setTimeout(() => {
            modal.classList.remove("active");
            modal.style.opacity = "";
            formParaBorrar = null;
        }, 300);
    }
}

/** --- FUNCIONES MODAL EDITAR IDIOMA --- **/
function prepararEdicionIdioma(btn) {
    const id = btn.getAttribute("data-id");
    const nombre = btn.getAttribute("data-nombre");
    abrirEditModalIdioma(id, nombre);
}

function abrirEditModalIdioma(id, nombre) {
    const modal = document.getElementById("edit-idioma-modal");
    if (!modal) return;

    const inputId = document.getElementById("edit-id");
    const inputNombre = document.getElementById("edit-nombre");
    
    if (inputId) inputId.value = id;
    if (inputNombre) inputNombre.value = nombre;

    modal.style.display = "flex";
    setTimeout(() => modal.classList.add("active"), 10);
}

function cerrarEditModalIdioma() {
    const modal = document.getElementById("edit-idioma-modal");
    if (modal) {
        modal.classList.remove("active");
        setTimeout(() => { modal.style.display = "none"; }, 400);
    }
}

/** --- FUNCIONES MODAL EDITAR ALUMNO --- **/
function prepararEdicion(btn) {
    const id = btn.getAttribute("data-id");
    const nombre = btn.getAttribute("data-nombre");
    const apellidos = btn.getAttribute("data-apellidos");
    const email = btn.getAttribute("data-email");
    const telefono = btn.getAttribute("data-telefono");
    const idiomaId = btn.getAttribute("data-idioma");

    abrirEditModal(id, nombre, apellidos, email, telefono, idiomaId);
}

function abrirEditModal(id, nombre, apellidos, email, telefono, idiomaId) {
    const modal = document.getElementById("edit-alumno-modal");
    if (!modal) return;

    const fId = document.getElementById("edit-id");
    const fNombre = document.getElementById("edit-nombre");
    const fApellidos = document.getElementById("edit-apellidos");
    const fEmail = document.getElementById("edit-email");
    const fTelef = document.getElementById("edit-telefono");
    const fIdioma = document.getElementById("edit-idioma");

    if (fId) fId.value = id || "";
    if (fNombre) fNombre.value = nombre || "";
    if (fApellidos) fApellidos.value = apellidos || "";
    if (fEmail) fEmail.value = email || "";
    if (fTelef) fTelef.value = (telefono === "null" || !telefono) ? "" : telefono;
    
    if (fIdioma) {
        if (idiomaId && idiomaId !== "null") {
            fIdioma.value = idiomaId;
        } else {
            fIdioma.selectedIndex = 0;
        }
    }

    modal.style.display = "flex";
    setTimeout(() => { modal.classList.add("active"); }, 10);
}

function cerrarEditModal() {
    const modal = document.getElementById("edit-alumno-modal");
    if (modal) {
        modal.classList.remove("active");
        setTimeout(() => { modal.style.display = "none"; }, 400);
    }
}