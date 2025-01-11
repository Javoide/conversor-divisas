# Conversor de Divisas

Este proyecto es un programa interactivo en Java que permite convertir entre diferentes divisas utilizando datos de una API de tasas de cambio. Proporciona una experiencia amigable con menús claros y opciones para calcular conversiones basadas en una cantidad de divisa específica.

## Características

- Selección de divisa base desde un menú de opciones predefinidas.
- Posibilidad de seleccionar una divisa de destino para la conversión.
- Conversión basada en una cantidad ingresada por el usuario.
- Manejo de errores para entradas inválidas.
- Regreso automático al menú principal tras cada conversión.

## Menú de Divisas Disponibles

1. Dólar Estadounidense (USD)
2. Euro (EUR)
3. Peso Chileno (CLP)
4. Peso Argentino (ARS)
5. Real Brasileño (BRL)
6. Dólar Canadiense (CAD)
7. Yen Japonés (JPY)
8. Salir

## Requisitos

- **Java 11 o superior**: Asegúrate de que tienes una versión compatible de Java instalada.
- **Biblioteca Gson**: Se utiliza para procesar las respuestas de la API.

## Instalación

1. Clona este repositorio en tu máquina local:

   ```bash
   git clone https://github.com/Javoide/conversor-divisas
   ```

2. Navega al directorio del proyecto:

   ```bash
   cd conversor-divisas
   ```

3. Asegúrate de agregar la biblioteca Gson a tu proyecto. Puedes usar un administrador de dependencias como Maven o agregar manualmente el archivo JAR.

4. Configura tu clave de API en la clase `ConsultaDivisa`. Reemplaza `YOUR-API-KEY` con tu clave de API obtenida de [ExchangeRate-API](https://www.exchangerate-api.com/):

   ```java
   URI direccion = URI.create("https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/" + nombreDivisa);
   ```

## Uso

1. Compila el proyecto:

   ```bash
   javac Principal.java
   ```

2. Ejecuta el programa:

   ```bash
   java Principal
   ```

3. Sigue las instrucciones en pantalla para realizar las conversiones.

## Ejemplo de Ejecución

```
***********************************************************************
Bienvenido al conversor de divisas. Seleccione la divisa que desea convertir:
1.- DÓLAR ESTADOUNIDENSE (USD)
2.- EURO (EUR)
3.- PESO CHILENO (CLP)
4.- PESO ARGENTINO (ARS)
5.- REAL BRASILEÑO (BRL)
6.- DÓLAR CANADIENSE (CAD)
7.- YEN JAPONÉS (JPY)
8.- SALIR
***********************************************************************
Ingrese su elección: 1
Base seleccionada: USD
Seleccione una divisa para convertir:
1.- DÓLAR ESTADOUNIDENSE (USD)
2.- EURO (EUR)
3.- PESO CHILENO (CLP)
4.- PESO ARGENTINO (ARS)
5.- REAL BRASILEÑO (BRL)
6.- DÓLAR CANADIENSE (CAD)
7.- YEN JAPONÉS (JPY)
8.- Volver al menú principal
Ingrese su elección: 2
Ingrese la cantidad de USD que desea convertir: 100
La conversión de 100.00 USD a EUR es: 92.00
Seleccione una divisa para convertir:
...
```

## Contribuciones

¡Las contribuciones son bienvenidas! Si deseas mejorar este proyecto, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una rama para tu función o corrección de errores:
   ```bash
   git checkout -b mi-nueva-funcion
   ```
3. Realiza tus cambios y haz commits:
   ```bash
   git commit -m "Agrega nueva función"
   ```
4. Sube tus cambios a tu repositorio:
   ```bash
   git push origin mi-nueva-funcion
   ```
5. Abre un pull request en este repositorio.

## Créditos

- Desarrollado por Javoide.
- Datos obtenidos de [ExchangeRate-API](https://www.exchangerate-api.com/).
