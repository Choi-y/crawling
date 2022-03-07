import requests
import browser_cookie3

cookie_file_path=r"C:\Users\계정\AppData\Local\Google\Chrome\User Data\Default\Network\Cookies"

my_cookie = browser_cookie3.chrome(cookie_file=cookie_file_path, domain_name="naver.com")
url = "https://apis.naver.com/cafe-home-web/cafe-home/v1/cafes/join"
param = { "page":"1", "type":"join", "perPage":"10", "recentUpdates":"true" }
res = requests.get(url, cookies=my_cookie, params=param)
json_data = res.json()
for cafe in json_data["message"]["result"]["cafes"]:
    print(cafe["cafeName"])