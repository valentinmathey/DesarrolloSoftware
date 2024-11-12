import { FormProduct } from "../FormProduct/FormProduct"
import { Header } from "../Header/Header"
import { ListProducts } from "../ListProducts/ListProducts";
import { useProductList } from "../../Hooks/useProductList";

export const AppProduct = () => {
  const { products, addProduct } = useProductList();

  return (
    <div>
      <Header />
      <h1 className="text-center">Formulario</h1>
      <FormProduct handleAddProduct={addProduct} />
      <h1 className="text-center">Productos</h1>
      {products.length > 0 ? (
        <ListProducts arrayItems={products} />
      ) : (
        <h2 className="text-center">No hay productos</h2>
      )}
    </div>
  );
};
