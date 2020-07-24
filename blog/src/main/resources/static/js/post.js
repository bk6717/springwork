let index = {
	
	init: function(){
		//리스너
		$("#btn-save").on("click", ()=>{
			//콜백 스택
			this.save();
		});
		
	},
	
	save : function(){
		let data = {
			title : $("#title").val(),
			content : $("#content").val(),
			userId: $("#userId").val()	
		};
		
		$.ajax({
			type : "POST",
			url : "/post",
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			dataType : "json"
		}).done(function(resp){
			if(resp.statusCode == 1){
				console.log(resp);
				alert("글쓰기 성공");
				location.href="/";
			}
			console.log(resp);
		}).fail(function(error){
			alert("글쓰기 실패");
			console.log(error);
		})
	},
			
}

index.init();