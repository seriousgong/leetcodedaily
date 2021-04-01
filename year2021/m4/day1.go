package m4

func clumsy(N int) int {

	res, flag := 0, 1
	for ; N > 0; N -= 4 {
		tmp := N * flag
		if N-1 > 0 {
			tmp *= N - 1
		}
		if N-2 > 0 {
			tmp /= N - 2
		}
		if N-3 > 0 {
			tmp += N - 3
		}
		if N-4 > 0 {
			flag = -1
		}
	}
	return res
}
