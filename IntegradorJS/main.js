// Main
import { renderCategorias } from './src/services/categories.js';
import { handleSearchProductByName } from './src/services/searchBar.js';
import { openModal } from './src/views/modal.js';
import { handleGetProductToStore } from './src/views/store.js';

// ======= INICIALIZAR LA APLICACIÓN =======
window.addEventListener('DOMContentLoaded', () => {
  handleGetProductToStore(); // Cargar y mostrar los productos desde el localStorage.
  renderCategorias(); // Renderizar las categorías disponibles en el filtro.
});

export let categoriaActiva = null;
export const setCategoriaActiva = (categoriaIn) => {
  categoriaActiva = categoriaIn; // Establecer la categoría activa.
}

export let productoActivo = null;
export const setProductoActivo = (productoIn) => {
  productoActivo = productoIn; // Establecer el producto activo.
}

// ======= EVENTO PARA ABRIR EL MODAL =======
const buttonAdd = document.getElementById('buttonAddElement');
buttonAdd.addEventListener('click', () => {
    openModal(); // Abrir el modal para agregar un producto.
});

// ======= EVENTO PARA BUSCAR PRODUCTO =======
const buttonSearch = document.getElementById('buttonSearch');
buttonSearch.addEventListener('click', () => {
  handleSearchProductByName(); // Ejecutar la búsqueda de productos.
});

