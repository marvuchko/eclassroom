# Recompile the project
./mvnw clean install

# Stop all other containers
docker-compose down

# Run the containers
docker-compose up --build