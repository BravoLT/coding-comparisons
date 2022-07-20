package main

import (
	"bufio"
	"flag"
	"fmt"
	"io/ioutil"
	"os"
	"regexp"
	"strconv"
	"strings"
	"time"
)

func bubbleSort(arr []string, size int) []string {
	if size == 1 {
		return arr
	}

	var i = 0
	for i < size-1 {
		if arr[i] > arr[i+1] {
			arr[i], arr[i+1] = arr[i+1], arr[i]
		}
		i++
	}

	bubbleSort(arr, size-1)

	return arr
}

func readFromFileByLine(path string, mode int) ([]string, error) {
	var result []string
	file, err := os.Open(path)
	if err != nil {
		return nil, err
	}
	defer file.Close()

	scanner := bufio.NewScanner(file)
	re, err := regexp.Compile("^[a-zA-Z]+$")
	if err != nil {
		return nil, err
	}
	for scanner.Scan() {
		switch mode {
		case 1:
			w := scanner.Text()
			if re.MatchString(w) {
				result = append(result, w)
			}
		case 2:
			w := scanner.Text()
			if re.MatchString(w) {
				result = append(result, strings.ToLower(w))
			}
		default:
			result = append(result, scanner.Text())
		}
	}

	if err := scanner.Err(); err != nil {
		return nil, err
	}

	return result, nil
}

func writeToFile(words []string, mode int) {
	str := strings.Join(words, "\n")
	dt := time.Now().Format("2006-01-02T15:04:05Z07:00")
	filename := "mode-" + strconv.Itoa(mode) + "-" + dt + ".txt"
	ioutil.WriteFile(filename, []byte(str), 0644)
}

func main() {
	fp := flag.String("fp", "", "")
	mode := flag.Int("mode", 0, "")
	flag.Parse()
	if *fp == "" {
		fmt.Println("Please include file path using flag -fp")
		return
	}
	text, err := readFromFileByLine(string(*fp), *mode)
	if err != nil {
		fmt.Println(err)
		return
	}
	sorted := bubbleSort(text, len(text))
	writeToFile(sorted, *mode)
}
