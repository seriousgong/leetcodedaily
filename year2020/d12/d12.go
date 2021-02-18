package d12

func D12(asd string) string {
	return predictPartyVictory(asd)
}
func predictPartyVictory(senate string) string {

	rPower := 0
	dPower := 0
	length := len(senate)
	//mark := make([]bool, length)
	mark := []byte(senate)
	zero := 0
	for {
		for i := 0; i < length; i++ {
			if mark[i] == 0 {
				continue
			} else if senate[i] == 'R' {
				if dPower > 0 {
					mark[i] = 0
					zero++
					dPower--
					continue
				} else {
					rPower++
				}
			} else {
				if rPower > 0 {
					mark[i] = 0
					zero++
					rPower--
				} else {
					dPower++
				}
			}

		}
		if zero+rPower >= length || zero+dPower >= length {
			break
		}
	}
	if rPower != 0 {
		return "Radiant"
	} else {
		return "Dire"
	}
}
