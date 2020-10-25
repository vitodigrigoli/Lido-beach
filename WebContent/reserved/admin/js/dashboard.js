$(document).ready( function () {
	
	let dateToday = getDateToday()
	
	printEarnings( dateToday, dateToday, "#AjaxEarningsToday" )
	printOrders( 'K', dateToday, dateToday, "#AjaxKitchenOrdersToday", "N" )
	printOrders( 'U', dateToday, dateToday, "#AjaxUmbrellaOrdersToday", "N" )
	
	$( "#earningCustom" ).submit( function( e ){
		
		e.preventDefault()
		
		let dateFrom = $( "#dateFrom" ).val()
		let dateTo = $( "#dateTo" ).val()
		
		printEarnings( dateFrom, dateTo, "#AjaxEarningsCustom" )
	})
	
	$( "#ordersCustom" ).submit( function( e ){
		
		e.preventDefault()
		
		let dateFrom = $( "#dateFromC" ).val()
		let dateTo = $( "#dateToC" ).val()
		let type = $( "#type" ).val()
		
		printOrders( type, dateFrom, dateTo, "#AjaxOrdersCustom", "Y" )
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

function printEarnings( dateFrom, dateTo, divID ){	
	
	$.ajax({
		url: "/EarningsServlet",
		method: "post",
		data: {
			dateFrom: dateFrom,
			dateTo: dateTo
		},
		success: function( response ){
			$( divID ).html( response )
		}
	})
}

function printOrders( typeOrder, dateFrom, dateTo, divID, printTableFlag ){	
	
	$.ajax({
		url: "/OrdersServlet",
		method: "post",
		data: {
			typeOrder: typeOrder, 
			dateFrom: dateFrom,
			dateTo: dateTo,
			printTableFlag: printTableFlag
		},
		success: function( response ){
			$( divID ).html( response )
		}
	})
}