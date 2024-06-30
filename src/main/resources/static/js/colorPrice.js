$(document).ready(function () {
    // Zablokowanie domyślnego działania formularza

    $('#colorInput').on('input', function () {
        $('#result').hide();
        $('.comments').hide();
    });
    // Obsługa przycisku "Oblicz"
    $('#calculate').click(function () {
        const inputValue = $('#value').val();
        const ilosElements = document.querySelectorAll('.ilos');

        if (isNaN(inputValue) || inputValue <= 0 || inputValue === null || inputValue === undefined) {
            $(".info2").text("Proszę podać prawidłową ilość").fadeIn();
            setTimeout(function() {
                $(".info2").fadeOut();
            }, 3000);
            return;

        }
        ilosElements.forEach(element => {
            // Zmiana zawartości każdego elementu <span> na '2 kg'
            element.innerText = inputValue;
        });
        $('tbody tr').each(function () {
            const $row = $(this);
            const originalQuantity = parseFloat($row.find('.quantity').data('originalQuantity'));
            const originalPrice = parseFloat($row.find('.price').data('originalPrice'));

            const newQuantity = originalQuantity * inputValue;
            const newPrice = originalPrice * inputValue;

            $row.find('.quantity').text(newQuantity.toFixed(2));
            $row.find('.price').text(newPrice.toFixed(2));
        });
    });


    $('#reset').click(function () {
        // Przywrócenie pierwotnych wartości
        $('tbody tr').each(function () {
            const $row = $(this);
            const originalQuantity = $row.find('.quantity').data('originalQuantity');
            const originalPrice = $row.find('.price').data('originalPrice');

            $row.find('.quantity').text(originalQuantity.toFixed(2));
            $row.find('.price').text(originalPrice.toFixed(2));
        });
    });

    // Zapisanie pierwotnych wartości jako atrybutów danych
    $('tbody tr').each(function () {
        const $row = $(this);
        const originalQuantity = parseFloat($row.find('.quantity').text());
        const originalPrice = parseFloat($row.find('.price').text());

        $row.find('.quantity').data('originalQuantity', originalQuantity);
        $row.find('.price').data('originalPrice', originalPrice);
    });
});
