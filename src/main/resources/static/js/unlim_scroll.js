
// 무한 스크롤을 위한 JavaScript 코드
let page = 1; // 초기 페이지 설정

function loadMoreContent() {
    // 여기에 페이지별로 가져올 데이터를 Ajax 등을 이용하여 가져오는 코드를 작성합니다.
    // 아래는 간단한 예시입니다.
    const newContent = `
        <article>
            <!-- 여기에 추가될 내용을 넣어주세요 -->
        </article>
    `;
    // articles array에 새 내용 추가
    articles.push(newContent);

    // 가져온 데이터를 articleWrapper에 추가합니다.
    document.getElementById('articleWrapper').innerHTML += newContent;

    // 페이지를 증가시킵니다.
    page++;
}

function updateArticleVisibility() {
    const contentContainer = document.getElementById('contents');
    const containerHeight = contentContainer.clientHeight;

    // 아티클 배열을 루프하고 스크롤에 대한 위치를 확인합니다
    articles.forEach((article, index) => {
        const articleTop = index * containerHeight;
        const articleBottom = (index + 1) * containerHeight;

        //article이 눈에 보이는 범위 내에 있는지 확인합니다
        if (contentContainer.scrollTop >= articleTop && contentContainer.scrollTop < articleBottom) {
            // Make the article visible
            document.getElementById('articleWrapper').innerHTML = article;
        } else {
            // Remove the article from the DOM if it's not visible
            document.getElementById('articleWrapper').innerHTML = '';
        }
    });
}

// Scroll event detection
document.getElementById('contents').addEventListener('scroll', function () {
    // If scrolled to the bottom, load more content
    if (this.scrollTop + this.clientHeight >= this.scrollHeight) {
        loadMoreContent();
    }

    // 스크롤 위치에 따라 article의 가시성 업데이트
    updateArticleVisibility();
});

// Initial loading of content
window.onload = () => {
    loadMoreContent();
    updateArticleVisibility();
};

