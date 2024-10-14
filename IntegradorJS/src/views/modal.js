// Modal

import { productoActivo, setProductoActivo } from "../../main.js";
import { handleDeleteProduct } from "../services/products.js";

// ======= FUNCIÓN PARA ABRIR EL MODAL =======
export const openModal = () => {
    // Mostrar el modal (flex para centrar su contenido).
    const modal = document.getElementById('modalPopUP');
    modal.style.display = 'flex'; 

    // Mostrar o ocultar el botón de eliminar según si hay un producto activo.
    const buttonDelete = document.getElementById('deleteButton');
    if (productoActivo) {
        buttonDelete.style.display = 'block';
    } else {
        buttonDelete.style.display = 'none';
    }

    // Si hay un producto activo, cargar los datos en los campos del modal.
    if (productoActivo) {
        const nombre = document.getElementById("nombre"),
            imagen = document.getElementById("img"),
            precio = document.getElementById("precio"),
            categoria = document.getElementById("categoria");
        nombre.value = productoActivo.nombre;
        imagen.value = productoActivo.imagen;
        precio.value = productoActivo.precio;
        categoria.value = productoActivo.categoria;
    }
}

// ======= EVENTO PARA CERRAR EL MODAL =======
const buttonCancel = document.getElementById('cancelButton');
buttonCancel.addEventListener('click', () => {
    closeModal(); // Llamar a la función que cierra el modal.
});

// ======= FUNCIÓN PARA CERRAR EL MODAL =======
export const closeModal = () => {
    // Ocultar el modal y resetear el producto activo.
    const modal = document.getElementById('modalPopUP');
    modal.style.display = 'none'; 
    setProductoActivo(null);
    resetModal(); // Resetear los valores del formulario.
}

// ======= FUNCIÓN PARA RESETEAR EL MODAL =======
const resetModal = () => {
    const nombre = document.getElementById("nombre"),
        imagen = document.getElementById("img"),
        precio = document.getElementById("precio"),
        categoria = document.getElementById("categoria");
    
    // Limpiar los valores de los campos del modal.
    nombre.value = "";
    imagen.value = "";
    precio.value = 0;
    categoria.value = "Selecciona una categoria";
}

// ======= EVENTO PARA ELIMINAR PRODUCTO =======
const deleteButton = document.getElementById('deleteButton');
deleteButton.addEventListener('click', () => {
    handleDeleteProduct(); // Llamar a la función que elimina el producto.
});
