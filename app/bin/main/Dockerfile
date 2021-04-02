FROM postgres
ENV POSTGRES_USER maurice
ENV POSTGRES_PASSWORD passw0rd
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432