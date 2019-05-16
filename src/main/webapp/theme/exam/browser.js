var isNS = (navigator.appName == "Netscape") ? 1 : 0;
document.oncontextmenu = function () {
    return false
};
document.onkeydown = doKeyDown;
keys = new Array();
keys.f112 = "f1";
keys.f113 = "f2";
keys.f114 = "f3";
keys.f115 = "f4";
keys.f116 = "f5";
keys.f117 = "f6";
keys.f118 = "f7";
keys.f119 = "f8";
keys.f120 = "f9";
keys.f121 = "f10";
keys.f122 = "f11";
keys.f123 = "f12";
saveCode = "";

function myFunc(a) {
    if (window.event.keyCode < 16 && window.event.keyCode > 18) {
        return false
    }
}

function disableFKeys(a) {
    if (window.event && keys["f" + window.event.keyCode]) {
        saveCode = window.event.keyCode;
        window.event.keyCode = 505
    }
    if (window.event && window.event.keyCode == 505) {
        myFunc(saveCode);
        Stop(a)
    }
}
fKeyMap = [{
    keyCode: 112,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: false,
    vKey: "F1"
}, {
    keyCode: 113,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: false,
    vKey: "F2"
}, {
    keyCode: 18,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: false,
    vKey: "Alt Key"
}, {
    keyCode: 114,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: false,
    vKey: "F3"
}, {
    keyCode: 115,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: false,
    vKey: "F4"
}, {
    keyCode: 116,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: false,
    vKey: "F5"
}, {
    keyCode: 117,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: false,
    vKey: "F6"
}, {
    keyCode: 118,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: false,
    vKey: "F7"
}, {
    keyCode: 119,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: false,
    vKey: "F8"
}, {
    keyCode: 120,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: false,
    vKey: "F9"
}, {
    keyCode: 121,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: false,
    vKey: "F10"
}, {
    keyCode: 122,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: false,
    vKey: "F11"
}, {
    keyCode: 123,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: false,
    vKey: "F12"
}, {
    keyCode: 93,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: false,
    vKey: "Right Click"
}, {
    keyCode: 93,
    isMapped: true,
    shift: false,
    ctrl: true,
    alt: false,
    vKey: "Right Click + ctrl"
}, {
    keyCode: 121,
    isMapped: true,
    shift: true,
    ctrl: false,
    alt: false,
    vKey: "Right Click"
}, {
    keyCode: 116,
    isMapped: true,
    shift: false,
    ctrl: true,
    alt: false,
    vKey: "Refresh"
}, {
    keyCode: 82,
    isMapped: true,
    shift: false,
    ctrl: true,
    alt: false,
    vKey: "Refresh"
}, {
    keyCode: 80,
    isMapped: true,
    shift: false,
    ctrl: true,
    alt: false,
    vKey: "Print"
}, {
    keyCode: 78,
    isMapped: true,
    shift: false,
    ctrl: true,
    alt: false,
    vKey: "New Window"
}, {
    keyCode: 87,
    isMapped: true,
    shift: false,
    ctrl: true,
    alt: false,
    vKey: "Close Window"
}, {
    keyCode: 83,
    isMapped: true,
    shift: false,
    ctrl: true,
    alt: false,
    vKey: "Save Window"
}, {
    keyCode: 69,
    isMapped: true,
    shift: false,
    ctrl: true,
    alt: false,
    vKey: "Search Explorer"
}, {
    keyCode: 72,
    isMapped: true,
    shift: false,
    ctrl: true,
    alt: false,
    vKey: "History"
}, {
    keyCode: 73,
    isMapped: true,
    shift: false,
    ctrl: true,
    alt: false,
    vKey: "Favorites"
}, {
    keyCode: 88,
    isMapped: true,
    shift: false,
    ctrl: true,
    alt: false,
    vKey: "Cut"
}, {
    keyCode: 67,
    isMapped: true,
    shift: false,
    ctrl: true,
    alt: false,
    vKey: "Copy"
}, {
    keyCode: 86,
    isMapped: true,
    shift: false,
    ctrl: true,
    alt: false,
    vKey: "Paste"
}, {
    keyCode: 65,
    isMapped: true,
    shift: false,
    ctrl: true,
    alt: false,
    vKey: "Select All"
}, {
    keyCode: 8,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: false,
    vKey: "Back"
}, {
    keyCode: 8,
    isMapped: true,
    shift: true,
    ctrl: false,
    alt: false,
    vKey: "forwad"
}, {
    keyCode: 36,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: true,
    vKey: "forwad"
}, {
    keyCode: 37,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: true,
    vKey: "Left"
}, {
    keyCode: 38,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: true,
    vKey: "Top"
}, {
    keyCode: 39,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: true,
    vKey: "Right"
}, {
    keyCode: 40,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: true,
    vKey: "Bottom"
}, {
    keyCode: 116,
    isMapped: true,
    shift: false,
    ctrl: false,
    alt: true,
    vKey: "alt refresh"
}, {
    keyCode: 0,
    isMapped: false
}];

function doKeyDown(b) {
    b = (isNS) ? b : window.event;
    var a = b.keyCode ? b.keyCode : b.which ? b.which : b.charCode;
    var g = b.srcElement;
    var f = b.shiftKey;
    var d = b.ctrlKey;
    var c = b.altKey;
    //if (a >= 13 && a <= 15) { //enable enter key

    if (a >= 14 && a <= 15) {
        Stop(b)
    }
    if (a == 27) {
        Stop(b)
    }
    if (a == 192) {
        Stop(b)
    }
    if (a == 91) {
        Stop(b)
    }
    if (a >= 16 && a <= 18) {
        Stop(b)
    }
    if (a == 116) {
        Stop(b)
    }
    for (var h = 0; h < fKeyMap.length; h++) {
        if (fKeyMap[h].keyCode == a && fKeyMap[h].shift == f && fKeyMap[h].ctrl == d && fKeyMap[h].alt == c) {
            if (fKeyMap[h].isMapped) {
                if (a == 8) {
                    if (b.srcElement.type != undefined && b.srcElement.type.match("text") && b.srcElement.readOnly == false) {
                        return true
                    }
                    if (b.srcElement.type != undefined && b.srcElement.type.match("password") && b.srcElement.readOnly == false) {
                        return true
                    }
                }
                Stop(b)
            } else {
                return true
            }
        }
    }
    disableFKeys(b)
}

function Stop(a) {
    a = (isNS) ? a : window.event;
    if (isNS) {
        if (a.stopPropagation) {
            a.stopPropagation();
            a.preventDefault()
        }
    } else {
        a.cancelBubble = true;
        a.returnValue = false
    }
    return false
}

function trim(b, a) {
    return ltrim(rtrim(b, a), a)
}

function ltrim(b, a) {
    a = a || "\\s";
    return b.replace(new RegExp("^[" + a + "]+", "g"), "")
}

function rtrim(b, a) {
    a = a || "\\s";
    return b.replace(new RegExp("[" + a + "]+$", "g"), "")
}

function captureTab(a) {
    var b = (navigator.appName == "Netscape") ? 1 : 0;
    a = (b) ? a : window.event;
    if (a.keyCode == 9) {
        return true
    } else {
        return false
    }
}
var ARRQUESTIONCOUNT = new Array();
var ARRCASEQUESTIONCOUNT = new Array();
var ARRANSWEROPTIONSCOUNT = new Array();

function setElementsCountByClassName() {
    var g = "greybluetextquestion";
    var d = "greybluetextans";
    var m = "groupQuesPara_v";
    var f = document.getElementsByTagName("*");
    var e;
    var b;
    var a;
    var c;
    for (e = 0, b = 0, a = 0, c = 0; e < f.length; e++) {
        var h = " " + f[e].className + " ";
        if (h.indexOf(" " + g + " ") != -1) {
            ARRQUESTIONCOUNT[b++] = f[e]
        }
        if (h.indexOf(" " + d + " ") != -1) {
            ARRANSWEROPTIONSCOUNT[a++] = f[e]
        }
        if (h.indexOf(" " + m + " ") != -1) {
            ARRCASEQUESTIONCOUNT[c++] = f[e]
        }
    }
}

function getElementsByClassName(f) {
    var e = document.getElementsByTagName("*");
    var b = new Array();
    var d;
    var a;
    for (d = 0, a = 0; d < e.length; d++) {
        var g = " " + e[d].className + " ";
        if (g.indexOf(" " + f + " ") != -1) {
            b[a++] = e[d]
        }
    }
    return b
}

function getStyle(el,styleProp) { var camelize = function (str) { return str.replace(/\-(\w)/g, function(str, letter){ return letter.toUpperCase(); }); }; if (el.currentStyle) { return el.currentStyle[camelize(styleProp)]; } else if (document.defaultView && document.defaultView.getComputedStyle) { return document.defaultView.getComputedStyle(el,null) .getPropertyValue(styleProp); } else { return el.style[camelize(styleProp)]; } }

function changeQPFontSize(g) {
    var b = 8;
    var e = 30;
    g = parseInt(g, 10);
    var d = ARRQUESTIONCOUNT.length;
	var h = parseInt(getStyle(ARRQUESTIONCOUNT[0], 'font-size'),10);
    //var h = parseInt(window.getComputedStyle(ARRQUESTIONCOUNT[0], null).getPropertyValue('font-size'), 10);
    var a = ARRANSWEROPTIONSCOUNT.length;
	var c = parseInt(getStyle(ARRANSWEROPTIONSCOUNT[0], 'font-size'),10);
    //var c = parseInt(window.getComputedStyle(ARRANSWEROPTIONSCOUNT[0], null).getPropertyValue('font-size'), 10);
	
    var x = ARRCASEQUESTIONCOUNT.length;
	if(x>0)
		var y = parseInt(getStyle(ARRCASEQUESTIONCOUNT[0], 'font-size'),10);
	else
		var y = 0

    if (g == 1) {
        if (h <= e) {
            for (var f = 0; f < a; f++) {
                if (f < d) {
                    ARRQUESTIONCOUNT[f].style.fontSize = (h + 2) + "px"
                }
                if (f < x) {
                    ARRCASEQUESTIONCOUNT[f].style.fontSize = (y + 2) + "px"
                }
                ARRANSWEROPTIONSCOUNT[f].style.fontSize = (c + 2) + "px"
            }
        }
    } else {
        if (g == 0) {
            if (h > b) {
                for (var f = 0; f < a; f++) {
                    if (f < d) {
                        ARRQUESTIONCOUNT[f].style.fontSize = (h - 2) + "px"
                    }
                    if (f < x) {
                        ARRCASEQUESTIONCOUNT[f].style.fontSize = (y - 2) + "px"
                    }
                    ARRANSWEROPTIONSCOUNT[f].style.fontSize = (c - 2) + "px"
                }
            }
        }
    }
}

function explode(c, e, a) {
    var f = {
        0: ""
    };
    if (arguments.length < 2 || typeof arguments[0] == "undefined" || typeof arguments[1] == "undefined") {
        return null
    }
    if (c === "" || c === false || c === null) {
        return false
    }
    if (typeof c == "function" || typeof c == "object" || typeof e == "function" || typeof e == "object") {
        return f
    }
    if (c === true) {
        c = "1"
    }
    if (!a) {
        return e.toString().split(c.toString())
    } else {
        var g = e.toString().split(c.toString());
        var d = g.splice(0, a - 1);
        var b = g.join(c.toString());
        d.push(b);
        return d
    }
};