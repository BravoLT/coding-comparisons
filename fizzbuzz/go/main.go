package main

import (
	"flag"
	"fmt"
	"strconv"
	"time"
)

func fizzbuzz(n int) []string {
	defer timer("FizzBuzz")()
	var r = make([]string, n)
	for i := 1; i <= n; i++ {
		if i%15 == 0 {
			r[i-1] = "FizzBuzz"
		} else if i%3 == 0 {
			r[i-1] = "Fizz"
		} else if i%5 == 0 {
			r[i-1] = "Buzz"
		} else {
			r[i-1] = strconv.FormatInt(int64(i), 10)
		}
	}
	return r
}

func timer(name string) func() {
	start := time.Now()
	return func() {
		end := float64(time.Since(start).Nanoseconds()) / 1000.0

		fmt.Printf("%s took %v microseconds\n\n", name, end)
	}
}

func main() {
	count := flag.Int("count", 100, "")
	displayResults := flag.Bool("print", true, "")
	flag.Parse()
	r := fizzbuzz(*count)
	if *displayResults {
		fmt.Println(r)
	}
}
