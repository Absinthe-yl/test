document.addEventListener('DOMContentLoaded', function() {
    //获取绑定person的id
const dialogMask = document.getElementById('dialogMask');
const dialogTitle = document.getElementById('dialogTitle');
const dialogContent = document.getElementById('dialogContent');

    //班级
    document.getElementById('openDialogBtn').addEventListener('click', () => {
        showDialog('班级信息', `
            <div>学院：计算机科学与数学学院</div>
            <div>班级：软件工程2301</div>
            <div>班主任：李老师</div>
        `);
    });

    //校历
    document.getElementById('viewCalendarBtn').addEventListener('click', () => {
        showDialog('2023-2024校历', `
            <img src="../img/date.png"  alt="校历" class="dialog-image">
            <div style="text-align:center; margin-top:10px;">校历仅供参考</div>
        `);
    });

    //宿舍信息
    document.getElementById('viewDormBtn').addEventListener('click', () => {
        showDialog('宿舍信息', `
            <div>楼栋：北区e2</div>
            <div>房间：102</div>
            <div>床位：3号床</div>
            <div>舍友：1、2、3、4、5</div>
        `);
    });

    //辅导员信息
    document.getElementById('viewCounselorBtn').addEventListener('click', () => {
        showDialog('辅导员信息', `
            <div>姓名：林传福</div>
            <div>办公室：至真c4</div>
            <div>联系电话：111111111</div>
            <div>值班时间：周一至周五 14:00-17:00</div>
        `);
    });

    //对话框
    function showDialog(title, content) {
        dialogTitle.textContent = title;
        dialogContent.innerHTML = content;
        dialogMask.classList.add('active');
    }

    //关闭对话框
    document.getElementById('cancelBtn').addEventListener('click', () => {
        dialogMask.classList.remove('active');
    });

    //点击遮罩层关闭
    dialogMask.addEventListener('click', (e) => {
        if(e.target === dialogMask) dialogMask.classList.remove('active');
    });
});