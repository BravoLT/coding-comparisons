//
// Created by wheel on 7/31/2022.
//

#ifndef CPP_BUBBLESORT_H
#define CPP_BUBBLESORT_H

#include <string>
using std::string;

#include <vector>
using std::vector;

class BubbleSort {

public:
    static void sort(vector<string>& data, int length);

    static vector<std::pair<string, int>> tally(vector<string>& data);
};


#endif //CPP_BUBBLESORT_H
