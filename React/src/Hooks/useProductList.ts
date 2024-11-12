// src/hooks/useProductList.ts
import { useState } from "react";
import { ItemProduct } from "../Types/productTypes";

export const useProductList = () => {
    const [products, setProducts] = useState<ItemProduct[]>([]);

    const addProduct = (newItem: ItemProduct) => {
        setProducts((prev) => [...prev, newItem]);
    };

    return {
        products,
        addProduct,
    };
};
