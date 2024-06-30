$(document).ready(function () {
    $('#comment').on('click', function () {

        const customerId = $('.user').text().trim();
        let colorName = $('.info .color').text().trim();
        let comment = $('.comments #comments').val().trim();

        if (!customerId || !colorName || !comment) {
            // Jeśli jakieś pole jest puste, wyświetlamy komunikat i przerywamy działanie
            $('.info3').append('<p>Proszę wypełnić wszystkie pola przed zapisem.</p>');
            return; // Przerywamy działanie funkcji, nie wysyłamy żądania AJAX
        }

        const commentData = {
            customer: customerId ? {id: parseInt(customerId)} : null, // Sprawdzenie, czy customerId nie jest null
            colorName: colorName,
            commentText: comment,

        };
        $.ajax({
            url: "/comment",
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(commentData),
            success: function (response) {

                $(".info3").text("Komentarz poprawnie dodany").fadeIn();
                setTimeout(function() {
                    $(".info3").fadeOut();
                }, 3000);

            },
            error: function (error) {
                $(".info3").text("Błąd dodania komentarza").fadeIn();
                setTimeout(function() {
                    $(".info3").fadeOut();
                }, 2000);
            }
        });
    });
});