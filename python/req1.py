#분석할 페이지 : https://kr.investing.com/commodities/iron-ore-62-cfr-futures
#분석 시 개발자 도구 실행 후 '6달' 버튼을 클릭하여 동적 데이터 확인할 것
import requests
import datetime

url = "https://api.investing.com/api/financialdata/961729/historical/chart/?period=P6M&interval=P1D&pointscount=120"

res = requests.get(url)
json_data = res.json()

for data in json_data["data"]:
    ymd = str(datetime.datetime.fromtimestamp(data[0]/1000))
    print("일자 : {}, 가격 : {}".format(ymd[0:10], data[1]))