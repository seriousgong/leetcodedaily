package m5

func strangePrinter(s string) int {
	alphet := [26]int{}
	for _, val := range s {
		alphet[val-'a']++
	}

}
