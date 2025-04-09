const fs = require("fs");

fs.writeFile("out.txt","Welcome to Node.js", (error) => {
    console.log(error);
    console.log(typeof error);
});