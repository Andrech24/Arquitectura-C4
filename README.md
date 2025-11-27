# SCI-SRI-ANT (versión corregida)

Este proyecto contiene:

- `frontend-react/`: Aplicación React (Vite) que consume el backend.
- `backend-java/api-gateway/`: Proyecto Spring Boot que expone `/api/consulta`.
- `backend-java/licencia-service/`: Microservicio Spring Boot que expone `/api/licencia` e implementa caché en memoria frente al servicio de la ANT (simulado).

## Cómo ejecutar

### 1. Microservicio de Licencias (puerto 8082)

```bash
cd backend-java/licencia-service
mvn -U clean package
mvn spring-boot:run
```

### 2. API Gateway (puerto 8080)

En otra terminal:

```bash
cd backend-java/api-gateway
mvn -U clean package
mvn spring-boot:run
```

### 3. Frontend React

En una tercera terminal:

```bash
cd frontend-react
npm install
npm run dev
```

Luego abre la URL que indique Vite (por defecto `http://localhost:5173`).

