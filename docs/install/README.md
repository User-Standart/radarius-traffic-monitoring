# 📖 Installation Manual - Radarius

Welcome to the **Radarius** installation guide! This document walks you step by step through setting up and running the full application.

## 🎯 What will you install?

This project consists of:
- **Frontend**: Web interface built with Vue.js 3
- **Backend**: RESTful API built with Spring Boot (Java 21)
- **Database**: Oracle Database (via Oracle Cloud)
- **Docker**: To orchestrate and run all services

## 📋 Prerequisites

Before you start, you will need the following installed on your machine:

### Required:
- **[Git](https://git-scm.com/downloads)** - To clone the repository
- **[Docker Desktop](https://www.docker.com/products/docker-desktop/)** - For Windows, Linux or Mac
  - ⚠️ Make sure Docker Desktop is running before continuing

### Optional (only if NOT using Docker):
- **[Node.js 20+](https://nodejs.org/)** and npm - To run the frontend manually
- **[Java 21](https://www.azul.com/downloads/?version=java-21-lts&package=jdk#zulu)** - To run the backend manually

## 🚀 Quick Install (Recommended)

### Step 1: Clone the repository

Open a terminal and run:

```bash
git clone https://github.com/User-Standart/API-4SEM.git
cd API-4SEM
```

### Step 2: Configure the Oracle Wallet

The project uses Oracle Database with Wallet authentication. Make sure the `Wallet_radarius` folder is present at:

```
API-4SEM-BACKEND/Wallet_radarius/
```

> 💡 **Note**: The Wallet files are required to connect to the Oracle database.

### Step 3: Start the application with Docker

From the project root directory (`API-4SEM`), run:

```bash
docker-compose up --build
```

This command will:
- ✅ Build the frontend and backend Docker images
- ✅ Start the containers
- ✅ Set up the network between the services
- ✅ Make the application available

**Wait a few minutes** while Docker downloads the dependencies and builds the containers. You will see logs in the terminal showing the progress.

### Step 4: Access the application

Once startup is complete, open:

- **🌐 Frontend**: http://localhost
- **🔧 Backend API**: http://localhost:8080
- **💚 Health Check**: http://localhost:8080/actuator/health

## 🎨 Development Mode

If you prefer to run the application in development mode (without Docker):

### Frontend
```bash
cd API-4SEM-FRONTEND
npm install
npm run dev
```
Open: http://localhost:5173

### Backend
```bash
cd API-4SEM-BACKEND
./gradlew bootRun
```
or
```bash
java -jar build/libs/radarius-backend.jar
```

## 🛠️ Useful Docker Commands

### View application logs
```bash
# View all logs
docker-compose logs -f

# View backend logs only
docker-compose logs -f backend

# View frontend logs only
docker-compose logs -f frontend
```

### Stop the application
```bash
docker-compose down
```

### Stop and remove volumes
```bash
docker-compose down -v
```

### Rebuild after changes
```bash
docker-compose up --build
```

### Run in the background (detached mode)
```bash
docker-compose up -d
```

## 🔧 Troubleshooting

### ❌ Port 80 or 8080 is already in use

**Problem**: Another service is using the required ports.

**Solution**: Edit the `docker-compose.yml` file and change the ports:

```yaml
services:
  backend:
    ports:
      - "8081:8080"  # Change 8080 to 8081
  frontend:
    ports:
      - "3000:80"    # Change 80 to 3000
```

### ❌ Docker is not running

**Problem**: Docker Desktop has not been started.

**Solution**:
- On Windows: Open Docker Desktop from the Start menu
- On Linux: Run `sudo systemctl start docker`
- On Mac: Open Docker Desktop from the Applications folder

### ❌ Database connection error

**Problem**: Wallet files are missing or invalid.

**Solution**:
1. Check that the `API-4SEM-BACKEND/Wallet_radarius` folder exists
2. Check that the Wallet files are present
3. Make sure you are using valid Wallet files for your Oracle instance

### ❌ Build failed

**Problem**: Error while building the Docker images.

**Solution**:
1. Clean up old images:
   ```bash
   docker-compose down --rmi all
   docker system prune -a
   ```
2. Rebuild:
   ```bash
   docker-compose up --build
   ```

## 📊 Checking that everything works

Run these checks to make sure everything is OK:

1. ✅ **Docker**: `docker ps` should show 2 running containers
2. ✅ **Backend**: Open http://localhost:8080/actuator/health - it should return `{"status":"UP"}`
3. ✅ **Frontend**: Open http://localhost - the home page should load
4. ✅ **Logs**: `docker-compose logs` should not show critical errors

## 📚 Next Steps

Now that the application is installed and running:

1. 📖 Check the [User Manual](../user/README.md) to learn how to use the system
2. 🔍 See the [API Documentation](../../README.md#api-documentation) to understand the endpoints
3. 🗄️ Check the [Database Modeling](../../README.md#database-modeling)
