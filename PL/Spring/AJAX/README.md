# 아이디 중복
```java
function fn_idChk(){
			$.ajax({
				url : "/member/idChk",
				type : "post",
				dataType : "json",
				data : {"userId" : $("#userId").val()},
				success : function(data){
					if(data == 1){
						alert("중복된 아이디입니다.");
					}else if(data == 0){
						$("#idChk").attr("value", "Y");
						alert("사용가능한 아이디입니다.");
					}
				}
			})
		}
    
아이디중복체크 요청을 ajax로 만들었는데요. url에 요청하는 url을 설정해주고 data는 userId 이름으로 

id가 userId인 값을 가져오고 data : {}를 member/idChk로 보내주게 됩니다. 그리고나서 보낸것이 성공하면 

Controller에서 요청받은 url(/member/idChk)의 반환값(return)의 값을 function()에 넣어주게 됩니다.

data가 1이면 "중복된 아이디가 있습니다." 알러트를 띄우고, 없으면 "사용가능한 아이디입니다." 라는 알러트를 띄어줍니다.
```

# 비밀번호 중복
```java
회원탈퇴 버튼을 눌렀을때 ajax는 Controller에서 /member/passChk로 요청합니다.

요청을 하면서 $("#delForm").serializeArray()의 값들을 보내줍니다. (Form에 있는 데이터 userId, userPass, userName)

데이터가 보내지고 성공했으면 Controller에서 return한 값 즉 1이 반환이됩니다.

반환한 값은 fucntion의 파라미터 data로 들어가게되며 data가 0이면 패스워드가 틀리고 0이 아니면 회원탈퇴하시겠습니까? 
라는 알러트문이 뜨게 됩니다.

		$("#submit").on("click", function(){
				if($("#userPass").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#userPass").focus();
					return false;
				}
				$.ajax({
					url : "/member/passChk",
					type : "POST",
					dataType : "json",
					data : $("#delForm").serializeArray(),
					success: function(data){
						
						if(data==0){
							alert("패스워드가 틀렸습니다.");
							return;
						}else{
							if(confirm("회원탈퇴하시겠습니까?")){
								$("#delForm").submit();
							}
							
						}
					}
				})
				
			});
			
```
