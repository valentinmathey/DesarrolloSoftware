// Store

import { setProductoActivo } from "../../main.js";
import { handleGetProductLocalStorage } from "../persistence/localStorage.js";
import { openModal } from "./modal.js";

// ======= FUNCIÓN PARA OBTENER Y RENDERIZAR PRODUCTOS EN LA TIENDA =======
export const handleGetProductToStore = () => {
    // Obtener productos desde el localStorage.
    const products = handleGetProductLocalStorage();
    // Enviar productos para su renderizado.
    handleRenderList(products);
}

// ======= FUNCIÓN PARA RENDERIZAR PRODUCTOS FILTRADOS POR CATEGORÍA =======
export const handleRenderList = (productsIn) => {
    // Filtrar productos por categoría "Hamburguesas".
    const burguers = productsIn.filter((el) => el.categoria === "Hamburguesas");
    // Filtrar productos por categoría "Papas".
    const papas = productsIn.filter((el) => el.categoria === "Papas");
    // Filtrar productos por categoría "Gaseosas".
    const gaseosas = productsIn.filter((el) => el.categoria === "Gaseosas");

    // ======= FUNCIÓN PARA GENERAR HTML DE UNA CATEGORÍA =======
    const renderProductGroup = (products, title) => {
        if (products.length > 0) {
            // Crear HTML para cada producto.
            const productsHTML = products.map((product, index) => {
                return `
                <div class="containerTargetItem" id="product-${product.categoria}-${index}">
                    <div>
                        <img src="${product.imagen}">
                        <div>
                            <h2>${product.nombre}</h2>
                        </div>
                        <div class="targetProps">
                            <p><b>Precio:</b> $ ${product.precio}</p>
                        </div>
                    </div>
                </div>
                `;
            });
            // Retornar la sección completa de productos.
            return `
            <section class="sectionStore">
                <div class="containerTitleSection">
                    <h3>${title}</h3>
                </div>
                <div class="containerProductStore">
                    ${productsHTML.join('')}
                </div>
            </section>
            `;
        } else {
            return ""; // No mostrar nada si no hay productos.
        }
    };

    // Seleccionar el contenedor principal de la tienda.
    const appContainer = document.getElementById('storeContainer');
    // Renderizar las secciones de productos por categoría.
    appContainer.innerHTML = `
    ${renderProductGroup(burguers, "Hamburguesas")}
    ${renderProductGroup(papas, "Papas")}
    ${renderProductGroup(gaseosas, "Gaseosas")}
    `;

    // ======= FUNCIÓN PARA AGREGAR EVENTOS A LOS PRODUCTOS RENDERIZADOS =======
    const addEvents = (productsIn) => {
        // Agregar evento de clic a cada producto.
        productsIn.forEach((element, index) => {
            const productContainer = document.getElementById(
                `product-${element.categoria}-${index}`
            );
            if (productContainer) {
                productContainer.addEventListener('click', () => {
                    setProductoActivo(element); // Activar producto seleccionado.
                    openModal(); // Abrir modal con información del producto.
                });
            }
        });
    };

    // Añadir eventos a productos de cada categoría.
    addEvents(burguers);
    addEvents(papas);
    addEvents(gaseosas);
};
