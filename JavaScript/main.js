// Importa las funciones necesarias desde el archivo functions.js
import {
  ejercicio1_2,
  ejercicio1_3,
  ejercicio2_1,
  ejercicio2_2,
  bucleWhile,
  bucleDoWhile,
  probarEsPar,
  convertirTemperatura,
  cambiarCiudad,
  verificarAntiguedadLibro,
  multiplicarArray,
  generarPares,
  cambiarColor,
  cambiarColorNegro,
  mostrarAlerta,
  deshabilitar,
  habilitar,
  mostrarElementosEnConsola,
  guardarCorreo,
  eliminarCorreo
} from './functions.js';

// Función para configurar eventos click en los botones
function setupButton(id, handler) {
  const button = document.getElementById(id); // Busca el botón por su id
  if (button) {
    button.addEventListener('click', handler); // Asocia el handler al evento click del botón
  }
}

// Función para asignar eventos click a los elementos de la lista
export function asignarEventoClickALista() {
  const listaElementos = document.querySelectorAll('#listaElementos li'); // Selecciona todos los elementos de la lista
  listaElementos.forEach(item => {
    item.addEventListener('click', () => {
      console.log("Hiciste clic en: " + item.textContent); // Muestra el texto del ítem clicado en la consola
    });
  });
}

// Espera a que el contenido del DOM se cargue completamente
window.addEventListener('DOMContentLoaded', () => {
  // Configura eventos click para cada botón con su función correspondiente
  setupButton('btn-ejercicio1_2', ejercicio1_2);
  setupButton('btn-ejercicio1_3', ejercicio1_3);
  setupButton('btn-ejercicio2_1', ejercicio2_1);
  setupButton('btn-ejercicio2_2', ejercicio2_2);
  setupButton('btn-bucleWhile', bucleWhile);
  setupButton('btn-bucleDoWhile', bucleDoWhile);
  setupButton('btn-esPar', probarEsPar);
  setupButton('btn-convertirTemperatura', convertirTemperatura);
  setupButton('btn-cambiarCiudad', cambiarCiudad);
  setupButton('btn-verificarAntiguedadLibro', verificarAntiguedadLibro);
  setupButton('btn-multiplicarArray', multiplicarArray);
  setupButton('btn-generarPares', generarPares);
  setupButton('btn-cambiarColor', cambiarColor);
  setupButton('btn-cambiarColorNegro', cambiarColorNegro);
  setupButton('btn-mostrarAlerta', mostrarAlerta);
  setupButton('btn-mostrarLista', mostrarElementosEnConsola);
  setupButton('btn-deshabilitar', deshabilitar);
  setupButton('btn-habilitar', habilitar);
  setupButton('btn-eliminarCorreo', eliminarCorreo);
  setupButton('btn-guardarCorreo', guardarCorreo);

  // Asigna los eventos click a los elementos de la lista
  asignarEventoClickALista();
});
