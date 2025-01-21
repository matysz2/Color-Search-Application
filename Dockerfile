# Użyj obrazu z Mavenem jako bazowego (umożliwia budowanie aplikacji za pomocą Maven)
FROM maven:3.8.4-openjdk-11-slim AS build

# Skopiuj pliki aplikacji (pom.xml i źródła) do obrazu
WORKDIR /app
COPY pom.xml .

# Zbuduj aplikację przy użyciu Maven (jeśli masz zależności, zostaną pobrane)
RUN mvn dependency:go-offline

# Skopiuj kod źródłowy do kontenera
COPY src /app/src

# Zbuduj aplikację za pomocą Maven
RUN mvn clean package -DskipTests

# Użyj obrazu z OpenJDK do uruchomienia aplikacji (mniejszy obraz)
FROM openjdk:11-jre-slim

# Skopiuj zbudowany plik .jar do obrazu
COPY --from=build /app/target/Color-Search-Application.jar /app/Color-Search-Application.jar

# Uruchom aplikację Java
CMD ["java", "-jar", "/app/Color-Search-Application.jar"]
