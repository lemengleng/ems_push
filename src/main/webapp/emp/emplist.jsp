<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%request.setAttribute("path", request.getContextPath());%>
<html>
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/style.css"/>
    <link href="${path}/css/common.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript">
        function fun() {
            var i = window.confirm('确认删除吗?');
            if (i) {
                return true;
            } else {
                return false;
            }
        }
    </script>
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2009/11/20
                    <br/>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                Welcome (${user.name})!
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        Salary
                    </td>
                    <td>
                        Age
                    </td>
                    <td>
                        Bir
                    </td>
                    <td>
                        Dept
                    </td>
                    <td>
                        Operation(处理删除的友情提醒)
                    </td>
                </tr>
                <c:forEach items="${list}" var="emp">
                    <tr class="row1">
                        <td>
                                ${emp.id}
                        </td>
                        <td>
                                ${emp.name}
                        </td>
                        <td>
                                ${emp.salary}
                        </td>
                        <td>
                                ${emp.age}
                        </td>
                        <td>
                            <fmt:formatDate value="${emp.bir}"/>
                        </td>
                        <td>
                                ${sessionScope.dept.name}
                        </td>
                        <td>
                            <a href="${path}/emp/delete?id=${emp.id}" onclick="fun()">delete emp</a>&nbsp;<a
                                href="${path}/emp/updatebefore?id=${emp.id}">update emp</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
            <div class="pagination" align="center">
                <c:if test="${nowPage!=1 && endPage!=0}">
                    <a href="${path}/emp/queryByPage?nowPage=1"><span class="firstPage"></span></a>
                    <a href="${path}/emp/queryByPage?nowPage=${nowPage-1}"><span class="previousPage">&nbsp;</span></a>
                </c:if>
                <c:forEach begin="1" end="${endPage}" var="i">
                    <a href="${path}/emp/queryByPage?nowPage=${i}"><span class="currentPage">${i}</span></a>
                </c:forEach>
                <c:if test="${nowPage!=endPage && endPage!=0}">
                    <a class="nextPage" href="${path}/emp/queryByPage?nowPage=${nowPage+1}">&nbsp;</a>
                    <a class="lastPage" href="${path}/emp/queryByPage?nowPage=${endPage}">&nbsp;</a>
                </c:if>
                <form action="${path}/emp/queryByPage" method="post">
							<span class="pageSkip"> 共${endPage}页 到第<input id="pageNumber"
                                                                          name="nowPage" value="1"
                                                                          maxlength="${endPage}"
                                                                          onpaste="return false;">页
									<button type="submit">&nbsp;</button>
							</span>
                </form>
            </div>
            <p>
                <input type="button" class="button" value="Add Employee" onclick="location='${path}/emp/addEmp.jsp'"/>
            </p>
        </div>
    </div>

    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
