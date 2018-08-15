<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登陆</title>
    <style type="text/css">
        .x-form-item-input {
            width: 180px;
        }

        body {
            height: 90%;
            width: 90%;
            overflow: hidden;
            border: none;
        }

        #btn_login{
            margin-top: 2px;
            text-align: center;
            height: 30px;
            line-height: 30px;
        }
        .errInfo{
            text-align: center;
            color: red;
        }
    </style>
    <!--js中存放当前页面的root路径方便调用-->
    <% String root = request.getContextPath(); %>
    <script type="text/javascript">
        var root = "<%=root%>";
    </script>
</head>
<body>
<div>
    <form id="login" name="login" action="<%=root%>/login_1.do" method="post" autocomplete="on">
        <table align="center">
            <tr align="center">
                <td>用&nbsp;户&nbsp;名：</td>
                <td>
                    <input class="required x-form-item-input"
                           type="text"  name="name" />
                </td>
            </tr>
            <tr align="center">
                <td>密&nbsp;&nbsp;码：</td>
                <td>
                    <input class="required x-form-item-input"
                           type="password"  name="pwd" />
                </td>
            </tr>
        </table>
        <div align="center" border="false" >
            <input id="btn_login" type="submit" value="登录">
        </div>
    </form>
    <form id="login_2" name="login" action="<%=root%>/login_2.do" method="post" autocomplete="on">
        <table align="center">
            <tr align="center">
                <td>用&nbsp;户&nbsp;名：</td>
                <td>
                    <input class="required x-form-item-input"
                           type="text"  name="name_2" />
                </td>
            </tr>
            <tr align="center">
                <td>密&nbsp;&nbsp;码：</td>
                <td>
                    <input class="required x-form-item-input"
                           type="password"  name="pwd_2" />
                </td>
            </tr>
        </table>
        <div align="center" border="false" >
            <input id="btn_login_2" type="submit" value="登录_2">
        </div>
        <div class="errInfo">
            ${errInfo}
        </div>
    </form>
</div>
</body>
</html>
