$(document).ready( function(){
	
	let dateToday = getDateToday()
	
	// displays today's orders arrived at the loading of the page
	showOrders( dateToday )
	
	// updates the today's orders every minute
	setInterval( function(){ showOrders( dateToday ) }, 60000 )
	
	// marks the order as completed and updates today's orders
	$(document).on('click', '.fa-check', function () {
			let idValue = $(this).attr( 'id' )
			
			if( confirm( "Do you confirm that you have completed order " + idValue + "?" ) ){
				$.ajax({
	                url: "/CompleteOrderKitchenServlet",
	                method: "post",
	                data: {
	                    orderID: idValue
	                },
	                success: function ( response ) {
						if( response ==="SUCCESS"){
							showOrders( dateToday ) // updates the today's orders
						}			
						else{
							alert( response )
						}
	                }

            	})		
			}
		})
	
	
})

function showOrders( dateToday ){

	$.ajax({
		url: "/ShowOrdersKitchenServlet",
		method: "post",
		data: { dateToday: dateToday},
		success: function( response ){
			$('#AjaxShowOrders').html( response )
		}
	})
}

function getDateToday(){
	
	let d = new Date()
	let year = d.getFullYear()
	let month = d.getMonth() + 1
	let day = d.getDate()
	let dateToday = year + "/" + month + "/" + day
	
	return dateToday
}