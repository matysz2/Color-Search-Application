$(document).ready(function() {
    // Zablokowanie domyślnego działania formularza
    $('#colorForm').submit(function(event) {
        event.preventDefault();
        let result = $('#result');
        result.show();

    });
    $('#colorInput').on('input', function() {
        $('#result').hide();
    });
    // Obsługa przycisku "Oblicz"
    $('#calculate').click(function() {
        const inputValue = $('#value').val();
        if (isNaN(inputValue) || inputValue <= 0) {
            alert('Proszę podać liczbę większą od 0');
            return;
        }
        $('tbody tr').each(function() {
            const $row = $(this);
            const originalQuantity = parseFloat($row.find('.quantity').data('originalQuantity'));
            const originalPrice = parseFloat($row.find('.price').data('originalPrice'));

            const newQuantity = originalQuantity * inputValue;
            const newPrice = originalPrice * inputValue;

            $row.find('.quantity').text(newQuantity.toFixed(2));
            $row.find('.price').text(newPrice.toFixed(2));
        });
    });


    $('#reset').click(function() {
        // Przywrócenie pierwotnych wartości
        $('tbody tr').each(function() {
            const $row = $(this);
            const originalQuantity = $row.find('.quantity').data('originalQuantity');
            const originalPrice = $row.find('.price').data('originalPrice');

            $row.find('.quantity').text(originalQuantity.toFixed(2));
            $row.find('.price').text(originalPrice.toFixed(2));
        });
    });

    // Zapisanie pierwotnych wartości jako atrybutów danych
    $('tbody tr').each(function() {
        const $row = $(this);
        const originalQuantity = parseFloat($row.find('.quantity').text());
        const originalPrice = parseFloat($row.find('.price').text());

        $row.find('.quantity').data('originalQuantity', originalQuantity);
        $row.find('.price').data('originalPrice', originalPrice);
    });
});
