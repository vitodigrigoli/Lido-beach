$(document).ready( function() {
	
	showCart()
	
	$(document).on( 'click', '.fa-minus-square', function(){
		
		let idValue = $(this).attr( 'id' )

		$.ajax({
			url: "/RemoveItemServlet",
			method: "post",
			data: { itemIndex: idValue },
			success: function( response ){
				showCart()
			}
		})
	})
	
	$('form').submit( function( e ){
		e.preventDefault()
		
		let time = getTime()
		let date = getDateToday()
		let note = $('textarea').val()
		
		$.ajax({
			url: "/InsertOrderKServlet",
			method: "post",
			data: {
				date: date,
				time: time,
				note: note
			},
			success: function( response ){
				if( response ==="SUCCESS" ){
					window.location.href = "/reserved/client/ordersuccessfull.jsp";
				}
				else{
					window.location.href = "/reserved/client/error.jsp";
				}
			}
		})

	})	
})

function getDateToday(){
	
	let d = new Date()
	let year = d.getFullYear()
	let month = d.getMonth() + 1
	let day = d.getDate()
	let dateToday = year + "/" + month + "/" + day
	
	return dateToday
}

function getTime(){
	
	let d = new Date()
	let h = d.getHours()
	let m = d.getMinutes()
	let s = d.getSeconds()
	
	let time = h + ":" + m + ":" + s
	return time
}

function showCart(){
	
	$.ajax({
			url: "/ShowCartServlet",
			method: "post",
			success: function( response ){
				 $('#AjaxShowCart').html( response )			
			}
		})
	
}