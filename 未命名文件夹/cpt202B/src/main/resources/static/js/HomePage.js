document.addEventListener('DOMContentLoaded', function() {
    // 当页面加载完毕后显示欢迎部分
    document.getElementById('top-section').classList.add('show');

    // 监听滚动事件
    window.addEventListener('scroll', function() {
        // 获取所有 section 元素
        var sections = document.querySelectorAll('section');

        // 遍历所有 section 元素
        sections.forEach(function(section) {
            // 如果某个 section 元素的顶部位置小于或等于窗口底部位置，则显示该元素
            if (section.getBoundingClientRect().top <= window.innerHeight) {
                section.classList.add('show');
            }
        });

        // 显示按钮
        document.querySelectorAll('button, .make-appointment-btn').forEach(function(btn) {
            btn.style.display = 'block';
        });
    });
});

// 返回顶部函数
function scrollToTop() {
    window.scrollTo({
        top: 0,
        behavior: 'smooth' // 平滑滚动效果
    });
}
