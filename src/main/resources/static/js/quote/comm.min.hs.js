$(document).ready(function () {
    $(".drop-down-menu ul li").mouseover(function () {
        $(this).children("ul").show();
        $(this).addClass("hover");
        $(this).children(".icon01").hide();
        $(this).children(".icon02").show()
    });
    $(".drop-down-menu ul li").mouseout(function () {
        $(this).children("ul").hide();
        $(this).removeClass("hover");
        $(this).children(".icon01").show();
        $(this).children(".icon02").hide()
    });
    $(".drop-menu-click ul li").click(function () {
        $(this).children("ul").show();
        $(this).addClass("hover");
        $(this).children(".icon01").hide();
        $(this).children(".icon02").show()
    });
    var d = {"margin-right": "0px", "float": "right", border: "0px"};
    var h = {"margin-right": "0px", "float": "right"};
    $("[name=liall2]").each(function () {
        $(this).children().each(function (a, c) {
            if ((a + 1) % 2 == 0) {
                $(this).css(d)
            }
        })
    });
    $("[name=liall4list]").each(function () {
        $(this).children().each(function (a, c) {
            if ((a % 4) == 0) {
                $(this).addClass("a1")
            } else {
                if ((a % 4) == 1) {
                    $(this).addClass("a1")
                } else {
                    if ((a % 4) == 2) {
                        $(this).addClass("a3")
                    } else {
                        if ((a % 4) == 3) {
                            $(this).addClass("a3")
                        }
                    }
                }
            }
        })
    });
    $("[name=liall6list]").each(function () {
        $(this).children().each(function (a, c) {
            if ((a % 6) == 0) {
                $(this).addClass("a1")
            } else {
                if ((a % 6) == 1) {
                    $(this).addClass("a1")
                } else {
                    if ((a % 6) == 2) {
                        $(this).addClass("a1")
                    } else {
                        if ((a % 6) == 3) {
                            $(this).addClass("a3")
                        } else {
                            if ((a % 6) == 4) {
                                $(this).addClass("a3")
                            } else {
                                if ((a % 6) == 5) {
                                    $(this).addClass("a3")
                                }
                            }
                        }
                    }
                }
            }
        })
    });
    $("[name=liall3]").each(function () {
        $(this).children().each(function (a, c) {
            if ((a + 1) % 3 == 0) {
                $(this).css(d)
            }
        })
    });
    $("[name=liall3a]").each(function () {
        $(this).children().each(function (a, c) {
            if ((a + 1) % 3 == 0) {
                $(this).css(h)
            }
        })
    });
    $("[name=liall4]").each(function () {
        $(this).children().each(function (a, c) {
            if ((a + 1) % 4 == 0) {
                $(this).css(d)
            }
        })
    });
    $("[name=liall5]").each(function () {
        $(this).children().each(function (a, c) {
            if ((a + 1) % 5 == 0) {
                $(this).css(h)
            }
        })
    });
    $("[name=liall6]").each(function () {
        $(this).children().each(function (a, c) {
            if ((a + 1) % 6 == 0) {
                $(this).css(d)
            }
        })
    });
    $(".imgmore").each(function (c, a) {
        JDT("#fl_focus_" + (c + 1))
    });
    $(".imgmore1").each(function (c, a) {
        JDT("#f2_focus_" + (c + 1))
    });
    var g = $(".con-tent").height();
    if (g > 300) {
        $(".down-share").css("display", "block")
    } else {
        $(".down-share").css("display", "none")
    }
    $("#close-btn").click(function () {
        $(".browser-warning").hide()
    });
    $(".add-type a").addClass("type-show");
    $(".add-type a:last-child").show();
    try {
        var n = document.getElementById("top-menu").offsetTop;
        $(window).scroll(function () {
            var a = $(window).scrollTop();
            if (a > n) {
                $("#top-menu").addClass("fixer");
                $(".yb_top").css("display", "block");
                $(".pub-menu-new>.drop-down-menu>ul>li>ul").removeClass("left-m")
            } else {
                $("#top-menu").removeClass("fixer");
                $(".yb_top").css("display", "none");
                $(".pub-menu-new>.drop-down-menu>ul>li>ul").addClass("left-m")
            }
        })
    } catch (j) {
    }
    try {
        var k = document.getElementById("load-buy").offsetTop;
        $(window).scroll(function () {
            var a = $(window).scrollTop();
            if (a > k) {
                $("#load-buy").addClass("fixer-sub");
                $("#load-buy").css("width", "1000px");
                $(".r-btn-white").show()
            } else {
                $("#load-buy").removeClass("fixer-sub");
                $("#load-buy").css("width", "100%");
                $(".r-btn-white").hide()
            }
        })
    } catch (j) {
    }
    try {
        var i = document.getElementById("r-alert").offsetTop;
        $(window).scroll(function () {
            var a = $(window).scrollTop();
            if (a > i) {
                $("#r-alert").addClass("fixer-right");
                $(".show-hide").fadeIn()
            } else {
                $("#r-alert").removeClass("fixer-right");
                $(".show-hide").fadeOut()
            }
        })
    } catch (j) {
    }
    $(".yb_top").click(function () {
        $("html,body").animate({scrollTop: "0px"}, 300)
    });
    $(window).scroll(function () {
        if ($(window).scrollTop() >= 100) {
            $(".actGotop").fadeIn(300)
        } else {
            $(".actGotop").fadeOut(300)
        }
    });
    $(".actGotop").click(function () {
        $("html,body").animate({scrollTop: "0px"}, 800)
    });
    $(".r-floor>ul>li>a").each(function (c, a) {
        $(a).mouseenter(function () {
            $(a).children(".top1").show();
            $(a).children(".top2").show().animate({right: "0px"});
            $(a).children(".top1").css("background", "#F39800")
        });
        $(a).mouseleave(function () {
            $(a).children(".top1").show().animate({right: "0px"});
            $(a).children(".top2").hide().animate({right: "-100px"});
            $(a).children(".top1").css("background", "#8c8c8c")
        })
    });
    try {
        var o = 10;
        var l = 20;
        $(".tooltip").mouseover(function (c) {
            this.myTitle = this.title;
            this.title = "";
            var a = "<div id='tooltip'>" + this.myTitle + "</div>";
            $("body").append(a);
            $("#tooltip").css({top: (c.pageY + l) + "px", left: (c.pageX + o) + "px"}).show("fast")
        }).mouseout(function () {
            this.title = this.myTitle;
            $("#tooltip").remove()
        }).mousemove(function (a) {
            $("#tooltip").css({top: (a.pageY + l) + "px", left: (a.pageX + o) + "px"})
        })
    } catch (j) {
    }
    $("a[href*=#]").click(function () {
        var a = jQuery(this.hash);
        a = a.length && a || jQuery("[name=" + this.hash.slice(1) + "]");
        if (a.length) {
            var c = a.offset().top;
            jQuery("html,body").animate({scrollTop: c}, 1000)
        }
    });
    $(".input-select").each(function () {
        var e = $(this), f = $(".select_menu", e), c = $("input[type=text]", e), a = $("input[type=hidden]", e), p;
        c.hover(function () {
            f.fadeIn("fast");
            c.removeClass("arrow-small-select");
            c.addClass("arrow-small-down")
        });
        $(f).delegate("dt,option", "click", function () {
            var r = $(this), q = r.html(), s = r.data("value");
            c.val(q);
            a.val(s);
            e.change();
            f.fadeOut("fast");
            c.removeClass("arrow-small-down");
            c.addClass("arrow-small-select")
        });
        e.mouseout(function () {
            clearTimeout(p);
            p = setTimeout(function () {
                f.fadeOut("fast")
            }, 200)
        });
        e.mouseover(function () {
            clearTimeout(p)
        })
    });
    $(".pub-menu-new>.drop-down-menu>ul>li>ul.one-li-new>li:nth-child(1)").addClass("no");
    $(".pub-menu-new>.drop-down-menu>ul>li>ul.one-li-new>li:nth-child(2)").addClass("no");
    $(".pub-menu-new>.drop-down-menu>ul>li>ul.one-li-new>li:nth-child(11)").addClass("no");
    $(".pub-menu-new>.drop-down-menu>ul>li>ul.one-li-new>li:nth-child(13)").addClass("no");
    $(".show-hide-data").each(function () {
        var a = $(this).find("ul li").length;
        if (a <= 0) {
            $(this).find(".icon-nodata").show();
            $(this).find(".show-hide-article").show();
            $(this).find(".send").show()
        }
    });
    $(".show-hide-data.l-8").each(function () {
        var a = $(this).find("ul li").length;
        if (a <= 8) {
            $(".show-hide-article").show()
        }
    });
    $("ul.tab-floor-r>.sub").each(function () {
        var a = $(this).find("a").length;
        if (a > 8) {
            $(this).addClass("scroll")
        }
    });
    var b = 13;
    $(".tab-list.select.lay2>a:gt(" + b + ")").hide();
    $(".select-more.lay2").click(function () {
        $(".tab-list.select.lay2>a:gt(" + b + ")").show();
        $(this).hide();
        $(".select-more-top.lay2").show()
    });
    $(".select-more-top.lay2").click(function () {
        $(".tab-list.select.lay2>a:gt(" + b + ")").hide();
        $(this).hide();
        $(".select-more.lay2").show()
    })
});
function setTab(c, a) {
    var d = document.getElementById("menu" + c).getElementsByTagName("li");
    var b = document.getElementById("main" + c).children;
    for (m = 0; m < d.length; m++) {
        if (m == a) {
            d[m].className = "menuFocus" + c;
            b[m].style.display = "block"
        } else {
            d[m].className = "menuNormal" + c;
            b[m].style.display = "none"
        }
    }
}
function setTabDL(d, a) {
    var b = document.getElementById("menudl" + d).getElementsByTagName("dt");
    var c = document.getElementById("maindl" + d).children;
    for (mdl = 0; mdl < b.length; mdl++) {
        if (mdl == a) {
            b[mdl].className = "focus" + d;
            c[mdl].style.display = "block"
        } else {
            b[mdl].className = "normal" + d;
            c[mdl].style.display = "none"
        }
    }
}
function setTabMore(d, a) {
    var c = document.getElementById("menum" + d).getElementsByTagName("li");
    var e = document.getElementById("menum" + d).getElementsByTagName("div");
    var b = document.getElementById("mainm" + d).children;
    for (w = 0; w < c.length; w++) {
        if (w == a) {
            c[w].className = "menuFocus" + d;
            b[w].style.display = "block";
            e[w].style.display = "block"
        } else {
            c[w].className = "menuNormal" + d;
            b[w].style.display = "none";
            e[w].style.display = "none"
        }
    }
}
function setTabUl(b, a) {
    $("#menuul1").children("pre").removeClass("focus");
    $(b).addClass("focus");
    $("#menuul1").children("div").hide();
    $("#mainul" + a).show()
}
function winOpen() {
    $(".win-con").fadeIn()
}
function winClose() {
    $(".win-con").fadeOut()
}
function outTag(a) {
    return a.replace(/<[^>]+>/g, "")
}
function getLocalTime(a) {
    return new Date(parseInt(a) * 1000).toLocaleString().replace(/:\d{1,2}$/, " ")
};