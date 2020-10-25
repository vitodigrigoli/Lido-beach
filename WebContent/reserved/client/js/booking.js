$(document).ready( function(){
	
	$( 'form' ).submit( function( e ){
		
		e.preventDefault();
		
		$.ajax({
			url: '/AvailableUmbrellasServlet',
			method: 'post',
			data: { date: $( "#date" ).val() },
			success: function( response ){
				$( '#AjaxResponse' ).html( response )
			}
		})
	})
	
	$(document).on('click', 'i.fa-cart-arrow-down', function () {
			let idValue = $(this).attr( 'id' )
			let bookingData = $("input").val();
										
				$.ajax({
	                url: "/BookingConfirmationServlet",
	                method: "post",
	                data: {
	                    umbrellaID: idValue,
						bookingDate: $( "#date" ).val()
	                },
	                success: function ( response ) {
            			window.location.href = "/reserved/client/confirm.jsp";
	                }

            	})		
		})
})