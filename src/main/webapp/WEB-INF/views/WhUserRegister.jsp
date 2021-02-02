<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>WhUser Register</title>
<style type="text/css">
	.btn-lg{
		margin-left: 200px;
	}
	.card-body{
		background-color:#adb9cc;
	}
	#head,h3{
		background-color: #a70907;
	}
	.form-control{
		margin-top:20px;
  		border: 5px;
  		border-radius: 10px;
  		border-bottom: 2px solid gray;
  		font-size: 15px;
  		color: green;
	}
	.control-label{
		font-size: 15px;
  		margin-top: 20px;
  		font-weight: bold;
	}
	span{
		margin-top: 40px;
  		font-weight: bold;
	}
</style>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card-header" id="head">
			<H3 class="text-center text-white text-uppercase">WAREHOUSE
			USER REGISTER</H3>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-8">
					<form:form action="save" method="post" class="from-group"
				modelAttribute="whUserType">
				<div class="row">
					<div class="col-3">
						<label class="control-label"> USER TYPE</label>
					</div>
					<div class="col-6">
						<form:radiobutton path="whUserType" value="Vendor" />
						<label class="control-label">Vendor</label>
						<form:radiobutton path="whUserType" value="Customer" />
						<label class="control-label">Customer</label>
						<br><span id="userTypeError"></span>
					</div>
					<div class="col-3"></div>
				</div>
				<div class="row">
					<div class="col-3">
						<label class="control-label">USER CODE:</label>
					</div>
					<div class="col-6">
						<form:input path="whUserCode" class="form-control" />
						<span id="userCodeError"></span>
					</div>
					<div class="col-3" ></div>
				</div>

				<div class="row">
					<div class="col-3">
						<label class="control-label">USER FOR</label>
					</div>
					<div class="col-6">
						<form:input path="whUserFor" class="form-control" readonly="true"/>
					</div>
					<div class="col-3"></div>
				</div>
				<div class="row">
					<div class="col-3">
						<label class="control-label">USER EMAIL</label>
					</div>
					<div class="col-6">
						<form:input path="whUserEmail" class="form-control" />
						<span id="userEmailError"></span>
					</div>
					<div class="col-3"></div>
				</div>
				<div class="row">
					<div class="col-3">
						<label class="control-label">USER CONTACT</label>
					</div>
					<div class="col-6">
						<form:input path="whUserCont" class="form-control" />
						<span id="userContactError"></span>
					</div>
					<div class="col-3"></div>
				</div>
				<div class="row">
					<div class="col-3">
						<label class="control-label"> USER ID TYPE</label>
					</div>
					<div class="col-6">
						<form:select path="whUserIdType" class="form-control">
							<form:option value="">--choose--</form:option>
							<form:option value="PANCARD">PANCARD</form:option>
							<form:option value="AADHAR CARD">AADHAR CARD</form:option>
							<form:option value="VOTER ID">VOTER ID</form:option>
							<form:option value="Other">Other</form:option>
						</form:select>
						<span id="userIdTypeError"></span>
					</div>
					<div class="col-3"></div>
				</div>
				<div class="row">
					<div class="col-3">
						<label class="control-label">IF OTHER TYPE</label>
					</div>
					<div class="col-6">
						<form:input path="whUserIdOther" class="form-control" />
					</div>
					<div class="col-3"><span id="otherTypeError"></span></div>
				</div>
				<div class="row">
					<div class="col-3">
						<label class="control-label">ID NUMBER</label>
					</div>
					<div class="col-6">
						<form:input path="whUserIdNum" class="form-control" />
						<span id="idNumError"></span>
					</div>
					<div class="col-3"></div>
				</div>
				<br>
				<input type="submit" id="submitt" value="CREATE USER"
					class="btn btn-primary btn-lg">
			</form:form>
				</div>
				<div class="col-2"></div>
			</div>
		</div>
		<c:if test="${!empty msg }">
			<div class="card-footer bg-info text-white text-center">
				<b>${msg}</b>
			</div>
		</c:if>
	</div>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#userTypeError").hide();
		$("#userCodeError").hide();
		$("#userEmailError").hide();
		$("#userContactError").hide();
		$("#userIdTypeError").hide();
		$("#idNumError").hide();
		$("#otherTypeError").hide();
		
		var userTypeError=false;
		var userCodeError=false;
		var userEmailError=false;
		var userContactError=false;
		var userIdTypeError=false;
		var idNumError=false;
		var otherTypeError=false;
		
		$('input[type="radio"][name="whUserType"]').change(function(){
			userForAutoFill();
			validateUserType();
			});
		$('#whUserCode').keyup(function(){
			validateUserCode();
		});
		$('#whUserEmail').keyup(function(){
			validateUserEmail();
		});
		$('#whUserCont').keyup(function(){
			validateUserCont();
		});
		$('#whUserIdType').change(function(){
			validateUserIdType();
		});
		$('#whUserIdOther').keyup(function(){
			validateOtherIdType();
		});
		$('#whUserIdNum').keyup(function(){
			validateIdNum();
		});
		
		function userForAutoFill(){
			var val=$('input[type="radio"][name="whUserType"]:checked').val();
			if(val=='Vendor'){
				$("#whUserFor").val("Purchase");
				$("#wgUserFor").css("font-family","bold")
			}else if(val=='Customer'){
				$("#whUserFor").val("Sale");			    	
				$("#wgUserFor").css("font-family","bold")
			}
		}
		function validateUserType(){
			var val=$('input[type="radio"][name="whUserType"]:checked').length;
			if(val==0){
				$("#userTypeError").show();
				$("#userTypeError").html("Choose one");
				$("#userTypeError").css("color","red");
				userTypeError=false;
			}else{
				$("#userTypeError").hide();
				userTypeError=true;
			}
			return userTypeError;
		}
		function validateUserCode(){
			var val=$('#whUserCode').val();
			var exp=/^[A-Za-z]{2,10}$/;
			if(val==''){
				$("#userCodeError").show();
				$("#userCodeError").html("empty");
				$("#userCodeError").css("color","red");
				$('#whUserCode').css("border-color","red");
				userCodeError=false;
			}else if(!exp.test(val)){
				$("#userCodeError").show();
				$("#userCodeError").html("Contains 2-10 chars only");
				$("#userCodeError").css("color","red");
				$('#whUserCode').css("border-color","red");
				userCodeError=false;
			}else{
				$("#userCodeError").hide();
				$('#whUserCode').css("border-color","green");
				userCodeError=true;
			}
			return userCodeError;
		}
		function validateUserEmail(){
			var val=$('#whUserEmail').val();
			var exp=/^[a-zA-Z0-9-_.]+\@[a-zA-Z]{2,10}\.[a-zA-Z]{2,6}$/;
			if(val==''){
				$("#userEmailError").show();
				$("#userEmailError").html("empty");
				$("#userEmailError").css("color","red");
				$('#whUserEmail').css("border-color","red");
				userEmailError=false;
			}else if(!exp.test(val)){
				$("#userEmailError").show();
				$("#userEmailError").html("Enter a valid Email");
				$("#userEmailError").css("color","red");
				$('#whUserEmail').css("border-color","red");
				userEmailError=false;
			}else{
				$("#userEmailError").hide();
				$('#whUserEmail').css("border-color","green");
				userEmailError=true;
			}
			return userEmailError;
		}
		function validateUserCont(){
			var val=$('#whUserCont').val();
			var exp=/^(\+91)?[6-9][0-9]{9}$/;
			if(val==''){
				$("#userContactError").show();
				$("#userContactError").html("empty");
				$("#userContactError").css("color","red");
				$('#whUserCont').css("border-color","red");
				userContactError=false;
			}else if(!exp.test(val)){
				$("#userContactError").show();
				$("#userContactError").html("Enter a valid contact no");
				$("#userContactError").css("color","red");
				$('#whUserCont').css("border-color","red");
				userContactError=false;
			}else{
				$("#userContactError").hide();
				$('#whUserCont').css("border-color","green");
				userContactError=true;
			}
			return userContactError;
		}
		function validateUserIdType(){
			var val=$("#whUserIdType").val();
			if(val==""){
				$("#userIdTypeError").show();
				$("#userIdTypeError").html("Choose one");
				$("#userIdTypeError").css("color","red");
				$('#whUserIdType').css("border-color","red");
				userIdTypeError=false;
			}else{
				$("#userIdTypeError").hide();
				$('#whUserIdType').css("border-color","green");
				userIdTypeError=true;

				if(val=='Other'){
					$('#whUserIdOther').attr("readonly",false);
				}else{
					$('#whUserIdOther').val('');
					$('#whUserIdOther').attr("readonly",true);
					
				}
			}
			return userIdTypeError;	
		}
		
		function validateOtherIdType(){
			var val=$('#whUserIdOther').val();
			var exp=/^[A-Za-z]{3,16}$/;
			
			if($('#whUserIdOther').attr('readonly')){
				$('#otherTypeError').hide();
				otherTypeError=true;
			}else{
				if(val==''){
					$("#otherTypeError").show();
					$("#otherTypeError").html("empty");
					$("#otherTypeError").css("color","red");
					$('#whUserIdOther').css("border-color","red");
					otherTypeError=false;
				}else if(!exp.test(val)){
					$("#otherTypeError").show();
					$("#otherTypeError").html("Id type must between 3-16 char");
					$("#otherTypeError").css("color","red");
					$('#whUserIdOther').css("border-color","red");
					otherTypeError=false;
				}else{
					$('#otherTypeError').hide();
					$('#whUserIdOther').css("border-color","green");
					otherTypeError=true;
				}
			}
			return otherTypeError;
		}
		
		function validateIdNum(){
			var val=$('#whUserIdNum').val();
			var exp=/^$/;
			if($('#whUserIdType').val()=='PANCARD'){
				exp=/^[A-Z]{5}[0-9]{4}[A-Z]$/;
			}else if($('#whUserIdType').val()=='VOTER ID'){
				exp=/^[A-Za-z]{3}[0-9]{7}$/;
			}else if($('#whUserIdType').val()=='AADHAR CARD'){
				exp=/^[0-9]{12}$/;
			}else{
				exp=/^[A-Za-z0-9-._]{4,20}$/;
			}
		
			if(val==''){
				$("#idNumError").show();
				$("#idNumError").html("empty");
				$("#idNumError").css("color","red");
				$('#whUserIdNum').css("border-color","red");
				idNumError=false;
			}else if(!exp.test(val)){
				$("#idNumError").show();
				$("#idNumError").html("Enter a valid Id no");
				$("#idNumError").css("color","red");
				$('#whUserIdNum').css("border-color","red");
				idNumError=false;
			}else{
				$("#idNumError").hide();
				$('#whUserIdNum').css("border-color","green");
				idNumError=true;
			}
			return idNumError;
		}
		/*On Cliick Submit Button*/
		$('#submitt').click(function(){
			userTypeError=false;
			userTypeError=false;
			userEmailError=false;
			userContactError=false;
			userIdTypeError=false;
			otherTypeError=false;
			idNumError=false;
			
			
			
			validateUserType();
			validateUserCode();
			validateUserEmail();
			validateUserCont();
			validateUserIdType();
			validateIdNum();
			validateOtherIdType();

			if(userTypeError && userTypeError && userEmailError 
					&& userContactError && userIdTypeError && idNumError &&
					otherTypeError)
				return true;
			else
				return false;
			});
		});
		
	</script>
</body>
</html>