// import the express
const express = require("express");

//import path module
const path = require("path");

//import third-party middleware cors
const cors = require("cors");

//create a web server
const app = express();

//apply third-party middleware cors
app.use(cors());

//App level middleware
app.use((req,res,next) => {
    const time = Date.now();
    req.reachTime = time;
    console.log(`${req.method}, ${req.url}, ${req.reachTime}`);
    next();//MUST
});

//Built-in middleware to parse request body
app.use(express.json());
app.use(express.urlencoded({extended:true}));

//built-in middleware: express.static()
app.use("/static",express.static("public"));

//use req.body to get path parameters for POST & PUT methods
app.post("/api/post", (req,res) => {
    console.log(req.body);
    res.send(req.body);
});

//use req.params to get path parameters for GET & DELETE methods
app.get("/api/get/:id/:type", (req,res) => {
    console.log(req.params);
    res.send("success");
});

//res.sendFile()
app.get("/download", (req,res) => {
    res.sendFile(path.join(__dirname,"Introduction.pdf"));
    //res.redirect("/payment");
});

//Define Middelware function
const middleware = (req,res,next) => {
    console.log("This is middleware Function");
    next();
};

const router = require("./account");
app.use(middleware,router);
// implement server code to handle requests

app.get("/payment", (req,res)=> {
    res.send(`${req.reachTime}`);
});

//start the server
app.listen(80, ()=>{
    console.log("Server is running on http://127.0.0.1:80/");
});