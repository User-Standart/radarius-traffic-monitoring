# Docker Setup for Radarius Fullstack Application

This repository contains Docker configuration files to run the Radarius fullstack application with Spring Boot backend and Vue.js frontend.

## Prerequisites

- Docker Desktop or Docker Engine
- Docker Compose
- Oracle Database connection (already configured)

## Project Structure

```
API-4SEM/
├── API-4SEM-BACKEND/          # Spring Boot Backend
│   ├── Dockerfile
│   ├── .dockerignore
│   └── Wallet_radarius/       # Oracle Wallet files
├── API-4SEM-FRONTEND/         # Vue.js Frontend
│   ├── Dockerfile
│   ├── .dockerignore
│   └── nginx.conf
└── docker-compose.yml         # Main Docker Compose file
```

## Quick Start

1. **Clone the repository** (if not already done):
   ```bash
   git clone <repository-url>
   cd API-4SEM
   ```

2. **Build and start the application**:
   ```bash
   docker-compose up --build
   ```

3. **Access the application**:
   - Frontend: http://localhost
   - Backend API: http://localhost:8080
   - Backend Health Check: http://localhost:8080/actuator/health

## Available Commands

### Build and Start
```bash
# Build and start all services
docker-compose up --build

# Start in detached mode
docker-compose up -d --build

# Start specific service
docker-compose up backend
docker-compose up frontend
```

### Stop and Cleanup
```bash
# Stop all services
docker-compose down

# Stop and remove volumes
docker-compose down -v

# Stop and remove images
docker-compose down --rmi all
```

### Development Commands
```bash
# View logs
docker-compose logs -f

# View logs for specific service
docker-compose logs -f backend
docker-compose logs -f frontend

# Execute commands in running container
docker-compose exec backend bash
docker-compose exec frontend sh

# Rebuild specific service
docker-compose build backend
docker-compose build frontend
```

## Services

### Backend (Spring Boot)
- **Port**: 8080
- **Java Version**: 21
- **Framework**: Spring Boot 3.5.5
- **Database**: Oracle (using wallet authentication)
- **Health Check**: `/actuator/health`

### Frontend (Vue.js)
- **Port**: 80
- **Node Version**: 20
- **Framework**: Vue.js 3 with Vite
- **Web Server**: Nginx
- **API Proxy**: Routes `/api/*` to backend

## Environment Variables

The application uses the following environment variables:

- `TNS_NAME`: Oracle TNS name (default: radarius_high)
- `WALLET_DIR`: Path to Oracle wallet directory
- `SPRING_PROFILES_ACTIVE`: Spring profile (default: default)

## Database Connection

The application is configured to connect to an Oracle database using:
- Wallet-based authentication
- Connection pooling with Oracle UCP
- TNS configuration

Make sure your Oracle database is accessible and the wallet files are properly configured.

## Troubleshooting

### Common Issues

1. **Port conflicts**: If ports 80 or 8080 are already in use, modify the ports in `docker-compose.yml`

2. **Database connection issues**: 
   - Verify Oracle database is running
   - Check wallet files are properly mounted
   - Verify TNS configuration

3. **Build failures**:
   - Check Docker daemon is running
   - Verify all required files are present
   - Check Docker logs: `docker-compose logs`

### Health Checks

Both services include health checks:
- Backend: Checks `/actuator/health` endpoint
- Frontend: Checks if nginx is serving content

### Logs

View logs for debugging:
```bash
# All services
docker-compose logs -f

# Specific service
docker-compose logs -f backend
docker-compose logs -f frontend
```

## Development

For development, you can run individual services or modify the docker-compose.yml file to suit your needs.

### Modifying Configuration

- **Backend**: Modify `API-4SEM-BACKEND/src/main/resources/application.yaml`
- **Frontend**: Modify `API-4SEM-FRONTEND/vite.config.ts` or `nginx.conf`
- **Docker**: Modify `docker-compose.yml` for service configuration

## Production Considerations

For production deployment:

1. Use environment-specific configuration files
2. Set up proper secrets management
3. Configure SSL/TLS certificates
4. Set up monitoring and logging
5. Use production-grade database configurations
6. Consider using Docker Swarm or Kubernetes for orchestration

## Support

For issues related to:
- Docker configuration: Check this README and Docker logs
- Application functionality: Check the main project documentation
- Database connectivity: Verify Oracle database and wallet configuration
