# Watchops Backend

Alle folgenden Befehle gehen davon aus, das man im Wurzelverzeichnis des Repositorys ist

## Bauen

### JAR
mvn -f backend/pom.xml package

### Docker Container

docker build -t watchops_backend backend/docker

## Starten

docker compose --file backend/docker/docker-compose.yml up watchopsB