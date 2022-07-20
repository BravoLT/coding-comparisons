#include <iostream>
using std::cout;
using std::endl;

#include <string>
using std::string;
using std::to_string;

#include <vector>
using std::vector;

int main() {
    auto value = 16;
    vector<string> output;

    for(auto i = 1; i <= value; i++){
        auto isFizz = i % 3 == 0;
        auto isBuzz = i % 5 == 0;

        if(isFizz && isBuzz){
            output.push_back("FizzBuzz");
        }
        else if(isFizz){
            output.push_back("Fizz");
        }
        else if(isBuzz){
            output.push_back("Buzz");
        }
        else {
            output.push_back(to_string(i));
        }
    }
    for(auto v : output){
        cout << v << " ";
    }
    cout << endl;
    return 0;
}
