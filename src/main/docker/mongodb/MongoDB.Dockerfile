FROM mongo:3.4.8
ADD mongodb/scripts/users.sh /docker-entrypoint-initdb.d/users.sh
