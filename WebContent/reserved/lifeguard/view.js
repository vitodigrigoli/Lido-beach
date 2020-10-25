$(document).ready( function(){
	
	let dateToday = getDateToday()
	
	showBookedUmbrellas( dateToday )
	
})

function getDateToday(){
	
	let d = new Date()
	let year = d.getFullYear()
	let month = d.getMonth() + 1
	let day = d.getDate()
	let dateToday = year + "/" + month + "/" + day
	
	return dateToday
}

function showBookedUmbrellas( dateToday ){

	$.ajax({
		url: "/ShowBookedsUmbrellasServlet",
		method: "post",
		data: { dateToday: dateToday},
		success: function( response ){
			$('#AjaxResponse').html( response )
		}
	})
}