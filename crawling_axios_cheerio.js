const axios = require("axios");
const cheerio = require('cheerio');
//const $ = cheerio.load('<h2 class="title">Hello world</h2>');

//$('h2.title').text('Hello there!');
//$('h2').addClass('welcome');

//$.html();

axios.get("https://www.tistory.com/category/getMoreCategoryPost.json?category=list&lastPublished=0&first=true").then(response => {
    //console.log(Object.keys(response));
    //console.log(response.data);
    const htmlString = response.data;
    //const $ = cheerio.load(htmlString); //html 문자열이 파싱($)됐다~
    //const h1 = $('h1').text();
    //console.log(h1);
    console.dir(htmlString.data.list);
});