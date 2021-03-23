package m3

type ParkingSystem struct {
	Large int
	Mid   int
	Min   int
}

func Constructor(big int, medium int, small int) ParkingSystem {
	return ParkingSystem{
		Large: big,
		Mid:   medium,
		Min:   small,
	}
}

func (this *ParkingSystem) AddCar(carType int) bool {
	switch carType {
	case 1:
		if this.Large > 0 {
			this.Large--
			return true
		}
	case 2:
		if this.Mid > 0 {
			this.Mid--
			return true
		}
	case 3:
		if this.Min > 0 {
			this.Min--
			return true
		}
	}
	return false
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * obj := Constructor(big, medium, small);
 * param_1 := obj.AddCar(carType);
 */
