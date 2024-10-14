// Categories

import { categoriaActiva } from "../../main.js";
import { handleGetProductLocalStorage } from "../persistence/localStorage.js";
import { handleRenderList } from "../views/store.js";


/**
 * Función que filtra los productos según la categoría seleccionada y los renderiza.
 * @param {string} categoryIn - Categoría seleccionada para filtrar los productos.
 */
const handleFilterProductsByCategory = (categoryIn) => {
    // Obtener la lista de productos desde el localStorage.
    const products = handleGetProductLocalStorage();

    // Filtrar y renderizar los productos según la categoría seleccionada.
    switch (categoryIn) {
        case categoriaActiva:
            // Si la categoría seleccionada es la misma que la activa, renderizar todos los productos.
            handleRenderList(products);
            break;
        case "Todo":
            // Si se selecciona la opción "Todo", mostrar todos los productos sin ningún filtro.
            handleRenderList(products);
            break;
        case "Hamburguesas":
        case "Papas":
        case "Gaseosas":
            // Filtrar los productos que coincidan con la categoría seleccionada (Hamburguesas, Papas o Gaseosas).
            const result = products.filter((el) => el.categoria === categoryIn);
            handleRenderList(result); // Renderizar la lista de productos filtrada.
            break;
        case "mayorPrecio":
            // Ordenar los productos por precio de mayor a menor.
            const resultPrecioMayor = products.sort((a, b) => b.precio - a.precio);
            handleRenderList(resultPrecioMayor); // Renderizar la lista de productos ordenada.
            break;
        case "menorPrecio":
            // Ordenar los productos por precio de menor a mayor.
            const resultPrecioMenor = products.sort((a, b) => a.precio - b.precio);
            handleRenderList(resultPrecioMenor); // Renderizar la lista de productos ordenada.
            break;
        default:
            // Si no coincide con ninguna de las categorías anteriores, no hacer nada.
            break;
    }
};

/**
 * Función para renderizar dinámicamente las categorías en el menú lateral.
 * Esta función crea los elementos <li> correspondientes a cada categoría y les añade eventos de clic.
 */
export const renderCategorias = () => {
    // Seleccionar el elemento <ul> en el que se renderizarán las categorías.
    const ulList = document.getElementById('listFilter');

    // Verificar si el elemento <ul> existe en el DOM.
    if (!ulList) {
        console.error("El elemento listFilter no se encontró en el DOM."); // Mostrar error si no existe.
        return;
    }
    
    // Insertar los elementos <li> con las categorías que el usuario puede seleccionar.
    ulList.innerHTML = `
        <li id="Todo">Todos los productos</li>
        <li id="Hamburguesas">Hamburguesas</li>
        <li id="Papas">Papas</li>
        <li id="Gaseosas">Gaseosas</li>
        <li id="mayorPrecio">Mayor precio</li>
        <li id="menorPrecio">Menor precio</li>
    `;

    // Seleccionar todos los elementos <li> recién creados dentro del <ul>.
    const liElements = ulList.querySelectorAll('li');
    
    // Añadir un evento 'click' a cada categoría para que filtre los productos al hacer clic.
    liElements.forEach((liElement) => {
        liElement.addEventListener('click', () => {
            // Llamar a la función que filtra los productos según la categoría seleccionada.
            handleFilterProductsByCategory(liElement.id);

            // Remover la clase `liActive` de todos los elementos <li> para desactivar cualquier selección previa.
            liElements.forEach(el => el.classList.remove('liActive'));

            // Añadir la clase `liActive` al elemento <li> clicado para resaltarlo como categoría activa.
            liElement.classList.add('liActive');
        });
    });
};
