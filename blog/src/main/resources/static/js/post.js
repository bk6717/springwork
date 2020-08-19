let index = {
	
	init: function(){
		//리스너
		$("#btn-save").on("click", ()=>{
			//콜백 스택
			this.save();
		});
		$("#btn-delete").on("click", ()=>{
			this.deleteById();
		});
		$("#btn-update-mode").on("click", ()=>{
			//콜백 스택
			this.updateMode();
		});
		$("#btn-update").on("click", ()=>{
			//콜백 스택
			this.update();
		});
		$("#btn-update").hide()
	},
	
	updateMode : function(){
		$("#btn-update-mode").hide();
		$("#btn-update").show();
		
		
		$("#title").attr("readOnly", false);
		$("#content").attr("readOnly", false);
		
	}
	
	update : function(){
		
		let data = {
			id : $("#id").val(),
			title : $("#title").val(),
			content : $("#content").val(),
		};
		
		$.ajax({
			type : "PUT",
			url : "/post/"+data.id,
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			dataType : "json"
		}).done(function(resp){
			if(resp.statusCode == 1){
				console.log(resp);
				alert("수정 성공");
				location.href="/post/"+data.id;
			}
			console.log(resp);
		}).fail(function(error){
			alert("수정 실패");
			console.log(error);
		})
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

	deleteById : function(){
		let data = {
				id : ${"#id"}.val
		};
		
		$ajax({
			type : "DELET" 
			url :  "/post"
			dataType : "json"
		}).done(function(resp){
			consol.log(resp);
			alert("삭제성공");
			location.href="/";
		}).fail()
	}
	
	

index.init();