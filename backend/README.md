# Watchops Backend

Das Watchops Backend besteht aus einer SpringBoot-Application und einer Datenbank. Diese werden mithilfe von einer Compose-Datei gepullt und gestartet.


!!! Noch WIP, Entrypoint fehlt.

## Docker-Compose Datei

docker compose --file backend/docker/docker-compose.yml up watchopsB

```yaml
services:

  db:
    container_name: watchops_db
    image: mariadb
    restart: always
    environment:
      MARIADB_ROOT_PASSWORD: test
  watchopsB:
    image: "ghcr.io/likeanshadow/watchops:backend"
    #restart: always
    ports:
      - "8080:8080"
    depends_on:
      - db
    environment:
      DB_HOST: watchops_db
      DB_USER: root
      DB_PASSWORD: test
      DB_NAME: watchops
      SUBPATH: /api
```

## Starten des Backends

```bash
docker compose --file backend/docker/docker-compose.yml run --service-ports watchopsB
```

oder

```bash
docker-compose --file backend/docker/docker-compose.yml run --service-ports watchopsB
```