// LocalStorage

// ======= Función para obtener productos almacenados en el LocalStorage =======

/**
 * Función que obtiene los productos almacenados en el LocalStorage.
 * @returns {Array} Un array con los productos almacenados o un array vacío si no hay productos.
 */
export const handleGetProductLocalStorage = () => {
    // Obtener productos desde el LocalStorage y convertirlos de formato JSON a un objeto JavaScript.
    const products = JSON.parse(localStorage.getItem('products')); 
    
    // Verificar si hay productos almacenados.
    if (products) {
        // Si hay productos, devolver el array de productos.
        return products;
    } else {
        // Si no hay productos almacenados, devolver un array vacío.
        return [];
    }
};

// ======= Función para guardar o actualizar un producto en el LocalStorage =======

/**
 * Función que guarda o actualiza un producto en el LocalStorage.
 * Si el producto ya existe (mismo ID), se actualiza; de lo contrario, se agrega un nuevo producto.
 * @param {Object} productIn - El producto que se va a guardar o actualizar.
 */
export const setInLocalStorage = (productIn) => {
    
    // Obtener los productos actuales almacenados en el LocalStorage.
    let productsInLocal = handleGetProductLocalStorage();

    // Verificar si el producto ya existe en el LocalStorage buscando su ID.
    const existingIndex = productsInLocal.findIndex((productsLocal) => {
        return productsLocal.id === productIn.id; // Comprobar si el ID del producto coincide con algún producto existente.
    });

    // Si el producto ya existe en el array (es decir, su ID coincide con alguno en el LocalStorage).
    if (existingIndex !== -1) {
        // Reemplazar el producto existente con la nueva información del producto.
        productsInLocal[existingIndex] = productIn;
    } else {
        // Si el producto no existe, agregarlo al array de productos.
        productsInLocal.push(productIn);
    }

    // Guardar el array de productos actualizado en el LocalStorage, convirtiéndolo de objeto a formato JSON.
    localStorage.setItem('products', JSON.stringify(productsInLocal));
};
