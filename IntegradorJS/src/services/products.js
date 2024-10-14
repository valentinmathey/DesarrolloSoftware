// Products

import Swal from 'sweetalert2';
import 'bootstrap/dist/css/bootstrap.min.css';
import { productoActivo } from "../../main.js";
import { handleGetProductLocalStorage, setInLocalStorage } from "../persistence/localStorage.js";
import { closeModal } from "../views/modal.js";
import { handleGetProductToStore, handleRenderList } from "../views/store.js";


// ======= EVENTO PARA GUARDAR O MODIFICAR PRODUCTO =======

// Obtener el botón de "Aceptar" del modal.
const acceptButton = document.getElementById('acceptButton');

// Añadir evento de clic al botón "Aceptar" que ejecuta la función de guardar o modificar producto.
acceptButton.addEventListener('click', () => {
    handleSaveOrModifyElement(); // Llamar a la función que guarda o modifica el producto.
});

// ======= FUNCIÓN PARA GUARDAR O MODIFICAR PRODUCTO =======

/**
 * Función que guarda un nuevo producto o modifica un producto existente.
 * Si hay un producto activo, modifica ese producto, de lo contrario, guarda un nuevo producto.
 */
const handleSaveOrModifyElement = () => {
    // Obtener los valores del formulario desde el modal (nombre, imagen, precio, categoría).
    const nombre = document.getElementById("nombre").value,
        imagen = document.getElementById("img").value,
        precio = document.getElementById("precio").value,
        categoria = document.getElementById("categoria").value;

    let object = null; // Inicializar el objeto que será guardado o modificado.

    // Verificar si hay un producto activo (es decir, estamos editando un producto existente).
    if (productoActivo) {
        // Si es así, crear un nuevo objeto basado en los datos actuales del producto activo y los valores del formulario.
        object = {
            ...productoActivo,
            nombre,
            imagen,
            precio,
            categoria
        };
    } else {
        // Si no hay producto activo, crear un nuevo objeto con un ID único basado en la fecha actual.
        object = {
            id: new Date().toISOString(), // Generar un ID único usando la fecha actual.
            nombre,
            imagen,
            precio,
            categoria
        };
    }

    // Mostrar una alerta de éxito cuando el producto se guarda o modifica correctamente.
    Swal.fire({
        title: "Correcto!",
        text: "Producto guardado correctamente!",
        icon: "success"
    });

    // Guardar el objeto (nuevo producto o producto modificado) en el LocalStorage.
    setInLocalStorage(object);

    // Actualizar la lista de productos en la tienda.
    handleGetProductToStore();

    // Cerrar el modal después de guardar el producto.
    closeModal();
};

// ======= FUNCIÓN PARA ELIMINAR UN PRODUCTO =======

/**
 * Función que elimina el producto activo actual, después de una confirmación del usuario.
 * Muestra mensajes de confirmación y realiza la eliminación en el LocalStorage.
 */
export const handleDeleteProduct = () => {
    // Configurar SweetAlert con botones personalizados usando clases de Bootstrap.
    const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
            confirmButton: "btn btn-success", // Botón de confirmación verde.
            cancelButton: "btn btn-danger" // Botón de cancelación rojo.
        },
        buttonsStyling: false // Desactivar estilos automáticos de los botones para usar los de Bootstrap.
    });

    // Mostrar alerta de confirmación antes de eliminar el producto.
    swalWithBootstrapButtons.fire({
        title: "Desea eliminar producto?", // Título del mensaje.
        text: "Si lo eliminas sera permanentemente!", // Texto de advertencia.
        icon: "warning", // Icono de advertencia.
        showCancelButton: true, // Mostrar botón de cancelación.
        confirmButtonText: "Si, eliminar", // Texto del botón de confirmación.
        cancelButtonText: "No, cancelar", // Texto del botón de cancelación.
        reverseButtons: true // Invertir el orden de los botones para mejor UX.
    }).then((result) => {
        if (result.isConfirmed) { // Si el usuario confirma la eliminación.
            swalWithBootstrapButtons.fire({
                title: "Eliminado!", // Mensaje de éxito al eliminar el producto.
                text: "Tu producto fue eliminado", // Texto informativo.
                icon: "success" // Icono de éxito.
            });

            // Obtener la lista actual de productos desde el LocalStorage.
            const products = handleGetProductLocalStorage();

            // Filtrar la lista de productos, excluyendo el producto activo (el que se eliminará).
            const result = products.filter((el) => el.id !== productoActivo.id);

            // Guardar la lista actualizada de productos en el LocalStorage (sin el producto eliminado).
            localStorage.setItem('products', JSON.stringify(result));

            // Obtener y renderizar la lista actualizada de productos.
            const newProducts = handleGetProductLocalStorage();
            handleRenderList(newProducts);

            // Cerrar el modal después de eliminar el producto.
            closeModal();
        } else if (result.dismiss === Swal.DismissReason.cancel) { // Si el usuario cancela la acción de eliminar.
            // Mostrar un mensaje indicando que la eliminación fue cancelada.
            swalWithBootstrapButtons.fire({
                title: "Cancelado", // Título del mensaje.
                text: "Tu producto no se elimino", // Texto informativo.
                icon: "error" // Icono de error/informativo.
            });
        }
    });
};