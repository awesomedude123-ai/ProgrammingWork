const http = require("http");

//2. Create Web server and give required request handler
//req=request res=respomse
const server = http.createServer((req,res) => {
    console.log(req.method);
    console.log(req.url);

    res.end("<h1>Welcome!!</h1>");
});

//3 Start Server
server.listen(80, () => {
    console.log("Server starts at http://127.0.0.1:80.");

});

