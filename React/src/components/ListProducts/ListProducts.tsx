// src/components/ListProducts/ListProducts.tsx
import { FC } from "react";
import ProductCard from "../Product/Product";
import { IPropsListProducts } from "../../Types/productTypes";

export const ListProducts: FC<IPropsListProducts> = ({ arrayItems }) => {
    return (
        <div
            className="p-2 m-3 border rounded d-grid gap-2"
            style={{
                gridTemplateColumns: "repeat(2, 1fr)",
                justifyItems: "center",
                alignItems: "center",
            }}
        >
            {arrayItems.map((el, i) => (
                <ProductCard key={i} nombre={el.nombre} imagen={el.imagen} precio={el.precio} />
            ))}
        </div>
    );
};
