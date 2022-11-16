<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>listPerPage</title>

    <style>
        * {
            margin: 0 auto;
            padding: 0;
        }
        #wrapper {
            width: 1024px;

            font-family: 'D2Coding';
            font-size: 14px;
        }
        table {
            width: 100%;

            border: 1px ridge green;
            border-collapse: collapse;

            text-align: center;
        }
        th {
            padding: 10px;

            color: white;
            background-color: purple;

            font-size: 16px;
        }
        caption {
            font-size: 20px;
            font-weight: bold;

            padding-bottom: 5px;
        }
        tr:hover {
            background-color: aquamarine;
        }
        td:nth-child(2) {
            text-align: left;
            padding-left: 10px;

            width: 40%;
        }
        #regBtn {
            width: 150px;
            height: 40px;

            border: 0;
            font-size: 17px;
            font-weight: bold;

            color: white;
            background-color: red;
            cursor: pointer;

            float: right;
        }
        #regBtn::after {
            content: '';
            display: block;
            clear: both;
        }
        a, a:link, a:visited {
            text-decoration: none;
            color: black;

            cursor: pointer;
        }

    </style>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.0/jquery-migrate.min.js" integrity="sha512-QDsjSX1mStBIAnNXx31dyvw4wVdHjonOwrkaIhpiIlzqGUCdsI62MwQtHpJF+Npy2SmSlGSROoNWQCOFpqbsOg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script>
        $(function () {


            $('#regBtn').on('click', () => {
                self.location = "/board/register";
            }); // .onclick
            
        }); // .jq
    </script>
</head>
<body>
    <h1>001-02게시판 목록</h1>
    <hr>

    <p>&nbsp;</p>

    <div id="wrapper">

        <button type="button" id="regBtn">REGISTER</button>

        <table border="1">
            <thead>
                <tr>
                    <th>글번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성시간</th>
                    <th>수정시간</th>
                    <th>답변상태</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="board" items="${__LIST_PER_PAGE__}">
                    <tr>
                        <td>${board.bno}</td>
                        <td><a href="/board/getAdmin?bno=${board.bno}">${board.title}</a></td>
                        <td>${board.writer}</td>
                        <td><fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${board.insertTs}" /></td>
                        <td><fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${board.updateTs}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


        <nav aria-label="Page navigation example">
            <ul class="pagination">
              <li class="page-item"><a class="page-link" href="#">Previous</a></li>
              <li class="page-item"><a class="page-link" href="/board/listPerPage?currPage=1">1</a></li>
              <li class="page-item"><a class="page-link" href="/board/listPerPage?currPage=2">2</a></li>
              <li class="page-item"><a class="page-link" href="/board/listPerPage?currPage=3">3</a></li>
              <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
          </nav>
        

    </div>
</body>
</html>