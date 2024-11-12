export interface ItemProduct {
    nombre: string;
    imagen: string;
    precio: number;
}

export interface IPropsListProducts {
    arrayItems: ItemProduct[];
}

export interface IPropsFormProduct {
    handleAddProduct: (item: ItemProduct) => void;
}
