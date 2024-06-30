# Color Search Application

## Opis projektu

Color Search Application to aplikacja internetowa oparta na Spring Boot, która umożliwia użytkownikom wyszukiwanie kolorów na podstawie numeru koloru. Aplikacja wyświetla odpowiedni kolor, jego recepturę oraz cenę, a także zapisuje historię wyszukiwań użytkowników.

## Funkcjonalności

1. **Wyszukiwanie koloru**:
   - Użytkownik wprowadza numer koloru w formularzu na stronie.
   - Za pomocą JavaScript i AJAX numer koloru jest przesyłany do serwera Spring Boot.

2. **Wyświetlanie koloru**:
   - Serwer zwraca informacje o kolorze, takie jak receptura i cena.
   - Kolor jest wyświetlany na stronie wraz z jego recepturą i ceną.

3. **Historia wyszukiwań**:
   - Aplikacja zapisuje historię wyszukiwanych kolorów w bazie danych.
   - Historia wyszukiwań jest wyświetlana na stronie użytkownika, umożliwiając przeglądanie wcześniej wyszukiwanych kolorów.

4. **Interfejs użytkownika**:
   - Formularz do wpisania numeru koloru.
   - Sekcja wyświetlania informacji o kolorze (kolor, receptura, cena).
   - Sekcja komentowania koloru.

## Technologie

- **Backend**:
  - Spring Boot: Framework do tworzenia aplikacji webowych.
  - Spring Data JPA: Ułatwia dostęp do bazy danych.
  - MySQL: Relacyjna baza danych do przechowywania informacji o kolorach i historii wyszukiwań.

- **Frontend**:
  - HTML/CSS: Struktura i stylizacja stron internetowych.
  - JavaScript (jQuery): Obsługa interakcji użytkownika.
  - AJAX: Asynchroniczne przesyłanie danych między przeglądarką a serwerem.

- **Inne**:
  - Maven: Narzędzie do zarządzania zależnościami i budowania projektu.

## Instalacja

1. **Klonowanie repozytorium**:
    ```sh
    git clone https://github.com/matysz2/Color-Search-Application.git
    cd Color-Search-Application
    ```

2. **Konfiguracja bazy danych**:
   - Skonfiguruj połączenie z bazą danych MySQL w pliku `application.properties` lub `application.yml`.

3. **Instalacja zależności**:
   - Zainstaluj zależności za pomocą Mavena:
     ```sh
     mvn install
     ```

4. **Uruchomienie aplikacji**:
   - Uruchom aplikację Spring Boot:
     ```sh
     mvn spring-boot:run
     ```

## Użytkowanie

1. **Wyszukiwanie koloru**:
   - Otwórz stronę aplikacji w przeglądarce.
   - Wprowadź numer koloru w formularzu i kliknij przycisk "Wyszukaj".
   - Aplikacja wyświetli informacje o kolorze.
   - Aplikacja obliczy komponenty na podaną ilość koloru i cenę.
   - Możliwość zapisu koloru.

2. **Przeglądanie historii wyszukiwań**:
   - Przejdź do sekcji historii wyszukiwań na stronie użytkownika.
   - Zobacz listę wcześniej wyszukiwanych kolorów.

## Przyszłe plany

- Rozbudowa funkcji wyświetlania historii o możliwość filtrowania i sortowania.
- Integracja z zewnętrznymi API do uzyskiwania dodatkowych informacji o kolorach.
- Możliwość obliczenia marży oraz narzutu na podany kolor.

## Wkład

Wszelkie wkłady do projektu są mile widziane! Prosimy o zgłaszanie problemów oraz propozycji usprawnień za pośrednictwem systemu zgłoszeń w GitHubie.

