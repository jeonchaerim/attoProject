<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>get</title>

    <style>
        * {
            margin: 0 auto;
            padding: 0;
        }
        #wrapper {
            width: 1024px;
            margin-top: 30px;

            font-family: 'D2Coding';
            font-size: 14px;
        }
        #answerBtn{
            width: 80px;
            height: 40px;

            border: 0;

            font-size: 16px;
            font-weight: bold;

            box-shadow: 3px 3px 10px darkgrey;
        }
        #answerBtn {
            color: white;
            background-color: green;
        }
        #listBtn {
            color: white;
            background-color: blue;
        }
        button:hover {
            cursor: pointer;
        }
    </style>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.0/jquery-migrate.min.js" integrity="sha512-QDsjSX1mStBIAnNXx31dyvw4wVdHjonOwrkaIhpiIlzqGUCdsI62MwQtHpJF+Npy2SmSlGSROoNWQCOFpqbsOg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

    <script>

        $(function () {
            $('#answerBtn').on('click', () => {
                self.location = "/board/modify?bno=${_BOARD_.bno}";

            }); // .onclick

        }); //.jq
      
    </script>
</head>
<body>
    <h1>002-01관리자</h1>
    <hr>


	<div id="wrapper">
        <form action="/board/modify" method="post">
            <table>
                <tbody>
    
                    <tr><!-- bno -->
                        <td><label for="bno">글번호</label></td>
                        <td><input type="text" name="bno" id="bno" size="10" value="${_BOARD_.bno}" readonly></td>
                    </tr>
                    <tr><!-- title -->
                        <td><label for="title">제목</label></td>
                        <td><input type="text" name="title" id="title" size="50" value="${_BOARD_.title}" readonly></td>
                    </tr>
                    <tr><!-- content -->
                        <td><label for="content">내용</label></td>
                        <td><textarea name="content" id="content" cols="52" rows="10" readonly>${_BOARD_.content}</textarea></td>
                    </tr>
                    <tr><!-- writer -->
                        <td><label for="writer">작성자</label></td>
                        <td><input type="text" name="writer" id="writer" size="15" value="${_BOARD_.writer}" readonly></td>
                    </tr>
                    <tr>
                        <td colspan="2">&nbsp;</td>
                    </tr>

                    <tr><!-- answer -->
                        <td><label for="answer">답변</label></td>
                        <td><textarea name="answer" id="answer" cols="52" rows="10"></textarea></td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <button type="submit" id="answerBtn">ANSWER</button>
                            <!-- <button type="button" id="listBtn">LIST</button> -->
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </div>

</body>
</html>