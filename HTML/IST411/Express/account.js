// import express
const express = require("express");
const router = express.Router();

router.get("/", (req,res)=>{
    //res.send("Hello from express server.");
    res.json({status:"success"});
});

router.post("/", (req, res) => {
    //res.send("This is a post response");
    res.json({status:"success"});
});

module.exports = router;