# Main.php
```php
<?php
session_start();
if(!isset($_SESSION['userid'])) //세션이 존재하지 않을 때
{
    header ('Location: ./login.html');
}
 
echo "홈(로그인 성공)";
 
echo "<a href=logout.php>로그아웃</a>";
 
?>

```

# Login.html
```html
<html>
<head>
    <title>login page</title>
    <meta charset="utf-8">
</head>
<body>
    <form method="post" action="/login_check.php">
        <div>
            <label for="id">ID </label>
            <input type="text" name="id"/>
        </div>
        <div>
            <label for="pw">PW </label>
            <input type="text" name="pw"/>
        </div>
        
        <div class="button">
            <button type="submit"> login </button>
        </div>
    </form>
    <button onclick="location.href='signUp.html'"> sign up </button>
</body>
</html>

```

# signup.html
```html
<html>
<head>
    <title> Sign Up </title>
    <meta charset="utf-8">
</head>
<body>
    <form action = "./signUp.php" method="post">
        <div>
            <label for="id"> ID </label>
            <input type="text" name="id"/>
        </div>
        <div>
            <label for="pw"> PW </label>
            <input type="text" name="pw"/>
        </div>
        <div>
            <label for="pwc"> pwc </label>
            <input type="text" name="pwc"/>
        </div>
        
        <div>
            <label for="name"> Name </label>
            <input type="text" name="name"/>
        </div>
        <div>
            <label for="email"> E-mail </label>
            <input type="text" name="email"/>
        </div>
        <div class="button">
            <input type="submit" value="submit">
        </div>
    </form>
</body>
</html> 

```

# signUp.php
```php
<?php
$id=$_POST['id'];
$pw=$_POST['pw'];
$pwc=$_POST['pwc'];
$name=$_POST['name'];
$email=$_POST['email'];
 
if($pw!=$pwc) //비밀번호와 비밀번호 확인 문자열이 맞지 않을 경우
{
    echo "비밀번호와 비밀번호 확인이 서로 다릅니다.";
    echo "<a href=signUp.html>back page</a>";
    exit();
}
if($id==NULL || $pw==NULL || $name==NULL || $email==NULL) //
{
    echo "빈 칸을 모두 채워주세요";
    echo "<a href=signUp.html>back page</a>";
    exit();
}
 
$mysqli=mysqli_connect("localhost","root","123456789","test2");
 
$check="SELECT *from user_info WHERE userid='$id'";
$result=$mysqli->query($check);
if($result->num_rows==1)
{
    echo "중복된 id입니다.";
    echo "<a href=signUp.html>back page</a>";
    exit();
}
 
$signup=mysqli_query($mysqli,"INSERT INTO user_info (userid,userpw,name,email) 
VALUES ('$id','$pw','$name','$email')");
if($signup){
    echo "sign up success";
}
 
?>

```


# loginCheck.php
```php
<?php
session_start();
$id=$_POST['id'];
$pw=$_POST['pw'];
$mysqli=mysqli_connect("localhost","root","비밀번호","test2");
 
$check="SELECT * FROM user_info WHERE userid='$id'";
$result=$mysqli->query($check); 
if($result->num_rows==1){
    $row=$result->fetch_array(MYSQLI_ASSOC); //하나의 열을 배열로 가져오기
    if($row['userpw']==$pw){  //MYSQLI_ASSOC 필드명으로 첨자 가능
        $_SESSION['userid']=$id;           //로그인 성공 시 세션 변수 만들기
        if(isset($_SESSION['userid']))    //세션 변수가 참일 때
        {
            header('Location: ./main.php');   //로그인 성공 시 페이지 이동
        }
        else{
            echo "세션 저장 실패";
        }            
    }
    else{
        echo "wrong id or pw";
    }
}
else{
    echo "wrong id or pw";
}
?>

```

# logout.php
```php
<?php
session_start();
$res=session_destroy(); //모든 세션 변수 지우기
if($res){
    header('Location: ./main.php'); // 로그아웃 성공 시 로그인 페이지로 이동
}
?>

```
