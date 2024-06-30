$(document).ready(function () {
    $('.save').on('click', function () {

        const customerId = $('.user').text().trim();
        // Pobranie customerId zalogowanego użytkownika

        // Pobranie nazwy koloru (przyjmujemy, że jest wprowadzona w formularzu lub na stronie)
        let colorName = $('.info .color').text().trim();

        // Pobranie ceny koloru (przyjmujemy, że jest jedna cena, więc pobieramy pierwszą)
        var colorPrice = $('.price').first().text().trim(); // Pobieramy tekst z pierwszego elementu o klasie "price"

        // Pobranie ilości koloru wprowadzonej przez użytkownika
        var quantity = $('#value').val(); // Pobieramy wartość z pola input o id "value"

        if (!customerId || !colorName || !colorPrice || !quantity) {
            // Jeśli jakieś pole jest puste, wyświetlamy komunikat i przerywamy działanie
            $('.info2').append('<p>Proszę wypełnić wszystkie pola przed zapisem.</p>');
            return; // Przerywamy działanie funkcji, nie wysyłamy żądania AJAX
        }
        // Tworzenie obiektu colorData
        const colorData = {
            customer: customerId ? {id: parseInt(customerId)} : null, // Sprawdzenie, czy customerId nie jest null
            colorName: colorName,
            price: parseFloat(colorPrice), // Konwersja ceny na float
            quantity: parseFloat(quantity) // Konwersja ilości na integer
        };


        $.ajax({
            url: "/addColor",
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(colorData),
            success: function (response) {
                $(".info2").text("Kolor zapisany poprawnie").fadeIn();
                setTimeout(function() {
                    $(".info2").fadeOut();
                }, 3000);
                return;

            },
            error: function (error) {
                $(".info2").text("Błąd zapisu koloru").fadeIn();
                setTimeout(function() {
                    $(".info2").fadeOut();
                }, 3000);

            }
        });
    });
});
