/**
 * 
 */

$(function(){
	$(".repeat").on("click",function(e){
		if( $(e.target).hasClass("toggle")==false){
			$(e.target).addClass("toggle");

		}else{
			$(e.target).removeClass("toggle");

		}
		
	})
	$(".favorite").on("click",function(e){
		
		if( $(e.target).hasClass("toggle")==false){
			$(e.target).addClass("toggle");
			$(e.target).text("favorite");

		}else{
			$(e.target).removeClass("toggle");
			$(e.target).text("favorite_border");

		}
		
	})
	
	$(".bookmark").on("click",function(e){
		
		if( $(e.target).hasClass("toggle")==false){
			$(e.target).addClass("toggle");
			$(e.target).text("bookmark");

		}else{
			$(e.target).removeClass("toggle");
			$(e.target).text("bookmark_border");

		}
		
	})
	
})