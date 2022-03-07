// Puppeteer

const puppeteer = require('puppeteer');
const cheerio = require('cheerio');

// 페이지 안에 있는 하이퍼링크를 수집하고 재검색 ..
const crawling = async (href) => {
    const browser = await puppeteer.launch({
        //headless: false
    });
    const page = await browser.newPage();
    await page.setViewport({
      width: 1440,
      height: 1080
    });
    await page.goto("https://www.tistory.com/category/life");
    const html = await page.content();
    const $ = cheerio.load(html);
    let hrefArray = [];
    $("a").each((index, element) => {
        const href = $(element).attr("href");
        hrefArray.push(href);
    });
    console.log(hrefArray);
    await browser.close();
    hrefArray.forEach((item) => {
        crawling(item.href);
    });
};

crawling();

/*
// 즉시 실행 함수 IIFE
(async () => {
  const browser = await puppeteer.launch({
      //headless: false
  });
  const page = await browser.newPage();
  await page.setViewport({
    width: 1440,
    height: 1080
  });
  await page.goto("https://www.tistory.com/category/life");
  const html = await page.content();
  const $ = cheerio.load(html);
  let hrefArray = [];
  $("ul.list_tistory > li > a").each((index, element) => {
      const href = $(element).attr("href");
      hrefArray.push({
          href,
          title,
      });
  });
  await browser.close();
  hrefArray.forEach((item) => {
      crawling(item);
  });
  //const mArticleText = $('#mArticle').text();
  //console.log(mArticleText);
  //await page.screenshot({ path: 'example.png' });
  //await browser.close();
})();
*/
