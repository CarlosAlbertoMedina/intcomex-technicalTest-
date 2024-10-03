# intcomex-technicalTest-
Repositorio de prueba técnica en proceso de selección 

Descripción

Este proyecto es una aplicación de gestión desarrollada con Java 17 y Spring 3, utilizando la arquitectura hexagonal para asegurar una separación clara entre la lógica de negocio y la infraestructura. Esta estructura permite una mayor flexibilidad y facilidad de prueba, facilitando la integración de diferentes componentes y adaptaciones a futuros requerimientos.
Características Principales

    Arquitectura Hexagonal: Separa la lógica de negocio de los detalles de implementación, permitiendo la fácil integración de nuevas funcionalidades y adaptaciones a diferentes entornos.
    Java 17: Aprovecha las últimas características del lenguaje, mejorando la legibilidad y rendimiento del código.
    Spring 3: Utiliza el marco de trabajo Spring para la gestión de dependencias, la inyección de servicios y la configuración de la aplicación.
    Pruebas Unitarias: Incluye un conjunto completo de pruebas unitarias escritas con JUnit, garantizando la calidad y estabilidad del código a lo largo del desarrollo.

Tecnologías Utilizadas

    Java 17
    Spring 3
    JUnit 5 para pruebas unitarias
    Maven para la gestión de dependencias y construcción del proyecto

Estructura del Proyecto

El proyecto está organizado en varios módulos, cada uno representando una parte clave de la aplicación, como:

    Dominio: Contiene la lógica de negocio y las entidades del modelo.
    Aplicación: Maneja la lógica de aplicación y las interacciones entre los casos de uso.
    Infraestructura: Implementa los adaptadores y puertos para la comunicación con bases de datos, servicios externos, etc.
    Pruebas: Contiene las pruebas unitarias y de integración para asegurar la funcionalidad del sistema.

Cómo Ejecutar el Proyecto

    Clona el repositorio:

    bash

git clone https://github.com/tu-usuario/tu-repo.git](https://github.com/CarlosAlbertoMedina/intcomex-technicalTest-.git

Navega al directorio del proyecto:

Construye el proyecto usando Maven:

bash
mvn clean install

Ejecuta la aplicación:

bash
mvn spring-boot:run

Ejecución de Pruebas

Para ejecutar las pruebas unitarias, utiliza el siguiente comando de Maven:
bash
mvn test

URL servicio desplegado: http://testjavaapp.us-east-1.elasticbeanstalk.com/

Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir a este proyecto, por favor abre un issue o envía un pull request.
Licencia

Si tienes alguna pregunta o sugerencia, no dudes en contactarnos.
