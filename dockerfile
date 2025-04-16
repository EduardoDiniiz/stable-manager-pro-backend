FROM eclipse-temurin:17-jdk-alpine

# Instala Maven
RUN apk add --no-cache maven

# Cria diretório da aplicação
WORKDIR /app

# Copia o código-fonte do projeto
COPY . .

# Compila o projeto e gera o .jar
RUN mvn clean package -DskipTests

# Expõe a porta 8080 (usada pela aplicação)
EXPOSE 8080

# Executa a aplicação
CMD ["java", "-jar", "target/haraspro-0.0.1-SNAPSHOT.jar"]
