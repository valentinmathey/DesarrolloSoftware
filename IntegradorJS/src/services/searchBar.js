import { handleGetProductLocalStorage } from "../persistence/localStorage.js";
import { handleRenderList } from "../views/store.js";

// ======= FUNCIÓN PARA BUSCAR PRODUCTOS POR NOMBRE =======
export const handleSearchProductByName = () => {
    // Obtener el campo de búsqueda del header.
    const inputHeader = document.getElementById('inputHeader');
    
    // Obtener productos almacenados en el LocalStorage.
    const products = handleGetProductLocalStorage();

    // Filtrar productos que coincidan con el valor ingresado en el campo de búsqueda (insensible a mayúsculas).
    const result = products.filter((el) => 
        el.nombre.toLowerCase().includes(inputHeader.value.toLowerCase())
    );

    // Renderizar la lista de productos filtrados.
    handleRenderList(result);
};
