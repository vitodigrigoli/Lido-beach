$(document).ready( function(){
	
	let date = getDateToday()
		let time = getTime()
		
		let id = $('td').val()
	
	$('form').submit( function( e ){
		e.preventDefault()
		
		let time = getTime()
		let date = getDateToday()
		let note = $('textarea').val()
		
		$.ajax({
			url: "/InsertOrderU",
			method: "post",
			data: {
				date: date,
				time: time,
				note: note
			},
			success: function( response ){
				if( response ==="SUCCESS" ){
					window.location.href = "/reserved/client/paymentsuccessfull.jsp";
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