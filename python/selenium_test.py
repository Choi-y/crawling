from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome("chromedriver")

driver.get("https://www.naver.com")

driver.find_element(By.CSS_SELECTOR, "#query").send_keys("검색어")
driver.find_element(By.CSS_SELECTOR, "#search_btn > span.ico_search_submit").click()