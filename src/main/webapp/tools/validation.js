var FILL_THIS = "<div class='paper'>This field must be filled</div>";
var LOGIN_VALUE = "<div class='paper'>Please, enter a valid username</div>";
var CONCIDENCED_FIELDS = "<div class='paper'>Fields must be different</div>";

function validate() {
    clear();
    var allright = true;
	//var x = document.forms["myForm"]["login"].value;
    var required = $('.required');
    var login = $('.login');
    var coincidence = $('.coincidence');

    for (var i = required.length - 1; i >= 0; i--) {
        if(!check_fill(required[i].value)){
            var tmp = required[i];
            if (tmp != null){
                $(tmp).parent().append(FILL_THIS);
                allright = false;
            }
        }
    }
    if(login != null && login[0].value != ""){
        if(!check_login_value(login[0].value)){
            $(login[0]).parent().append(LOGIN_VALUE);
            allright = false;
        }else{
            if(check_coincidence(coincidence)){
                for (var i = coincidence.length - 1; i >= 0; i--) {
                    $(coincidence[i]).parent().append(CONCIDENCED_FIELDS);
                    allright = false;
                }
        }
        }
    }
    return allright;
}

function check_coincidence(args){
    for (var i = 0; i < args.length - 1; i++) {
        for (var j = i + 1; j < args.length; j++) {
            if (_coincidence(args[i].value, args[j].value)){
                return true;
            }
        }
    }
    return false;
}

function _coincidence(arg1, arg2){
    if (arg1 === arg2){
        return true;
    }else{
        return false;
    }
}

function check_login_value(login){
    if (login != null){
        var regexp = new RegExp("^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$");
        return regexp.test(login);
    }else{
        return true;
    }
}

function check_fill(required) {
    if (required != null && required === ""){
        return false;
    }else{
        return true;
    }
}

function clear(){
    $("div.paper").remove();
}