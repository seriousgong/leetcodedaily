package main

import (
	"fmt"
	"sync"
)

func main() {
	//wg := &sync.WaitGroup{}
	ch := make(chan int)
	go func() {
		for i := range ch {
			go fmt.Println(i)
		}
	}()
	i := 0
	for ; i < 100; i++ {
		ch <- i
	}
}

func threeThreadOrderPrint2() {
	dog := make(chan string)
	fish := make(chan string)
	cat := make(chan string)
	wg := &sync.WaitGroup{}
	wg.Add(3)
	f := func() {
		for i := 0; i < 100; i++ {
			select {
			case str := <-dog:
				fmt.Println(str, i)
				fish <- "fish"
			case str := <-fish:
				fmt.Println(str)
				cat <- "cat"
			case str := <-cat:
				fmt.Println(str)
				if i < 99 {
					dog <- "dog"
				}
			}
		}
		wg.Done()
	}
	go f()
	go f()
	go f()
	dog <- "dog"
	wg.Wait()
}
func threeThreadOrderPrint() {
	dog := make(chan string)
	fish := make(chan string)
	cat := make(chan string)
	ex := make(chan int)
	f := func() {
		count := 0
		for ; count < 100; count++ {
			select {
			case str := <-dog:
				fmt.Println(str)
				fish <- "fish"
			case str := <-fish:
				fmt.Println(str)
				cat <- "cat"
			case str := <-cat:
				fmt.Println(str)
				if count < 99 {
					dog <- "dog"
				} else {
					ex <- 0
				}
			}
		}
	}
	go f()
	go f()
	go f()
	dog <- "dog"

	select {
	case exit := <-ex:
		fmt.Println(exit)
	}
}

func OrderToPrint() {
	lock := &sync.Mutex{}
	var i int64 = 0
	for i < 100 {
		go func() {
			lock.Lock()
			if i < 100 {
				i++
				fmt.Println(i)
			}
			lock.Unlock()
		}()
	}
}
