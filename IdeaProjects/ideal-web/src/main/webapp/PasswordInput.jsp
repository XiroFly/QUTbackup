<%@ page contentType="text/html;charset=utf-8"%>
<script type="text/javascript">
    function isValidate(form)
    {

        pwhead = form.pwhead.value;
        pwtail = form.pwtail.value;


        if(pwhead.length<3)
        {
            alert("密码头部长度小于3位！");
            form.pwhead.focus();
            return false;
        }
        if(pwhead.length>5)
        {
            alert("密码头部长度大于5位！");
            form.pwhead.focus();
            return false;
        }


        if(pwtail.length<3)
        {
            alert("尾部长度小于3位！");
            form.pwtail.focus();
            return false;
        }
        if(pwtail.length>5)
        {
            alert("尾部长度大于5位！");
            form.pwtail.focus();
            return false;
        }
        return true;
    }
</script>


<html>
<head>
    <title>密码练习</title>
</head>
<body>
<h2>请输入要联系密码的头部和尾部：</h2>
<form name="form1" action="fly" method="get"
      onsubmit="javascript:return isValidate(form1)">
    密码头部：<input type="password" name="pwhead"> <br>
    密码尾部：<input type="password" name="pwtail"><br>
    练习输入密码：<input type="password" name="pw">
    <input type="reset" value="重置">
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
