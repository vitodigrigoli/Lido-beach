$(document).ready( function () {

    $("form").submit( function ( e ) {

        e.preventDefault();

        if( $('#firstName')[0].checkValidity() && $('#lastName')[0].checkValidity() && $('#email')[0].checkValidity() && $('#password')[0].checkValidity() ){

            $.ajax({
                url: "/RegisterServlet",
                method: "post",
                data: {
                    firstName: $('#firstName').val(),
                    lastName: $('#lastName').val(),
                    email: $('#email').val(),
                    password: $('#password').val()
                },
                success: function ( response ) {
                    $('#ajaxResponse').html( response )
                }

            })
        }

    })
})