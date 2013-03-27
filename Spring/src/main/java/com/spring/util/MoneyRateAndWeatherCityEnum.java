package com.spring.util;

public enum MoneyRateAndWeatherCityEnum {

	CITY1("베이징") {
		@Override
		public String getMoneyRateCode() {
			return "CNY";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Y";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Beijing";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Hong_Kong";
		}
	},
	CITY2("상하이") {
		@Override
		public String getMoneyRateCode() {
			return "CNY";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Y";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Shanghai";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Hong_Kong";
		}
	},
	CITY3("홍콩") {
		@Override
		public String getMoneyRateCode() {
			return "HKD";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "H$";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Hong%20kong";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Hong_Kong";
		}
	},
	CITY4("마카오") {
		@Override
		public String getMoneyRateCode() {
			return "MOP";
		}
		
		@Override
		public String getMoneyRateChar() {
			
			return "H$";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Macau";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Hong_Kong";
		}
	},
	CITY5("싱가포르") {
		@Override
		public String getMoneyRateCode() {
			return "SGD";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "S$";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Singapore";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Singapore";
		}
	},
	CITY6("방콕") {
		@Override
		public String getMoneyRateCode() {
			return "THB";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Baht";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Bangkok";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Bangkok";
		}
	},
	CITY7("푸켓") {
		@Override
		public String getMoneyRateCode() {
			return "THB";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Baht";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Phuket";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Bangkok";
		}
	},
	CITY8("파타야") {
		@Override
		public String getMoneyRateCode() {
			return "THB";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Baht";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Chonburi";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Bangkok";
		}
	},
	CITY9("(주)사무이") {
		@Override
		public String getMoneyRateCode() {
			return "THB";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Baht";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Ko%20Samui";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Bangkok";
		}
	},
	CITY10("타이페이") {
		@Override
		public String getMoneyRateCode() {
			return "TWD";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "TDW";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Taipei";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Taipei";
		}
	},
	CITY11("씨엠립(앙코르왓)") {
		@Override
		public String getMoneyRateCode() {
			return "EUR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "$";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
		//	return "Angkor%20Wat";		api 에 정보없어서 싱가포르로 대체시킴.
			return "Singapore";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Ho_Chi_Minh";
		}
	},
	CITY12("하노이") {
		@Override
		public String getMoneyRateCode() {
			return "VND";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "VND";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "100";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Hanoi";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Ho_Chi_Minh";
		}
	},
	CITY13("호치민") {
		@Override
		public String getMoneyRateCode() {
			return "VND";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "VND";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "100";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Ho%20Chi%20Minh";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Ho_Chi_Minh";
		}
	},
	CITY14("보라카이") {
		@Override
		public String getMoneyRateCode() {
			return "PHP";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "P";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Kalibo";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Ho_Chi_Minh";
		}
	},
	CITY15("세부") {
		@Override
		public String getMoneyRateCode() {
			return "PHP";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "P";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Cebu";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Ho_Chi_Minh";
		}
	},
	CITY16("몰디브") {
		@Override
		public String getMoneyRateCode() {
			return "MVR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Rf";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
		//	return "Malee";			api 에 정보없어서 싱가포르로 대체시킴.
			return "Singapore";
		}

		@Override
		public String getTimeZone() {
			
			return "Indian/Maldives";
		}
	},
	CITY17("발리") {
		@Override
		public String getMoneyRateCode() {
			return "IDR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Rupiah";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "100";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Bali";
		}

		@Override
		public String getTimeZone() {
			
			return "Africa/Douala";
		}
	},
	CITY18("코타키나발루") {
		@Override
		public String getMoneyRateCode() {
			return "MYR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "RM";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Kota%20Kinabalu";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Kuching";
		}
	},
	CITY19("도쿄") {
		@Override
		public String getMoneyRateCode() {
			return "JPY";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Y";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "100";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Tokyo";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Tokyo";
		}
	},
	CITY20("오사카") {
		@Override
		public String getMoneyRateCode() {
			return "JPY";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Y";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "100";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Osaka";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Tokyo";
		}
	},
	CITY21("교토") {
		@Override
		public String getMoneyRateCode() {
			return "JPY";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Y";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "100";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Kyoto";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Tokyo";
		}
	},
	CITY22("후쿠오카") {
		@Override
		public String getMoneyRateCode() {
			return "JPY";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Y";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "100";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Fukuoka";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Tokyo";
		}
	},
	CITY23("유후인") {
		@Override
		public String getMoneyRateCode() {
			return "JPY";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Y";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "100";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Oita";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Tokyo";
		}
	},
	CITY24("런던") {
		@Override
		public String getMoneyRateCode() {
			return "GBP";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "GBP";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "London";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/London";
		}
	},
	CITY25("에딘버러") {
		@Override
		public String getMoneyRateCode() {
			return "GBP";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "GBP";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Edinburgh";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/London";
		}
	},
	CITY26("파리") {
		@Override
		public String getMoneyRateCode() {
			return "EUR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Euro";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Paris";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Paris";
		}
	},
	CITY27("니스") {
		@Override
		public String getMoneyRateCode() {
			return "EUR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Euro";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Nice";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Paris";
		}
	},
	CITY28("로마") {
		@Override
		public String getMoneyRateCode() {
			return "EUR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Euro";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Rome";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Rome";
		}
	},
	CITY29("베네치아") {
		@Override
		public String getMoneyRateCode() {
			return "EUR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Euro";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Venezia";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Rome";
		}
	},
	CITY30("피렌체") {
		@Override
		public String getMoneyRateCode() {
			return "EUR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Euro";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Firenze";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Rome";
		}
	},
	CITY31("밀라노") {
		@Override
		public String getMoneyRateCode() {
			return "EUR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Euro";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Milano";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Rome";
		}
	},
	CITY32("루체른") {
		@Override
		public String getMoneyRateCode() {
			return "CHF";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "SwF";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Luzern";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Zurich";
		}
	},
	CITY33("인터라켄") {
		@Override
		public String getMoneyRateCode() {
			return "CHF";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "SwF";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Interlaken";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Zurich";
		}
	},
	CITY34("취리히") {
		@Override
		public String getMoneyRateCode() {
			return "CHF";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "SwF";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Zurich";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Zurich";
		}
	},
	CITY35("암스테르담") {
		@Override
		public String getMoneyRateCode() {
			return "EUR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Euro";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Amsterdam";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Amsterdam";
		}
	},
	CITY36("뮌헨") {
		@Override
		public String getMoneyRateCode() {
			return "EUR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Euro";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Munich";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Berlin";
		}
	},
	CITY37("프랑크푸르트") {
		@Override
		public String getMoneyRateCode() {
			return "EUR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Euro";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Frankfurt";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Berlin";
		}
	},
	CITY38("프라하") {
		@Override
		public String getMoneyRateCode() {
			return "EUR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Euro";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Prague";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Prague";
		}
	},
	CITY39("부다페스트") {
		@Override
		public String getMoneyRateCode() {
			return "HUF";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Ft";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Budapest";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Budapest";
		}
	},
	CITY40("비엔나") {
		@Override
		public String getMoneyRateCode() {
			return "EUR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Euro";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Vienna";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Vienna";
		}
	},
	CITY41("잘츠부르크") {
		@Override
		public String getMoneyRateCode() {
			return "EUR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Euro";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Salzburg";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Vienna";
		}
	},
	CITY42("바르셀로나") {
		@Override
		public String getMoneyRateCode() {
			return "EUR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Euro";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Barcelona";
		}

		@Override
		public String getTimeZone() {
			
			return "America/Caracas";
		}
	},
	CITY43("산토리니") {
		@Override
		public String getMoneyRateCode() {
			return "EUR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Euro";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "milas";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Athens";
		}
	},
	CITY44("아테네") {
		@Override
		public String getMoneyRateCode() {
			return "EUR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Euro";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Athens";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Athens";
		}
	},
	CITY45("이스탄불") {
		@Override
		public String getMoneyRateCode() {
			return "TRY";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "TL";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Istanbul";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Istanbul";
		}
	},
	CITY46("카파도키아") {
		@Override
		public String getMoneyRateCode() {
			return "TRY";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "TL";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Cappadocia";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Istanbul";
		}
	},
	CITY47("두브로브니크") {
		@Override
		public String getMoneyRateCode() {
			return "HRK";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Kuna";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Dubrovnik";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Zagreb";
		}
	},
	CITY48("뉴욕") {
		@Override
		public String getMoneyRateCode() {
			return "USD";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "$";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "New%20York";
		}

		@Override
		public String getTimeZone() {
			
			return "America/New_York";
		}
	},
	CITY49("샌프란시스코") {
		@Override
		public String getMoneyRateCode() {
			return "USD";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "$";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "San%20Francisco";
		}

		@Override
		public String getTimeZone() {
			
			return "America/Los_Angeles";
		}
	},
	CITY50("라스베가스") {
		@Override
		public String getMoneyRateCode() {
			return "USD";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "$";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Las%20Vegas";
		}

		@Override
		public String getTimeZone() {
			
			return "America/Los_Angeles";
		}
	},
	CITY51("코펜하겐") {
		@Override
		public String getMoneyRateCode() {
			return "DKK";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Dkr";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "copenhagen";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Amsterdam";
		}
	},
	CITY52("사이판") {
		@Override
		public String getMoneyRateCode() {
			return "USD";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "$";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Saipan";
		}

		@Override
		public String getTimeZone() {
			
			return "Pacific/Saipan";
		}
	},
	CITY53("괌") {
		@Override
		public String getMoneyRateCode() {
			return "USD";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "$";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Guam";
		}

		@Override
		public String getTimeZone() {
			
			return "Pacific/Guam";
		}
	},
	CITY54("하와이") {
		@Override
		public String getMoneyRateCode() {
			return "USD";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "$";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Honolulu";
		}

		@Override
		public String getTimeZone() {
			
			return "US/Hawaii";
		}
	},
	CITY55("밴쿠버") {
		@Override
		public String getMoneyRateCode() {
			return "CAD";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Can$";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Vancouver";
		}

		@Override
		public String getTimeZone() {
			
			return "America/Vancouver";
		}
	},
	CITY56("시드니") {
		@Override
		public String getMoneyRateCode() {
			return "AUD";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "A$";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Sydney";
		}

		@Override
		public String getTimeZone() {
			
			return "Australia/Sydney";
		}
	},
	CITY57("브리즈번") {
		@Override
		public String getMoneyRateCode() {
			return "AUD";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "A$";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Brisbane";
		}

		@Override
		public String getTimeZone() {
			
			return "Australia/Brisbane";
		}
	},
	CITY58("스톡홀름") {
		@Override
		public String getMoneyRateCode() {
			return "SEK";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "skr";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "stockholm";
		}

		@Override
		public String getTimeZone() {
			
			return "Europe/Amsterdam";
		}
	},
	CITY59("퍼스") {
		@Override
		public String getMoneyRateCode() {
			return "AUD";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "A$";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Perth";
		}

		@Override
		public String getTimeZone() {
			
			return "Australia/Perth";
		}
	},
	CITY60("헬싱키") {
		@Override
		public String getMoneyRateCode() {
			return "EUR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Euro";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "helsinki";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Istanbul";
		}
	},
	CITY61("케이프타운") {
		@Override
		public String getMoneyRateCode() {
			return "ZAR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Rand";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Cape%20Town";
		}

		@Override
		public String getTimeZone() {
			
			return "Africa/Johannesburg";
		}
	},
	CITY62("요하네스버그") {
		@Override
		public String getMoneyRateCode() {
			return "ZAR";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "Rand";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Johannesburg";
		}

		@Override
		public String getTimeZone() {
			
			return "Africa/Johannesburg";
		}
	},
	CITY6237("마닐라") {
		@Override
		public String getMoneyRateCode() {
			return "PHP";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "P";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Manila";
		}

		@Override
		public String getTimeZone() {
			
			return "Asia/Ho_Chi_Minh";
		}
	}, 	
	CITY5819("뉴칼레도니아") {
		@Override
		public String getMoneyRateCode() {
			return "XPF";
		}

		@Override
		public String getMoneyRateChar() {
			
			return "XPF";
		}

		@Override
		public String getMoneyRatePrice() {
			
			return "1";
		}

		@Override
		public String getWeatherCityName() {
			
			return "Noumea";
		}

		@Override
		public String getTimeZone() {
			
			return "Australia/Sydney";
		}
	};
	

	private MoneyRateAndWeatherCityEnum(String cityId) {
		this.cityId = cityId;
	}
	
	private String cityId;

	public String getCityId() {
		return cityId;
	}

	public abstract String getMoneyRateCode(); 
	public abstract String getMoneyRateChar(); 
	public abstract String getMoneyRatePrice();
	public abstract String getWeatherCityName(); 
	public abstract String getTimeZone(); 
}
