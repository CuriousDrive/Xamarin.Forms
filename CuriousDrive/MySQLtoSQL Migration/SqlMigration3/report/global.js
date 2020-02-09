window.onload = function () {
    include("../js/jquery-1.11.1.min.js");
    document.getElementsByTagName("body")[0].className += " sqlBody";
    collectProblems();
    getLineElement();
};

var cur = null;
var curClass = null;

var selected = new Array();
var selectedClasses = new Array();

function include(filename) {
    var head = document.getElementsByTagName("head")[0];

    script = document.createElement("script");
    script.src = filename;
    script.type = "text/javascript";

    head.appendChild(script);
}

// Return short file name
function getShortFileName() {
    // Get last position of slash
    var positionOfLastSlash = location.href.lastIndexOf("/") + 1;
    // Get last position of dot
    var positionOfLastDot = location.href.lastIndexOf(".");
    // Return substring
    return location.href.substring(positionOfLastSlash, positionOfLastDot);
}

// Return true is source
function getIsSource() {
    return (getShortFileName() == "src");
}

// Return true is target
function getIsTarget() {
    return (getShortFileName() == "trg");
}

// Get current Button frame
function getCurrentButton() {
    var currentButtonFrameName;

    if (getIsSource()) {
        currentButtonFrameName = "srcButt";
    } else if (getIsTarget()) {
        currentButtonFrameName = "trgButt";
    }

    if (currentButtonFrameName != undefined) {
        var fr = top.frames["node"];

        var frameButton = null;

        if (fr == undefined) {
            frameButton = top.frames[currentButtonFrameName];
        } else {
            frameButton = fr.frames[currentButtonFrameName];
        }

        return frameButton;
    }
}

// Create instance buttons manager for bookmarks
function BookmarkButtonsManager() {
    // Return element previous_bookmark
    this.getPreviousButton = function () {
        if (getCurrentButton() != undefined) {
            return getCurrentButton().document.getElementById("previous_bookmark");
        } else {
            return undefined;
        }
    };

    // Return element next_bookmark
    this.getNextButton = function () {
        if (getCurrentButton() != undefined) {
            return getCurrentButton().document.getElementById("next_bookmark");
        } else {
            return undefined;
        }
    };

    // Return element clear_bookmarks
    this.getClearButton = function () {
        if (getCurrentButton() != undefined) {
            return getCurrentButton().document.getElementById("clear_bookmarks");
        } else {
            return undefined;
        }
    };

    this.disabledButton = function (button) {
        if (button != undefined) {
            button.onmouseout();
            button.disabled = true;
            button.style.filter = "progid:DXImageTransform.Microsoft.BasicImage(grayscale=1)";
        }
    };

    this.enabledButton = function (button) {
        if (button != undefined) {
            button.disabled = false;
            button.style.filter = "";
        }
    };
}

// Constructor of Bookmarks class
function CreateBookmarksObject(Bookmarks) {
    // Array of Bookmarks
    var bookmarks = Bookmarks;

    // Current position
    var curBookmark = 0;

    // Get Bookmarks
    this.getBookmarks = function () {
        return bookmarks;
    };

    // Get current position
    this.getCurrentPosition = function () {
        return curBookmark;
    };

    // Return number of bookmarks
    this.getLength = function () {
        return bookmarks.length;
    };

    // Set current position
    this.setCurrentPosition = function (Position) {
        curBookmark = Position;
        this.setButtonStyle();
    };

    // Increment position
    this.incPosition = function () {
        curBookmark++;
        this.setButtonStyle();
    };

    // Decrement position
    this.decPosition = function () {
        curBookmark--;
        this.setButtonStyle();
    };

    // Return Bookmark in current position
    this.getCurrentBookmark = function () {
        return bookmarks[curBookmark];
    };

    // Return Bookmark in specified position
    this.getBookmarkInPosition = function (Position) {
        return bookmarks[Position];
    };

    // Disabled/enable buttons
    this.setButtonStyle = function () {
        var manager = new BookmarkButtonsManager();

        switch (this.getLength()) {
            case 0:
                {
                    // If there are no bookmarks - disable all buttons
                    manager.disabledButton(manager.getPreviousButton());
                    manager.disabledButton(manager.getNextButton());
                    manager.disabledButton(manager.getClearButton());
                    break;
                }
            case 1:
                {
                    // If there is only one bookmark - disable previous button
                    manager.disabledButton(manager.getPreviousButton());
                    manager.enabledButton(manager.getNextButton());
                    manager.enabledButton(manager.getClearButton());
                    break;
                }
            default:
                {
                    if (this.getCurrentPosition() == 0) {
                        // If current bookmark is first in the array - disable previous button
                        manager.disabledButton(manager.getPreviousButton());
                        manager.enabledButton(manager.getNextButton());
                        manager.enabledButton(manager.getClearButton());
                    } else if (this.getCurrentPosition() == this.getLength() - 1) {
                        // If current bookmark is last in the array - disable next button
                        manager.enabledButton(manager.getPreviousButton());
                        manager.disabledButton(manager.getNextButton());
                        manager.enabledButton(manager.getClearButton());
                    } else {
                        // If current bookmark neither first nor last in the array - enabled all button
                        manager.enabledButton(manager.getPreviousButton());
                        manager.enabledButton(manager.getNextButton());
                        manager.enabledButton(manager.getClearButton());
                    }
                    break;
                }
        }
    };

    this.setButtonStyle();
}

// Create instance
var Bookmark = new CreateBookmarksObject(new Array());

// Create instance buttons manager for problems
function ProblemButtonsManager() {
    // Return element previous_problem
    this.getPreviousButton = function () {
        if (getCurrentButton() != undefined) {
            return getCurrentButton().document.getElementById("previous_problem");
        } else {
            return undefined;
        }
    };

    // Return element next_problem
    this.getNextButton = function () {
        if (getCurrentButton() != undefined) {
            return getCurrentButton().document.getElementById("next_problem");
        } else {
            return undefined;
        }
    };

    // Disabled button
    this.disabledButton = function (button) {
        if (button != undefined) {
            button.onmouseout();
            button.disabled = true;
            button.style.filter = "progid:DXImageTransform.Microsoft.BasicImage(grayscale=1)";
        }
    };

    // Enabled button
    this.enabledButton = function (button) {
        if (button != undefined) {
            button.disabled = false;
            button.style.filter = "";
        }
    };
}

function CreateProblemsObject(Problems) {
    var problems = Problems;

    var curProblem = -1;

    // Return number of problems
    this.getLength = function () {
        return problems.length;
    };

    // Add problem to problems array
    this.addProblem = function (Problem) {
        problems[this.getLength()] = Problem;
        this.setButtonStyle();
    };

    // Get current position
    this.getPosition = function () {
        return curProblem;
    };

    // Set current position
    this.setCurrentPosition = function (Position) {
        curProblem = Position;
        this.setButtonStyle();
    };

    // Increment position
    this.incPosition = function () {
        curProblem++;
        this.setButtonStyle();
    };

    // Decrement position
    this.decPosition = function () {
        curProblem--;
        this.setButtonStyle();
    };

    // Return problems in current position
    this.getCurrentProblem = function () {
        return problems[curProblem];
    };

    // Return problem in specified position
    this.getProblemInPosition = function (Position) {
        return problems[Position];
    };

    // Disabled/enable buttons
    this.setButtonStyle = function () {
        var manager = new ProblemButtonsManager();

        switch (this.getLength()) {
            case 0:
                {
                    // If there are no problems - disable all buttons
                    manager.disabledButton(manager.getPreviousButton());
                    manager.disabledButton(manager.getNextButton());
                    break;
                }
            case 1:
                {
                    // If there is only one problem - disable previous button
                    manager.disabledButton(manager.getPreviousButton());
                    manager.enabledButton(manager.getNextButton());
                    break;
                }
            default:
                {
                    if (this.getPosition() == 0 || this.getPosition() == -1) {
                        // If current problem is first in the array - disable previous button
                        manager.disabledButton(manager.getPreviousButton());
                        manager.enabledButton(manager.getNextButton());
                    } else if (this.getPosition() == this.getLength() - 1) {
                        // If current problem is last in the array - disable next button
                        manager.enabledButton(manager.getPreviousButton());
                        manager.disabledButton(manager.getNextButton());
                    } else {
                        // If current problem is neither first nor last in array - enabled all buttons
                        manager.enabledButton(manager.getPreviousButton());
                        manager.enabledButton(manager.getNextButton());
                    }

                    break;
                }
        }
    };

    this.setButtonStyle();
}

// Create instance of Problems
var Problem = new CreateProblemsObject(new Array());

var selectedLevel;

var insideRefl = false;

function oc(event, s) {
    event = window.event || event;

    if (s && s.substring(0, 1) == "m") {
        var i = document.getElementById(s);

        if (i != null) {
            var par = i.parentElement;
            oc(par.id);
            par.scrollIntoView(true);
            return;
        }
    }

    highlightNode(s);

    if (event != null) {
        event.cancelBubble = true;
    }
}

function checkInputParams() {
    INPUT_PARAMS = {};

    separator = ",";

    query = "" + this.location;
    qu = query;
    query = query.substring((query.indexOf("?")) + 1);

    if (query.length < 1) {
        return false;
    }

    keypairs = {};
    numKP = 1;

    while (query.indexOf("&") > -1) {
        keypairs[numKP] = query.substring(0, query.indexOf("&"));
        query = query.substring((query.indexOf("&")) + 1);
        numKP++;
    }

    keypairs[numKP] = query;

    for (i in keypairs) {
        keyName = keypairs[i].substring(0, keypairs[i].indexOf("="));

        keyValue = keypairs[i].substring((keypairs[i].indexOf("=")) + 1);

        while (keyValue.indexOf("+") > -1) {
            keyValue =
                keyValue.substring(0, keyValue.indexOf("+"))
                + " "
                + keyValue.substring(keyValue.indexOf("+") + 1);
        }

        keyValue = unescape(keyValue);

        if (INPUT_PARAMS[keyName]) {
            INPUT_PARAMS[keyName] = INPUT_PARAMS[keyName] + separator + keyValue;
        } else {
            INPUT_PARAMS[keyName] = keyValue;
            // Normal case: name gets value.
        }
    }

    return FORM_DATA;
}

function refl(s) {
    if (self.name == "src") {
        obj = parent.trg;
    } else {
        obj = parent.src;
    }

    insideRefl = true;

    if (insideRefl) {
        if (obj) {
            obj.highlightAndScrollToVisibleNode(s);
        }

        insideRefl = false;
    }

    // The following is needed to prevent some IE bugs
    ////obj.highlightAndScrollToVisibleNode(s);
}

function myScrollIntoView(obj) {
    obj.scrollIntoView(true);
}

function ltrim(input) {
    while (input.substring(0, 1) == " ") {
        input = input.substring(1, input.length);
    }

    return input;
}

function highlightNode(s) {
    if (!s || s.length == 0) {
        return;
    }

    var segments = s.split("||");

    cur = document.getElementById(segments[0]);

    var i = 0;
    for (i = 0; i < selected.length; i++) {
        var selectedItem = selected[i];
        selectedItem.className = selectedClasses[i];
        if (selectedItem.className.indexOf("Div") > 0) {
            inverseLines(selectedItem);
        }
    }

    selected = new Array();
    selectedClasses = new Array();

    for (i = 0; i < segments.length; i++) {
        var q = ltrim(segments[i]);

        var temp = q.indexOf("a");
        if ((temp == -1 || temp >= 0) && (q.length == 36)) {
            q = "a" + q;
        }

        var subElement = document.getElementById(q);
        if (subElement != null) {
            if (cur == null) {
                cur = subElement;
            }

            selected.push(subElement);
            selectedClasses.push(subElement.className);

            if (subElement.className.indexOf("Div") > 0 || subElement.className.indexOf("Err") > 0) {
                inverseLines(subElement);
                subElement.className = "selectedDiv";
            } else {
                subElement.className = "selectedSpan";
            }
        }
    }
}

function inverseLines(s) {
    var oObject = s.all;

    if (oObject != null) {
        if (oObject.length != null) {
            for (i = 0; i < oObject.length; i++) {
                var ob = oObject(i);

                if (ob.className == "line") {
                    ob.className = "uls";
                } else if (ob.className == "uls") {
                    ob.className = "line";
                }
            }
        }
    }
}

function highlightAndScrollToVisibleNode(s) {
    highlightNode(s);

    if (cur != null) {
        cur.scrollIntoView(true);
    }
}

function goRef(s) {
    oc(s);

    if (cur != null) {
        cur.scrollIntoView(true);
    }
}

function goHref(s) {
    window.event.cancelBubble = true;
    top.navigate(s);
}

function toggleBookmark(s) {
    if (s.className != "idbookmark") {
        s.className = "idbookmark";
        s.childNodes[0].src = "../img/bookmark.gif";
    } else {
        s.className = "line";
        s.childNodes[0].src = "../img/empty.gif";
    }

    var bookmarkElements = new Array();

    if (document.getElementsByClassName) {
        bookmarkElements = document.getElementsByClassName("idbookmark");
    } else {
        var codes = document.getElementsByTagName("code");
        var bookmarkIndex = 0;
        for (var i = 0; i < codes.length; i++) {
            if (codes[i].className == "idbookmark") {
                bookmarkElements[bookmarkIndex] = codes[i];
                bookmarkIndex++;
            }
        }
    }

    Bookmark = new CreateBookmarksObject(bookmarkElements);

    if (Bookmark.getCurrentPosition() == Bookmark.getLength() && Bookmark.getCurrentPosition() > 0) {
        Bookmark.decPosition();
    }

    window.event.cancelBubble = true;
    SetClearBookMarks1();
}

function nextBookmark() {
    if (Bookmark.getLength() == 0) {
        return;
    }

    if (Bookmark.getCurrentPosition() < Bookmark.getLength() - 1) {
        Bookmark.incPosition();
    }

    goBookmark();
}

function prevBookmark() {
    try {
        if (Bookmark.getLength() == 0) {
            return;
        }

        if (Bookmark.getCurrentPosition() > 0) {
            Bookmark.decPosition();
        }

        goBookmark();
    }
    catch (e) { }
}

function goBookmark() {
    myScrollIntoView(Bookmark.getCurrentBookmark());
    Bookmark.getCurrentBookmark().scrollIntoView(true);
}

function prevSibling() {
    if (cur == null) {
        return;
    }

    var par = cur.parentNode;

    if (par != null) {
        var k = 0;
        var siblings = par.children.tags("div");

        for (i = 0; i < siblings.length; i++) {
            if (siblings[i] == cur) {
                k = i;
                break;
            }
        }

        if (k == 0) {
            return;
        }

        siblings[k - 1].click();
    }
}

function nextSibling() {
    if (cur == null) {
        return;
    }

    var par = cur.parentNode;

    if (par != null) {
        var k = 0;
        var siblings = par.children.tags("div");

        for (i = 0; i < siblings.length; i++) {
            if (siblings[i] == cur) {
                k = i;
                break;
            }
        }

        if (k == 0) {
            return;
        }

        highlightAndScrollToVisibleNode(siblings[k - 1].id);
    }
}

function clearBookmarks() {
    var len = Bookmark.getLength();

    for (p = len - 1; p >= 0 ; p--) {
        var k = p;

        Bookmark.getBookmarkInPosition(k).childNodes[0].src = "../img/empty.gif";
        Bookmark.getBookmarkInPosition(k).className = "line";
    }

    Bookmark.setCurrentPosition(0);
    Bookmark = new CreateBookmarksObject(new Array);
    SetClearBookMarks1();
}

function SetClearBookMarks1() {
    try {
        if (window.external == null) {
            return;
        }

        if (Bookmark.getLength() == 0) {
            window.external.DisableClearBookMarks();
        } else {
            window.external.EnableClearBookMarks();
        }
    }
    catch (e) { }
}

function nextProblem() {
    var t = top.frames["messages"];
    if (t != undefined) {
        selectedLevel = t.selectedLev;
    } else {
        selectedLevel = 0;
    }

    if (Problem.getLength() == 0) {
        return;
    }

    var currentProblemPosition = Problem.getPosition();

    while (Problem.getPosition() < Problem.getLength() - 1) {
        Problem.incPosition();

        if (parseInt(Problem.getCurrentProblem().attributes["category"].value, 10) > selectedLevel) {
            continue;
        }

        goProblem();
        return;
    }

    Problem.setCurrentPosition(currentProblemPosition);
}

function prevProblem() {
    var t = top.frames["messages"];

    if (t != undefined) {
        selectedLevel = t.selectedLev;
    } else {
        selectedLevel = 0;
    }

    if (Problem.getLength() == 0) {
        return;
    }

    var currentProblemPosition = Problem.getPosition();

    while (Problem.getPosition() > 0) {
        Problem.decPosition();
        if (parseInt(Problem.getCurrentProblem().attributes["category"].value, 10) > selectedLevel) {
            continue;
        }

        goProblem();
        return;
    }

    Problem.setCurrentPosition(currentProblemPosition);
}

function goProblem() {
    if (Problem.getCurrentProblem().tagName == "ERR") {
        Problem.getCurrentProblem().parentElement.scrollIntoView(true);
    } else {
        Problem.getCurrentProblem().scrollIntoView(true);
    }

    Problem.getCurrentProblem().click();
}

function addProblem(newProblem) {
    Problem.addProblem(newProblem);
}

function collectProblems() {
    var candidates = document.getElementsByTagName("ERR");
    for (i = 0; i < candidates.length; i++) {
        if (candidates[i].attributes["category"] != null) {
            addProblem(candidates[i]);
        }
    }
}

function isInView(oObject) {
    var p = self.document.body;
    var t = oObject.offsetTop;
    var h = p.clientHeight;
    var b = oObject.offsetHeight;

    var st = p.scrollTop;
    if (t > h + st || t < st || t + b > h + st) {
        return 1;
    }
    return 0;
}

function getLineElement() {
    var lines = document.getElementsByTagName("code");
    for (var i = 0; i < lines.length; i++) {
        lines[i].className += " line";
        lines[i].onclick = function () { toggleBookmark(this); };
    }
};
