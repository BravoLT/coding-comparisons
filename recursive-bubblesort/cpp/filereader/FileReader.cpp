//
// Created by wheel on 8/1/2022.
//

#include <fstream>
using std::ifstream;

#include <processenv.h>

#include <string>
using std::getline;

#include "FileReader.h"

vector<string> FileReader::read(const LPCSTR& directory, const string& filename) {

    SetCurrentDirectoryA(directory);

    ifstream file(filename);
    string line;
    vector<string> data;

    while(getline(file, line)){
        data.push_back(line);
    }
    return data;
}
