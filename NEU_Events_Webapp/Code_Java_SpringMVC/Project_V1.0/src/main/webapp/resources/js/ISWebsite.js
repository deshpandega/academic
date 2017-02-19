function checkPasswords(){
	var password = document.getElementById('password').value;
	var confirmPassword = document.getElementById('confirmPassword').value;
	if(password != confirmPassword){
		document.getElementById('errorPassword').innerHTML = "Please enter matching passwords";
	}
	else{
		document.getElementById('errorPassword').innerHTML = "";
	}
}

function checkSignUpInput(){
	var firstName = document.getElementById('firstName').value;
	var lastName = document.getElementById('lastName').value;
	var neuID = document.getElementById('neuID').value;
	var phoneNumber = document.getElementById('phoneNumber').value;
	var username = document.getElementById('username').value;
	var password = document.getElementById('password').value;
	var husky = "@husky.neu.edu";
	
	if(firstName==""||firstName==undefined){
		document.getElementById('firstNameErrorField').innerHTML = "Please enter first name";
	}
	else{
		document.getElementById('firstNameErrorField').innerHTML = "";
	}
	
	if(lastName==""||lastName==undefined){
		document.getElementById('lastNameErrorField').innerHTML = "Please enter last name";
	}
	else{
		document.getElementById('lastNameErrorField').innerHTML = "";
	}
	
	if(neuID==""||neuID==undefined){
		document.getElementById('nuIDErrorField').innerHTML = "Please enter your NEU id";
	}
	else{
		document.getElementById('nuIDErrorField').innerHTML = "";
	}
	
	if(phoneNumber==""||phoneNumber==undefined){
		document.getElementById('phoneErrorField').innerHTML = "Please enter your mobile number";
	}
	else{
		document.getElementById('phoneErrorField').innerHTML = "";
	}
	
	if(username==""||username==undefined){
		document.getElementById('emailErrorField').innerHTML = "Please enter your husky email id";
	}
	else if(username.indexOf(husky) <= -1){
		document.getElementById('emailErrorField').innerHTML = "Please enter 'husky' email id in proper format";
	}
	else{
		document.getElementById('emailErrorField').innerHTML = "";
	}
	
	if(password==""||password==undefined){
		document.getElementById('passwordErrorField').innerHTML = "Please enter password";
	}
	else{
		document.getElementById('passwordErrorField').innerHTML = "";
	}
}

function getPasswordString(){
	alert("Here!");
	var url = window.location.href;
	document.getElementById('passwordLink').value=url;
	document.getElementById('retrivePassword').submit();
}

function sanitize() {
    var input = document.getElementById('fileName');
    var validation = 0;
    if (input.value != '') {
        var inputText = removeTags(input.value);
        input.value = inputText;
    }

    if (input.value == '') {
        alert("Please Enter File Name");
    } 
    else{
        document.getElementById('getFileName').submit();
    }
}



function readyFunction(result) {
    if (result==true){
        document.getElementById('page1').style.display='block';
        document.getElementById('page2').style.display='none';
    }
    else{
        document.getElementById('page1').style.display='none';
        document.getElementById('page2').style.display='block';
        document.getElementById('hideThis').style.display='none';
    }
}

if(document.getElementById("neuID")!=undefined){
	if(document.getElementById("neuID").value == 0){
		document.getElementById("neuID").value = '' ;
	}
}


function checkNUIDValue(){
	if(document.getElementById("neuID").value == '' || document.getElementById("neuID").value == undefined){
		document.getElementById("nuIDErrorField").innerHTML = "";
	}
	else{	
		checkNUID();
	}
}

function checkEmailValue(){
	if(document.getElementById("username").value == '' || document.getElementById("username").value == undefined){
		document.getElementById("emailErrorField").innerHTML = "";
	}
	else{	
		checkEmail();
	}
}

function modifyButtonText(){
	if(document.getElementById("buttonText").value == "Unsubscribe"){
		document.getElementById("subscribeButton").disabled =true;
	}
}

function subscribe(){
	if (xmlHttp == null)
    {
        alert("Your browser does not support AJAX!");
        return;
    }
	var eventId=document.getElementById("eventNumber").value;
	var subscribe = document.getElementById("subscribeButton").value;
	var url = "eventNumber=" + eventId.trim() + "subscribe="+subscribe;
	xmlHttp.onreadystatechange = function stateChanged(){
		if (xmlHttp.readyState == 4){
			var json = JSON.parse(xmlHttp.responseText);
			if (json.searchResult.length > 0) {
				 alert("Subscription Successful");
			}
			else{
				
			}
		}
	};
	xmlHttp.open("POST", "eventSubscribe.vm", true);
    xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlHttp.send(url);
    return false;
}

function checkEmail() {
	if (xmlHttp == null)
    {
        alert("Your browser does not support AJAX!");
        return;
    }
	var email=document.getElementById("username").value;
	var url = "username=" + email.trim();
	xmlHttp.onreadystatechange = function stateChanged(){
		if (xmlHttp.readyState == 4){
			var json = JSON.parse(xmlHttp.responseText);
			if (json.emailSearchResult.length > 0) {
				 document.getElementById("emailErrorField").innerHTML = json.emailSearchResult;
			}
			else{
				document.getElementById("emailErrorField").innerHTML = "";
			}
		}
	};
	xmlHttp.open("POST", "loginCheckEmail.vm", true);
    xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlHttp.send(url);
    return false;
}

var xmlHttp;
xmlHttp = GetXmlHttpObject();

function checkNUID(){
	if (xmlHttp == null)
    {
        alert("Your browser does not support AJAX!");
        return;
    }
	var nuid=document.getElementById("neuID").value;
	var url = "neuID=" + nuid.trim();
	xmlHttp.onreadystatechange = function stateChanged(){
		if (xmlHttp.readyState == 4){
			var json = JSON.parse(xmlHttp.responseText);
			if (json.searchResult.length > 0) {
				 document.getElementById("nuIDErrorField").innerHTML = json.searchResult;
			}
			else{
				document.getElementById("nuIDErrorField").innerHTML = "";
			}
		}
	};
	xmlHttp.open("POST", "loginCheckNUID.vm", true);
    xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlHttp.send(url);
    return false;
}



function GetXmlHttpObject(){
    var xmlHttp = null;
    try{
        // Firefox, Opera 8.0+, Safari, Chrome
        xmlHttp = new XMLHttpRequest();
    } catch (e){
        // Internet Explorer
        try{
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e){
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    return xmlHttp;
}

function loadData(){
    
    if(document.getElementById('dataTable').tBodies[0].innerHTML.includes("File does not exist")==true){
        alert("No rows available for additin");
    }
    else{
        document.getElementById('saveTableData').submit();
    }
}

var tagBody = '(?:[^"\'>]|"[^"]*"|\'[^\']*\')*';

var tagOrComment = new RegExp(
        '<(?:'
        + '!--(?:(?:-*[^->])*--+|-?)'
        + '|script\\b' + tagBody + '>[\\s\\S]*?</script\\s*'
        + '|style\\b' + tagBody + '>[\\s\\S]*?</style\\s*'
        + '|/?[a-z]'
        + tagBody
        + ')>',
        'gi');

var regexmpl = new RegExp('[^\\dA-Za-z ]');
function removeTags(html) {
    var oldHtml;
    do {
        oldHtml = html;
        html = html.replace(tagOrComment, '');
    } while (html !== oldHtml);
    return html.replace(/</g, '&lt;');
}