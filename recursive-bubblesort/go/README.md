# Instructions
## Build
- run `go build`
## Run
- To run execute run rbsGo 
- Example `./rbsGo -fp ../../wordlistJustWordsRepeated.txt -mode 1`
 ### Flags
  - Filepath (required)
    - -fp
  - Mode
    - -mode
    - Options
      - 1 Only reads in words (no numbers in string) sorts alphabetically. A-Z then a-z
      - 2 Only reads in words (nu numbers in string) and converts all to lowercase and sorts alphabetically a-z
      - default reads in words as is and sorts alphabetically. 0-9, A-Z, then a-z