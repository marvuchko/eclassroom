# Recompile the project
./mvnw clean install

# Stop the running containers if there is any
docker-compose down

# Run the containers
docker-compose up --build