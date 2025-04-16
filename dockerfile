FROM eclipse-temurin:17-jdk-alpine

# Instala Maven e compila o projeto
RUN apk add --no-cache maven

WORKDIR /app
COPY . .

RUN mvn clean package -DskipTests

# Copia o .jar gerado (ajuste o nome se for diferente)
COPY /app/target/haraspro-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
