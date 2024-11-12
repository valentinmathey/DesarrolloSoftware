import { Button, Form } from "react-bootstrap"
import { FC } from "react";
import { useForm } from "../../Hooks/UseForm";
import { IPropsFormProduct } from "../../Types/productTypes";

export const FormProduct: FC<IPropsFormProduct> = ({ handleAddProduct }) => {

    const { values, handleChange, resetForm } = useForm({
        nombre: '',
        imagen: '',
        precio: 0
    })

    const handleSubmitForm = () => {

        if (!values.nombre || !values.imagen || values.precio <= 0) {
            alert("Por favor, completa todos los campos correctamente.");
            return;
        }

        handleAddProduct(values);
        resetForm();
    }

    return (
        <Form className="p-4 border rounded m-3">
            <Form.Group controlId="formNombre">
                <Form.Label>Nombre</Form.Label>
                <Form.Control
                    type="text"
                    name="nombre"
                    placeholder="Ingrese el nombre del producto"
                    value={values.nombre}
                    onChange={handleChange}
                />
            </Form.Group>
            <Form.Group controlId="formNombre">
                <Form.Label>Imagen</Form.Label>
                <Form.Control
                    type="text"
                    name="imagen"
                    placeholder="Ingrese la url de la imagen del producto"
                    value={values.imagen}
                    onChange={handleChange}
                />
            </Form.Group>
            <Form.Group controlId="formNombre">
                <Form.Label>Precio</Form.Label>
                <Form.Control
                    type="number"
                    name="precio"
                    placeholder="Ingrese el precio del producto"
                    value={values.precio}
                    onChange={handleChange}
                />
            </Form.Group>
            <div className="d-flex justify-content-center mt-4">
                <Button onClick={handleSubmitForm} variant="primary">Enviar Producto</Button>
            </div>
        </Form>
    )
}
