//
// Created by wheel on 8/1/2022.
//

#ifndef CPP_FILEREADER_H
#define CPP_FILEREADER_H

#include <processenv.h>
#include <string>
using std::string;

#include <vector>
using std::vector;

class FileReader {
public:
    static vector<string> read(const LPCSTR& directory, const string& filename);
};


#endif //CPP_FILEREADER_H
