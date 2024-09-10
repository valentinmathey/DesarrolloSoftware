// Ejercicio 1.2 - Suma  a + b = c
export function ejercicio1_2() {
    let a = 5;
    let b = 10;
    let c = a + b;
    console.log("La suma de a y b es: " + c);
}

// Ejercicio 1.3 - Nombre del usuario
export function ejercicio1_3() {
    let nombre = prompt("Por favor, ingresa tu nombre:");
    console.log("Hola, " + nombre + "!");
}

// Ejercicio 2.1 - Mayor de a y b
export function ejercicio2_1() {
    let a = 7;
    let b = 12;

    if (a > b) {
        console.log("El mayor es: " + a);
    } else {
        console.log("El mayor es: " + b);
    }
}

// Ejercicio 2.2 - Determinar si es par o impar
export function ejercicio2_2() {
    let numero = parseInt(prompt("Por favor, ingresa un número:"));
    if (numero % 2 === 0) {
        console.log("El número " + numero + " es par.");
    } else {
        console.log("El número " + numero + " es impar.");
    }
}

// Ejercicio 3.1 - Bucle while
export function bucleWhile() {
    let numero = 10;
    while (numero > 0) {
        console.log(numero);
        numero--;
    }
}

// Ejercicio 3.2 - Bucle do...while
export function bucleDoWhile() {
    let numero;
    do {
        numero = parseInt(prompt("Ingresa un número mayor a 100:"));
    } while (numero <= 100);
    console.log("Ingresaste un número mayor a 100: " + numero);
}

// Ejercicio 4.1 - Función esPar
export function probarEsPar() {
    let numero = parseInt(prompt("Ingresa un número:"));
    console.log("El número " + numero + " es par: " + esPar(numero));
}

export function esPar(numero) {
    return numero % 2 === 0;
}

// Ejercicio 4.2 - Convertir Celsius a Fahrenheit
export function convertirTemperatura() {
    let celsius = parseFloat(prompt("Ingresa la temperatura en Celsius:"));
    console.log(celsius + "°C son equivalentes a " + convertirCelsiusAFahrenheit(celsius) + "°F");
}

export function convertirCelsiusAFahrenheit(celsius) {
    return celsius * 1.8 + 32;
}

// Ejercicio 5.1 - Objeto Persona
let persona = {
    nombre: "Juan",
    edad: 30,
    ciudad: "Mendoza",
    cambiarCiudad: function (nuevaCiudad) {
        this.ciudad = nuevaCiudad;
    }
};

export function cambiarCiudad() {
    let nuevaCiudad = prompt("Ingresa la nueva ciudad:");
    persona.cambiarCiudad(nuevaCiudad);
    console.log(persona);
}

// Ejercicio 5.2 - Objeto Libro
let libro = {
    titulo: "JavaScript: The Good Parts",
    autor: "Douglas Crockford",
    año: 2008,
    esAntiguo: function () {
        let yearActual = new Date().getFullYear();
        return (yearActual - this.año) > 10;
    }
};

export function verificarAntiguedadLibro() {
    console.log("El libro " + libro.titulo + "es atiguo: " + libro.esAntiguo());
}

// Ejercicio 6.1 - Multiplicar Array
export function multiplicarArray() {
    let numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
    let numerosMultiplicados = numeros.map(numero => numero * 2);
    console.log("Números Original:", numeros);
    console.log("Números Multiplicados:", numerosMultiplicados);
}

// Ejercicio 6.2 - Generar Pares
export function generarPares() {
    let pares = [];
    for (let i = 1; pares.length < 10; i++) {
        if (i % 2 === 0) {
            pares.push(i);
        }
    }
    console.log("Primeros 10 numeros pares: " + pares);
}

// Ejercicio 7.1 - Cambiar color de párrafos
export function cambiarColor() {
    let parrafos = document.querySelectorAll("p");
    parrafos.forEach(p => p.style.color = "blue");
}

export function cambiarColorNegro() {
    let parrafos = document.querySelectorAll("p");
    parrafos.forEach(p => p.style.color = "black");
}

// Ejercicio 7.2 - Mostrar valor del formulario
export function mostrarAlerta() {
    let valor = document.getElementById("campoTexto").value;
    alert("Valor ingresado: " + valor);
}

// Ejercicio 8.1 - Evento en lista
export function mostrarElementosEnConsola() {
    const listaElementos = document.querySelectorAll('#listaElementos li');
    listaElementos.forEach(item => {
        console.log(item.textContent);
    });
}

// Ejercicio 8.2 - Deshabilitar y Habilitar campo de texto
export function deshabilitar() {
    let input = document.getElementById("campoTexto2");
    input.disabled = true;
}

export function habilitar() {
    let input = document.getElementById("campoTexto2");
    input.disabled = false;
}

// Ejercicio 9.1 - LocalStorage
export function guardarCorreo() {
    let correo = document.getElementById("correo").value;
    localStorage.setItem("correo", correo);
    mostrarCorreo();
}

export function mostrarCorreo() {
    let correo = localStorage.getItem("correo");
    if (correo) {
        document.getElementById("correoGuardado").textContent = "Correo guardado: " + correo;
    } else {
        document.getElementById("correoGuardado").textContent = "";
    }
}

export function eliminarCorreo() {
    localStorage.removeItem("correo");
    document.getElementById("correoGuardado").textContent = "";
}

window.onload = mostrarCorreo;
