$(document).ready(function() {
    $('#colorInput').on('input', function() {
        let colorName = $(this).val();
        if (colorName) {
            $.ajax({
                url: 'getColorName',
                type: 'GET',
                data: { colorName: colorName },
                success: function(response) {
                    $('#colorDisplay').text(response);
                    $('#hiddenDiv').show();
                }
            });
        } else {
            $('#colorDisplay').text('');
            $('#hiddenDiv').hide();
        }
    });

    $('#colorForm').on('submit', function(event) {
        event.preventDefault();
        let selectedColor = $('#colorInput').val();
        $.ajax({
            url: 'submitColor',
            type: 'POST',
            data: { colorName: selectedColor },
            success: function(response) {
                alert('Color submitted successfully!');
            }
        });
    });
});
