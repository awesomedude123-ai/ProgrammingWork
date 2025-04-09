//Import Express
const express = require("express");

//Create router of express
const router = express.Router();

//Function to get data
async function getData(postId){
    try{
        let response = await fetch(`https://jsonplaceholder.typicode.com/comments?postId=${postId}`);
        let data = await response.json();
        return data;
    }catch(e){
        console.error("Error:", e);
        throw new Error("Server Error");
    }
}


//Get Post ID Route
router.get("/comments", async (req,res) => {
    if(req.query.postId){
        var postId = req.query.postId;
        try{
            let data = await getData(postId);
            res.json(data);
        }catch(e){
            console.error(e);
            res.status(500).send("Server Error");
        }
    }else{
        res.send("Need to provide a post ID... /comments?postId=#");
    }
    
});

module.exports = router;