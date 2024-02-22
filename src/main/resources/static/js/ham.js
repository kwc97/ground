	// 햄버거 버튼
    function toggleMenu(menuId) {
        var menu = document.getElementById(menuId);
        menu.classList.toggle('show');
    }
    
  	// 현재 url 변수로 가져오기
    let nowUrl = window.location.href;

    function copyUrl(){
        navigator.clipboard.writeText(nowUrl).then(res=>{
        alert("주소가 복사되었습니다!");
        })
    }
    
    // 권한이 있는 사람만 수정 삭제할 수 있도록