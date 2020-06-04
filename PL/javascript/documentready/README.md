# 처음 끝
```script
	$(document)
			.ready(
					function() {
						var formObj = $("form[name='readForm']");

						// 수정 
						$(".update_btn").on("click", function() {
							formObj.attr("action", "/board/updateView");
							formObj.attr("method", "get");
							formObj.submit();
						})

						// 삭제
						$(".delete_btn").on("click", function() {
							formObj.attr("action", "/board/delete");
							formObj.attr("method", "post");
							formObj.submit();
						})

						// 취소
						$(".list_btn").on("click", function() {

							location.href = "/board/list";
						})

						// 삭제
						$(".delete_btn").on("click", function() {

							var deleteYN = confirm("삭제하시겠습니가?");
							if (deleteYN == true) {

								formObj.attr("action", "/board/delete");
								formObj.attr("method", "post");
								formObj.submit();

							}
						})

						// 목록
						$(".list_btn")
								.on(
										"click",
										function() {

											location.href = "/board/list?page=${scri.page}"
													+ "&perPageNum=${scri.perPageNum}"
													+ "&searchType=${scri.searchType}&keyword=${scri.keyword}";
										})
						$(".replyWriteBtn").on("click", function() {
							alert('켜졌다');
							var formObj = $("form[name='replyForm']");
							formObj.attr("action", "/board/replyWrite");
							formObj.submit();
						})
						$(".replyWriteBtn").on("click", function() {
							alert('켜졌다');
							var formObj = $("form[name='replyForm']");
							formObj.attr("action", "/board/replyWrite");
							formObj.submit();
						});
					})
```
* 맨 끝 전 메소드에 ;
* 마지막 다큐먼트 닫는 })
