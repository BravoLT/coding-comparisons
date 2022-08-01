//
// Created by wheel on 7/31/2022.
//

#include <string>
#include <iostream>

using std::string;

#include "BubbleSort.h"

void BubbleSort::sort(vector<string>& data, int length) {
    if(length == 1){
        return;
    }
    auto count = 0;
    for(auto i = 0; i < length - 1; i++){
        const auto curVal = data[i];
        const auto nxtVal = data[i + 1];

        if(curVal.compare(nxtVal) > 0){
            data[i] = nxtVal;
            data[i + 1] = curVal;
            count++;
        }
    }
    if(count == 0){
        return;
    }
    sort(data, length - 1);
}

vector<std::pair<string, int>> BubbleSort::tally(vector<string> &data) {
    auto dataMapIndex = 0;
    std::pair<string, int> record;
    record.first = data[0];
    record.second = 1;

    vector<std::pair<string, int>> dataMap;
    dataMap.push_back(record);

    for (auto i = 1; i < data.size(); i++){
        std::pair<string, int>& prev = dataMap[dataMapIndex];
        if (prev.first == data[i]){
            prev.second++;
            continue;
        }
        record.first = data[i];
        record.second = 1;
        dataMap.push_back(record);
        dataMapIndex++;
    }
    return dataMap;
}
