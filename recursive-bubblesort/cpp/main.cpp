
#include <algorithm>
using std::for_each;

#include <iostream>
using std::cout;
using std::endl;

#include <string>
using std::string;

#include <vector>
using std::vector;

#include "bubblesort/BubbleSort.h"
#include "filereader/FileReader.h"

int main(int argc, char** argv) {
    // extract file content from the filename
    auto directory = R"(C:\Users\wheel\IdeaProjects\coding-comparisons)";
    auto filename = "wordlistJustWordsRepeated.txt";
    vector<string> data = FileReader::read(directory, filename);

    // sort the file content with a recursive bubble sort algorithm
    BubbleSort::sort(data, static_cast<int>(data.size()));

    // tally the sorted file content to replace duplicates with number of occurrences
    auto dataMap = BubbleSort::tally(data);

    // print the sorted and tallied result
    for_each(dataMap.begin(), dataMap.end(), [](auto item){
        cout << "(" << item.first << "," << item.second << ")" << endl;
    });
    return 0;
}
