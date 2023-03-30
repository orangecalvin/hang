/**
 * 
 */
//검색 아이콘을 눌렀을 때
document.querySelector("#searchButton").addEventListener("click", searchHeritage);

// 엔터키를 쳤을 때
document.querySelector("#searchInput").addEventListener("keydown", function(event) {
  if (event.key === "Enter") {
  searchHeritage();
  }
  });


  function searchHeritage(){
    console.log('눌리나?');
  }