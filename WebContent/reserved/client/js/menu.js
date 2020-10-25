$(document).ready( function(){
	
	$(document).on( 'click', '.cards__card', function(){
		
		let idValue = $(this).attr( 'id' )

		$.ajax({
			url: "/ShowMenuServlet",
			method: "post",
			data: { cat_id: idValue },
			success: function( response ){
				$( "#AjaxResponse" ).html( response )
			}
		})
	})
	
	$(document).on( 'click', 'i.fa-plus-square', function(){
		
		let foodID = $( this ).parent().prev().prev().prev().prev().text()
		
		$.ajax({
			url: "/CartServlet",
			method: "post",
			
			data: { foodID: foodID },
			success: function( response ){
				$( '#Ajax2' ).html( response )
			}
		})
			
	})
})