# MiniInventario

Sistema de gestion de inventario con catalogo de categorias y productos.

## Stack

| Capa | Tecnologia |
|------|------------|
| Backend | Spring Boot 4 + Java 21 |
| Base de datos | PostgreSQL |
| Frontend | Angular 21 + Bootstrap 5 |
| Despliegue | Render (API) + GitHub Pages (Frontend) |

## Estructura del proyecto

```
MiniInventario/
├── src/main/java/com/ipn/mx/miniinventario/
│   └── core/
│       ├── entidades/        # Producto, Categoria, Archivo
│       └── features/         # Controladores, servicios, repositorios
├── frontend/                 # Aplicacion Angular
│   └── src/
│       ├── app/model/        # Modelos de datos
│       ├── app/service/      # Servicios HTTP
│       └── components/       # Componentes UI
├── docker-compose.yml        # PostgreSQL local
└── pom.xml
```

## Ejecucion local

```bash
# 1. PostgreSQL (requiere Docker)
docker compose up -d

# 2. Backend (puerto 8085)
./mvnw spring-boot:run

# 3. Frontend (puerto 4200)
cd frontend && npm install && npm start
```

Abrir http://localhost:4200

## Endpoints API

| Metodo | Ruta | Descripcion |
|--------|------|-------------|
| GET | `/api/v1/categorias/categoria` | Listar categorias |
| GET | `/api/v1/categorias/categoria/{id}` | Ver categoria |
| POST | `/api/v1/categorias/categoria` | Crear categoria |
| PUT | `/api/v1/categorias/categoria/{id}` | Actualizar categoria |
| DELETE | `/api/v1/categorias/categoria/{id}` | Eliminar categoria |
| GET | `/api/v1/productos` | Listar productos |
| GET | `/api/v1/productos/{id}` | Ver producto |
| POST | `/api/v1/productos` | Crear producto |
| PUT | `/api/v1/productos/{id}` | Actualizar producto |
| DELETE | `/api/v1/productos/{id}` | Eliminar producto |

Swagger disponible en `/documentacion/swagger-ui.html`
