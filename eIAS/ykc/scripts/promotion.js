function slider(obj, maximum = 1) {
    var range = document.getElementById(obj),
        bar = range.getElementsByTagName("div")[0],
        progress = bar.children[0],
        dot = bar.children[1],
        num = range.getElementsByTagName("span")[0];
    bar.className = "bar";
    progress.className = "progress";
    dot.className = "dot";
    num.className = "num";
    var rest = bar.offsetWidth - dot.offsetWidth;

    if (!navigator.userAgent.match(/(iPhone|iPod|Android|ios|iOS|iPad|Backerry|WebOS|Symbian|Windows Phone|Phone)/i)) {
        dot.onmousedown = function(ev) {
            var dotL = dot.offsetLeft;
            var e = ev || window.event;
            var mouseX = e.clientX;
            window.onmousemove = function(ev) {
                var e = ev || window.event;
                var moveL = e.clientX - mouseX;
                var newL = dotL + moveL;
                if (newL < 0) {
                    newL = 0;
                }
                if (newL >= rest) {
                    newL = rest;
                }
                dot.style.left = newL + 'px';
                var bili = newL / rest * maximum;
                num.innerHTML = bili.toFixed(2); // 保留两位小数
                progress.style.width = bar.offsetWidth * bili / maximum + 'px';
                return false;
            }
            window.onmouseup = function() {
                window.onmousemove = false;
                return false;
            }
            return false;
        };
        bar.onclick = function(ev) {
            var left = ev.clientX - range.offsetLeft - dot.offsetWidth / 2;
            if (left < 0) {
                left = 0;
            }
            if (left >= rest) {
                left = rest;
            }
            dot.style.left = left + 'px';
            var bili = left / rest * maximum;
            num.innerHTML = bili.toFixed(2); // 保留两位小数
            progress.style.width = bar.offsetWidth * bili / maximum + 'px';
            return false;
        }
    } else {
        dot.ontouchstart = function(ev) {
            var dotL = dot.offsetLeft;
            var e = ev || window.event;
            var mouseX = e.touches[0].clientX;
            window.ontouchmove = function(ev) {
                var e = ev || window.event;
                var moveL = e.touches[0].clientX - mouseX;
                var newL = dotL + moveL;
                if (newL < 0) {
                    newL = 0;
                }
                if (newL >= rest) {
                    newL = rest;
                }
                dot.style.left = newL + 'px';
                var bili = newL / rest * maximum;
                num.innerHTML = bili.toFixed(2); // 保留两位小数
                progress.style.width = bar.offsetWidth * bili / maximum + 'px';
                return false;
            }
            window.ontouchend = function() {
                window.ontouchmove = false;
                return false;
            }
            return false;
        };
        bar.ontouchstart = function(ev) {
            var left = ev.touches[0].clientX - range.offsetLeft - dot.offsetWidth / 2;
            if (left < 0) {
                left = 0;
            }
            if (left >= rest) {
                left = rest;
            }
            dot.style.left = left + 'px';
            let bili = left / rest * maximum;
            num.innerHTML = bili.toFixed(2);
            progress.style.width = bar.offsetWidth * bill / maximum + 'px';
            return false;
        }
    }
}

slider("range");