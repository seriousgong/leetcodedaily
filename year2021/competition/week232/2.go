package week232

func findCenter(edges [][]int) int {
	arr := make([]int, len(edges)+1)
	for i := 0; i < len(edges); i++ {
		arr[edges[i][0]-1]++
		arr[edges[i][1]-1]++
	}
	res := 0
	for i := range arr {
		if arr[res] < arr[i] {
			res = i
		}
	}
	return res + 1
}
