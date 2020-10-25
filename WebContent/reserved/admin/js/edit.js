$(document).ready( function () {

    $("#addUser").submit( function ( e ) {

        e.preventDefault();

        if( $('#firstName')[0].checkValidity() && $('#lastName')[0].checkValidity() && $('#email')[0].checkValidity() && $('#password')[0].checkValidity() ){

            $.ajax({
                url: "/RegisterServlet",
                method: "post",
                data: {
                    firstName: $('#firstName').val(),
                    lastName: $('#lastName').val(),
                    email: $('#email').val(),
                    password: $('#password').val(),
					role: $('#roleAdd').val()
                },
                success: function ( response ) {
                    $('#ajaxResponseAdd').html( response )
                }

            })
        }

    })

	$("#removeUser").submit( function ( e ) {

        e.preventDefault();

            $.ajax({
                url: "/ShowUserServlet",
                method: "post",
                data: {
                    role: $('#roleRemove').val(),
                },
                success: function ( response ) {
                    $('#ajaxResponseRemove').html( response )
                }

            })
        })

		
		$(document).on('click', '.fa-user-minus', function () {
			
			let idValue = $(this).attr( 'id' )
			if( confirm( "Are you sure you want to delete the user " + idValue + "?" ) ){
				
				$.ajax({
	                url: "/DeleteUserServlet",
	                method: "post",
	                data: {
	                    email: idValue
	                },
	                success: function ( response ) {
	                    $('#ajaxResponseRemove').html( response )
	                }

            	})			
			}
		})

    
})