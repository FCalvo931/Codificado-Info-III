# Codificado-Info-III
Informática III

Proyecto Segundo parcial
Introducción:
El objetivo del proyecto es realizar un codificador de texto. En criptografía, un código, consiste en sustituir
unidades textuales (habitualmente palabras o frases) por otras para ocultar un mensaje. La
documentación donde están las equivalencias entre el código y la información que representa, se llama
diccionario o libro de códigos.
Enunciado:
Se desea realizar una aplicación que realice la tarea de codificar un texto. El programa debe
recibir dos archivos de texto, el diccionario y el texto a codificar. Luego de codificar el texto original, debe
escribirlo en un nuevo archivo de salida.
El programa debe permitir también, decodificar el texto codificado. Para esto se le pasa el texto
codificado y el diccionario y debe escribir un archivo con el texto original.
El programa deberá recibir como parámetro en línea de comandos las rutas de los distintos
archivos y realizar la tarea dada.
Los parámetros que debe soportar son:
● -c / -d: uno de estos dos parámetros, -c indicará que va a codificar el archivo y -d indica que va a
decodificar el archivo de entrada.
● -l “archivo.dic”: el archivo de texto a utilizar como libro de códigos.
● -i “entrada.txt”: el archivo de texto a codificar o descodificar.
● -o “salida.txt”: el archivo de texto donde se escribirá la salida del programa.
Los archivos diccionario contendrá por cada línea, dos palabras separadas con el carácter TAB
(‘\t’). Para codificar la palabra de la izq deberá ser reemplazada por la palabra de la derecha.
Por ejemplo:
Diccionario:
es presente
pasado la
lo es
futuro lo
presente el
vida y
de de
mejor pasado
la futuro
el vida
y mejor
Entrada:
Lo mejor de la vida es el pasado, el presente y el futuro.
Salida:
Es pasado de futuro y presente vida la, vida el mejor vida lo.
La evaluación se realizará sobre el correcto funcionamiento, implementación y rendimiento de la
aplicación para realizar la tarea de codificación. Todas las estructuras y algoritmos utilizados en la
aplicación deben ser implementados por el usuario, no está permitido utilizar bibliotecas, como List, Map,
Queue, SortedMap, Sort, etc.
Objetivo:
Ejercitar y afianzar el uso de estructuras de datos mediante una aplicación concisa y de uso
general.
Afianzar la importancia del uso de las estructuras correctas para mejorar el rendimiento de las
aplicaciones.

Formas de presentación: Exposición y defensa del programa e informe con código fuente y
comentarios.
Forma de trabajo: Grupos de no más de 2 personas.
Forma de evaluación: Se evaluará de acuerdo a los siguientes parámetros:

Correcto funcionamiento del programa
Completitud de las funcionalidades del enunciado
Presentación (código, prolijidad)
Solución óptima al problema dado – eficiencia del código.
Utilización y adaptación de los códigos proporcionados en clase y del libro.
Conocimiento de la/las estructura/s utilizada/s.
Exposición y defensa del trabajo.
Preguntas sobre las estructuras utilizadas a cada integrante.
Cada grupo tendrá 10 minutos para presentar lo desarrollado el día de la entrega.
