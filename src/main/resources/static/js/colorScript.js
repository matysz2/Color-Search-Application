$(document).ready(function() {
    $('#colorInput').on('input', function() {
        let colorName = $('#colorInput').val();
        if (colorName.length > 0) {
            $.ajax({
                url: '/getColorName',
                type: 'GET',
                data: { colorName: colorName },
                success: function(data) {
                    if (data) {
                        $('#colorDisplay').text(data.colorName);
                        $('#hiddenDiv').show();
                    } else {
                        $('#colorDisplay').text('No color found');
                        $('#hiddenDiv').show();
                    }
                },
                error: function() {
                    $('#colorDisplay').text('Error retrieving color data');
                    $('#hiddenDiv').show();
                }
            });
        } else {
            $('#hiddenDiv').hide();
        }
    });
});
