<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" >
    function checkSname(){
    	var sname=$("[name='sname']").val();//拿到用户输入的姓名
    	if(sname==""||sname.length==0){
    		alert("姓名必填");
    		$("[name='sname']").focus();
    		return false;
    	}else{
    		return true;
    	}	
    }
    function checkSpass(){
    	var spass=$("[name='spass']").val();//拿到用户输入的姓名
    	if(spass==""||spass.length==0){
    		alert("密码必填");
    		$("[name='spass']").focus();
    		return false;
    	}else{
    		return true;
    	}	
    }
	function checkBirthdate(){
			var time=$("[name='birthdate']").val();
			if(time==""||time.length==0){
				alert("出生日期不能为空!");
				$("[name='birthdate']").focus();
				return false;
			}else{
				//var reg=/^\d{4}-\d{2}-\d{2}$/;
				var reg=/^\d{4}-(0?[1-9]|1[0-2])-(0?[1-9]|[1-2]\d|3[0-1])$/;
				if(!reg.test(time)){//不符合yyyy-MM-dd
  				alert("出生日期格式不正确!");
  				$("[name='birthdate']").focus();
  				return false;
				}
			
			}	
			return true;
		}


    //工厂函数
	$(
		function(){
			$("#stuForm").submit(function(){
				
				    if(!checkSname()) return false;
				    if(!checkSpass()) return false;
				    if(!checkBirthdate()) return false;    
				    return true;//让表单提交
			  }
			);
		}	
	
	);

</script>
</head>
<body>
		<center>
		<form id="stuForm" name="addForm" action="doAdd.do" method="post">
			<table border="1" align="center" width="80%">
				<tr>
					<td>学号</td>
					<td>自动生成</td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" value="" name="sname"/></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password" value="" name="spass"/></td>
				</tr>
				<tr>
					<td>出生日期</td>
					<td><input type="text" value="" name="birthdate"/></td>
				</tr>
				<tr>
					<td>年级</td>
					<td>
						<select name="grade.gid">
							<c:forEach items="${gradeList }" var="g">
								<option value="${g.gid}">${g.gname }</option>
							</c:forEach>
							<!-- <option value="1">S1</option>
							<option value="2">S2</option>
							<option value="3">Y2</option> -->
						</select>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
					<input type="submit" value="提交"/>
					<input type="reset" value="重置" />
					</td>
				</tr>
			</table>
		</form>
		
		</center>
</body>
</html>