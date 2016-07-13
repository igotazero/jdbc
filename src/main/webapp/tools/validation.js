var FILL_THIS = "<div class='paper'>This field must be filled</div>";
var LOGIN_VALUE = "<div class='paper'>Please, enter a valid login</div>";
var CONCIDENCED_FIELDS = "<div class='paper'>Fields must be different</div>";
var MUST_MATCH = "<div class='paper'>Passwords must match</div>";
var PASSWORD_LENGTH = "<div class='paper'>The password must be longer than 10 characters</div>";
var MUST_BE_NUMBER = "<div class='paper'>Value must be a number</div>";

function validate() {
    clear();
    var allright = true;
    var required = $('.required');
    var login = $('.login');
    var coincidence = $('.coincidence');
    var passwords = $('.password');
    var numbers = $('.number');

    for (var i = required.length - 1; i >= 0; i--) {
        if(!check_fill(required[i].value)){
            var tmp = required[i];
            if (tmp != null){
                show(tmp, FILL_THIS);
                allright = false;
            }
        }
    }
    if(login != null && login.length > 0 && login[0].value != ""){
        if(!check_login_value(login[0].value)){
            show(login[0], LOGIN_VALUE);
            allright = false;
        }else{
            if (coincidence.length > 0){
                if(check_coincidence(coincidence)){
                    for (var i = coincidence.length - 1; i >= 0; i--) {
                        show(coincidence[i], CONCIDENCED_FIELDS);
                        allright = false;
                    }
                }else{
                    check_passwords(passwords, allright);
                }
            }
        }
    }else{
        check_passwords(passwords, allright);
    }
    return allright;
}

function show(child, message){
    $(child).parent().append(message);
    $(".paper").fadeIn(200);
}

function check_passwords(passwords, allright){
    if (!check_empty_values(passwords)){
        if (!check_coincidence(passwords)){
            for (var i = passwords.length - 1; i >= 0; i--) {
                show(passwords[i], MUST_MATCH); 
            }
            allright = false;
        }else{
            if (!check_length(passwords[0].value, 10)){
                show(passwords[0], PASSWORD_LENGTH);
                allright = false;
            }
        }
    }
}

function check_coincidence(args){
    for (var i = 0; i < args.length - 1; i++) {
        if (args[i].value === ""){
            return false;
        }
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
    return required != "";
}

function check_empty_values(lits){
    for (var i = lits.length - 1; i >= 0; i--) {
        if (lits[i].value === ""){
            return true;
        }
    }
    return false;
}

function check_length(string, length){
    if (string.length < length){
        return false;
    }else{
        return true;
    }
}

function clear(){
    $(".paper").fadeOut(200);
    $("div.paper").remove();
}