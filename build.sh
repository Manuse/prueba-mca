mvn clean install -Dmaven.test.skip=true
cd ./products-ms
mvn spring-boot:build-image -Dmaven.test.skip=true
cd ..
docker-compose up -d products