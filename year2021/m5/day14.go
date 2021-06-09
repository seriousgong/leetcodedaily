package m5

var mp = map[int]string{
	1: "I", 5: "V", 10: "X", 50: "L", 100: "C", 500: "D", 1000: "M"}

func intToRoman(num int) string {
	res := ""
	if num/1000 > 0 {
		for i := 0; i < num/1000; i++ {
			res += "M"
		}
		num %= 1000
	}
	if num/100 > 0 {
		if num > 600 && num < 900 {
			res += "D"
			for i := 0; i < (num-500)/100; i++ {
				res += "C"
			}
		} else if num >= 900 && num < 1000 {
			res += "CM"
		} else if num >= 500 && num < 600 {
			res += "D"
		} else if num >= 400 && num < 500 {
			res += "CD"
		} else {
			for i := 0; i < num/100; i++ {
				res += "C"
			}
		}
		num %= 100
	}
	if num/10 > 0 {
		if num >= 90 && num < 100 {
			res += "XC"
		} else if num > 50 && num < 90 {
			res += "L"
			for i := 0; i < (num-50)/10; i++ {
				res += "X"
			}
		} else if num >= 50 && num < 60 {
			res += "L"
		} else if num >= 40 && num < 50 {
			res += "XL"
		} else {
			for i := 0; i < num/10; i++ {
				res += "X"
			}
		}
		num %= 10
	}
	if num > 0 {
		if num == 9 {
			res += "IX"
		} else if num > 5 && num < 9 {
			res += "V"
			for i := 0; i < (num - 5); i++ {
				res += "I"
			}
		} else if num == 5 {
			res += "V"
		} else if num == 4 {
			res += "IV"
		} else {
			for i := 0; i < num; i++ {
				res += "I"
			}
		}
	}
	return res
}
