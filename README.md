# Restech - Sistema de Gestión para Restaurantes

## Descripción

**Restech** es una aplicación de escritorio desarrollada en Java para la gestión integral de restaurantes. El sistema permite administrar todos los aspectos operativos de un restaurante, desde el control de inventario y proveedores hasta la gestión de platos y pedidos.

##  Características Principales

- ** Gestión de Usuarios**: Sistema de autenticación con diferentes niveles de permisos
- ** Gestión de Proveedores**: Administración completa de información de contacto y servicios
- ** Control de Inventario**: Gestión de materias primas con seguimiento de:
  - Precios y costos
  - Fechas de caducidad
  - Cantidad utilizada
  - Control de merma
- ** Gestión de Platos**: Configuración de menú con precios y tiempos de preparación
- ** Gestión de Pedidos**: Control de pedidos a proveedores
- **Almacén**: Control de stock y almacenamiento
- **Relaciones Ingredientes-Platos**: Tracking de qué materias primas requiere cada plato

##  Tecnologías Utilizadas

- **Lenguaje**: Java 17
- **Gestión de Dependencias**: Maven
- **Base de Datos**: MySQL
- **Interfaz Gráfica**: Java Swing
- **Patrón de Arquitectura**: MVC (Modelo-Vista-Controlador)
- **Librerías Principales**:
  - Apache POI (manipulación de archivos Excel)
  - MySQL Connector
  - Apache Log4j (logging)
  - Commons IO (operaciones de archivos)

##  Estructura del Proyecto

```
Restech/
├── src/
│   ├── controlador/           # Lógica de control y coordinación
│   │   ├── Main.java         # Punto de entrada de la aplicación
│   │   └── ControladorEventos.java
│   ├── modelo/               # Capa de datos y lógica de negocio
│   │   ├── entidad/         # Entidades del dominio
│   │   ├── negocio/         # Lógica de negocio
│   │   └── persistance/     # Acceso a datos
│   ├── vistas/              # Interfaces de usuario
│   ├── imagenes/            # Recursos gráficos
│   └── ControladorMySql/    # Gestión de base de datos
├── font/                    # Fuentes personalizadas
├── lib/                     # Librerías externas
├── script_BBDD_datos.sql    # Script de base de datos
├── restech.jar             # Archivo ejecutable JAR
├── Restech.exe             # Ejecutable para Windows
└── pom.xml                 # Configuración de Maven
```

##  Base de Datos

El sistema utiliza MySQL con las siguientes entidades principales:

- **Usuarios**: Gestión de usuarios del sistema
- **Proveedores**: Información de proveedores
- **Materias_Primas**: Inventario de ingredientes
- **Platos**: Catálogo de platos del restaurante
- **Pedido**: Órdenes a proveedores
- **Platos_MateriasPrimas**: Relación entre platos e ingredientes

##  Instalación y Configuración

### Prerrequisitos

- Java 17 o superior
- Maven 3.6+
- MySQL 8.0+
- IDE compatible con Java (Eclipse, IntelliJ IDEA, etc.)


## Uso de la Aplicación

### Inicio de Sesión
1. Ejecutar la aplicación
2. Introducir credenciales de usuario
3. Acceder al panel principal según permisos

### Funcionalidades Principales

**Gestión de Almacén**
- Consultar stock actual
- Añadir/editar materias primas
- Control de fechas de caducidad

**Gestión de Platos**
- Crear nuevos platos
- Configurar ingredientes necesarios
- Establecer precios y tiempos

**Gestión de Pedidos**
- Realizar pedidos a proveedores
- Seguimiento de entregas
- Control de costos

**Gestión de Proveedores**
- Añadir nuevos proveedores
- Actualizar información de contacto
- Historial de pedidos





### Generar ejecutable
El proyecto incluye configuración para generar:
- JAR ejecutable con todas las dependencias
- Ejecutable .exe para Windows (usando Launch4j)


##  Estructura de Datos

### Entidades Principales

- **Usuario**: ID, Nombre, Permisos, Código
- **Proveedor**: ID, Nombre, Descripción, Contacto, Dirección
- **MateriaPrima**: ID, Nombre, Precio, Proveedor, Fecha Caducidad, Cantidad, Merma
- **Plato**: ID, Nombre, Precio, Tiempo de Preparación
- **Pedido**: ID, Usuario, Proveedor, Materia Prima, Cantidad, Fecha, Precio


