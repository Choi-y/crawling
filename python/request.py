import requests

url = "http://www.naver.com"
res = requests.get(url)

print(res.text)