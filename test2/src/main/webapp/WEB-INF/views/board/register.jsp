<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>register</title>

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
        #submitBtn, #listBtn {
            width: 80px;
            height: 40px;

            border: 0;

            font-size: 16px;
            font-weight: bold;

            box-shadow: 3px 3px 10px darkgrey;
        }
        #submitBtn {
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

            $('#listBtn').on('click', () => {
                self.location = "/board/listPerPage";
            }); // .onclick
            
        }); // .jq
    </script>
</head>
<body>
    <h1>001-06게시판 내용확인</h1>
    <hr>

	<div id="wrapper">

        <form action="/board/register" method="post">

            <table>
                <tbody>
					
                    <tr><!-- title -->
                        <td><label for="title">제목</label></td>
                        <td><input type="text" name="title" id="title" size="50"></td>
                    </tr>
                    <tr><!-- content -->
                        <td><label for="content">내용</label></td>
                        <td><textarea name="content" id="content" cols="52" rows="10"></textarea></td>
                    </tr>
                    <tr><!-- writer -->
                        <td><label for="writer">작성자</label></td>
                        <td><input type="text" name="writer" id="writer" size="15" value="${_USER_.userid}" readonly/></td>
                    </tr>
                    <tr>
                        <td colspan="2">&nbsp;</td>
                    </tr>
                    <tr><!-- 이동버튼 2개: 리스트 or 수정화면 -->
                        <td colspan="2">
                            <button type="submit" id="submitBtn">SUBMIT</button>
                            <button type="button" id="listBtn">LIST</button>
                        </td>
                    </tr>

                </tbody>
            </table>

        </form>

    </div>

</body>
</html>