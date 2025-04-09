
//import fs module
const fs = require("fs");
const path = require("path");

//path
//encoding
//callback function
//path.join(__dirname,"example.txt")
fs.readFile("example.txt", "utf8", (error,data) => {
    //check the reading result 
    if (error) {
        //failed
        console.log("error: ",error);
        console.log(typeof error);
    }else{
        console.log("data: ", data);
        console.log(typeof data);
    }
});

