$(document).ready(function() {
    $('#colorInput').on('input', function() {
        let fragment = $('#colorInput').val();
        if (fragment.length > 0) {
            $.ajax({
                url: '/getColorName',
                type: 'GET',
                data: { fragment: fragment },
                success: function(data) {
                    if (data) {

                       let suggestions= $('#hiddenDiv');
                       suggestions.show();
                       suggestions.empty();
                        data.forEach(function(color) {
                            suggestions.append("<li class='suggestion-item'>" + color.colorName + "</li>");
                            $('.suggestion-item').css({
                                'list-style': 'none',
                                'padding': '5px 10px',
                                'cursor': 'pointer',
                                'border-bottom': '1px solid #ddd'
                            });

                            // Adding hover effect to suggestion items
                            $('.suggestion-item').hover(
                                function() {
                                    $(this).css('background-color', '#e0e0e0');
                                },
                                function() {
                                    $(this).css('background-color', '#f9f9f9');
                                }
                            );

                        });
                    } else {
                        $('#colorDisplay').text('No color found');
                        $('#hiddenDiv').show();
                        suggestions.empty();
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

    $(document).on('click', '.suggestion-item', function() {
        let selectedColor = $(this).text();
        $("#colorInput").val(selectedColor);
        $("#suggestions").empty();
        $('#hiddenDiv').hide();
    });

});
