// import express
const express = require("express");

// create a web server
const app = express();

// import the modular routes
const router = require("./comments");
app.use(router);

app.use(express.json());
// mount the modular routes
const router1 = require("./posts");
app.use(router1);
// start the server
app.listen(80, () => {
  console.log("Server is running on http://127.0.0.1:80/");
});
