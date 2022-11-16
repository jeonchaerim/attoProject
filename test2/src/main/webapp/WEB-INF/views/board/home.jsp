<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>home</title>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.0/jquery-migrate.min.js" integrity="sha512-QDsjSX1mStBIAnNXx31dyvw4wVdHjonOwrkaIhpiIlzqGUCdsI62MwQtHpJF+Npy2SmSlGSROoNWQCOFpqbsOg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    </head>

    <script>
        // $(function () {

        //     let prevStepResult = "${_RESULT_}";
            
        //     if(prevStepResult != null && prevStepResult.length > 0) {
        //         alert(prevStepResult);
        //     } // if
            
        // }); // .jq
    </script>

    <body>
        <h1>001-01사용자 로그인, 002-01관리자 로그인</h1>
        <hr>

        <h3>사용자 로그인</h3>
        <form action="/board/userLogin" method="post">
            ID : <input type="text" name="userid"><br>
            PASSWORD : <input type="text" name="userpw" min="1" max="4"><br>
            <input type="submit" value="Login">

        </form>

        <h3>관리자 로그인</h3>
        <form action="/board/adminLogin" method="post">
            ID : <input type="text" name="adminid"><br>
            PASSWORD : <input type="text" name="adminpw" min="1" max="4"><br>
            <input type="submit" value="Login">
        </form>
       
    </body>
</html>